/*
 * OCaml Support For IntelliJ Platform.
 * Copyright (C) 2010 Maxim Manuylov
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/gpl-2.0.html>.
 */

package manuylov.maxim.ocaml.lang.feature.resolving.util;

import static com.intellij.psi.search.GlobalSearchScope.getScopeRestrictedByFileTypes;
import static com.intellij.psi.search.GlobalSearchScope.moduleWithDependenciesAndLibrariesScope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Computable;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import manuylov.maxim.ocaml.fileType.ml.MLFileType;
import manuylov.maxim.ocaml.fileType.mli.MLIFileType;
import manuylov.maxim.ocaml.lang.feature.resolving.ElementPosition;
import manuylov.maxim.ocaml.lang.feature.resolving.OCamlReference;
import manuylov.maxim.ocaml.lang.feature.resolving.OCamlResolvedReference;
import manuylov.maxim.ocaml.lang.feature.resolving.ResolvingBuilder;
import manuylov.maxim.ocaml.lang.feature.resolving.ResolvingContext;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlElement;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlPsiUtil;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlFile;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlModuleDefinitionBinding;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlModuleName;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlModuleSpecificationBinding;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlStructuredBinding;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlStructuredElement;
import manuylov.maxim.ocaml.util.OCamlCollectionsUtil;
import manuylov.maxim.ocaml.util.OCamlFileUtil;
import manuylov.maxim.ocaml.util.OCamlStringUtil;

/**
 * @author Maxim.Manuylov
 *         Date: 23.03.2009
 */
public class OCamlResolvingUtil
{
	@Nonnull
	public static final String PERVASIVES = "Pervasives";

	@Nonnull
	private static Map<String, OCamlElement> ourFakeModules = new HashMap<String, OCamlElement>();

	@Nonnull
	public static List<OCamlStructuredElement> findActualDefinitionsOfStructuredElementReference(@Nonnull final OCamlReference reference)
	{
		final OCamlResolvedReference resolvedReference = reference.resolve();
		if(resolvedReference == null || !(resolvedReference instanceof OCamlStructuredBinding))
		{
			return Collections.emptyList();
		}
		final OCamlStructuredBinding binding = (OCamlStructuredBinding) resolvedReference;
		return OCamlCollectionsUtil.createNotNullValuesList(binding.getExpression(), binding.getTypeExpression());
	}

	@Nonnull
	public static List<OCamlStructuredElement> collectActualDefinitionsOfStructuredElements(final OCamlStructuredElement... elements)
	{
		final List<OCamlStructuredElement> result = new ArrayList<OCamlStructuredElement>();
		for(final OCamlStructuredElement element : elements)
		{
			if(element != null)
			{
				result.addAll(element.findActualDefinitions());
			}
		}
		return result;
	}

	@Nullable
	public static PsiElement resolveWithFakeModules(@Nonnull final PsiReference reference, @Nonnull final OCamlFile... fakeModules)
	{
		try
		{
			for(final OCamlFile fakeModule : fakeModules)
			{
				final String moduleName = fakeModule.getModuleName();
				if(moduleName != null)
				{
					ourFakeModules.put(moduleName, fakeModule.getModuleBinding(OCamlStructuredBinding.class));
				}
			}
			return reference.resolve();
		}
		finally
		{
			ourFakeModules.clear();
		}
	}

	@Nonnull
	public static LookupElement[] getVariants(@Nonnull final ResolvingContext context, @Nonnull final List<Class<? extends OCamlResolvedReference>>
			types)
	{
		final VariantsCollectorProcessor processor = new VariantsCollectorProcessor(types);
		treeWalkUp(new ResolvingBuilder(processor, context));
		return processor.getCollectedVariants();
	}

	@Nullable
	public static OCamlResolvedReference resolve(@Nonnull final ResolvingContext context, @Nonnull final List<Class<? extends OCamlResolvedReference>>
			types)
	{
		final ResolvingProcessor processor = new ResolvingProcessor(types);
		treeWalkUp(new ResolvingBuilder(processor, context));
		return processor.getResolvedReference();
	}

	private static void treeWalkUp(@Nonnull final ResolvingBuilder builder)
	{
		OCamlElement parent = builder.getContext().getSourceElement();
		builder.setLastParent(parent);

		while(parent != null)
		{
			if(processParent(parent, builder))
			{
				return;
			}
			OCamlElement sibling = OCamlPsiUtil.getPrevSibling(parent);

			while(sibling != null)
			{
				if(processSibling(sibling, builder))
				{
					return;
				}
				sibling = OCamlPsiUtil.getPrevSibling(sibling);
			}

			builder.setLastParent(parent);
			parent = OCamlPsiUtil.getParent(parent);
		}

		if(builder.getModulePathOffset() == 0)
		{
			final PsiFile sourceFile = builder.getContext().getSourceElement().getContainingFile();
			if(sourceFile == null)
			{
				return;
			}

			if(tryProcessPervasives(builder, sourceFile))
			{
				return;
			}

			String moduleName = null;
			if(builder.getContext().getModulePath().size() > 0)
			{
				moduleName = builder.getCurrentModuleName();
			}
			else if(builder.getContext().getSourceElement() instanceof OCamlModuleName)
			{
				moduleName = builder.getContext().getSourceElement().getName();
			}
			if(moduleName != null)
			{
				final OCamlElement targetModule = findFileModule(sourceFile, moduleName);
				if(targetModule != null)
				{
					processSibling(targetModule, builder);
				}
			}
		}
	}

	private static boolean processParent(@Nonnull final OCamlElement parent, @Nonnull final ResolvingBuilder builder)
	{
		builder.setLastParentPosition(ElementPosition.Child);
		return parent.processDeclarations(builder);
	}

	private static boolean processSibling(@Nonnull final OCamlElement sibling, @Nonnull final ResolvingBuilder builder)
	{
		builder.setLastParentPosition(ElementPosition.Sibling);
		return sibling.processDeclarations(builder);
	}

	private static boolean tryProcessPervasives(@Nonnull final ResolvingBuilder builder, @Nonnull final PsiFile sourceFile)
	{
		final OCamlElement pervasivesModule = findFileModule(sourceFile, PERVASIVES);
		if(pervasivesModule != null)
		{
			try
			{
				builder.pervasivesProcessingStarted();
				return processSibling(pervasivesModule, builder);
			}
			finally
			{
				builder.pervasivesProcessingFinished();
			}
		}
		return false;
	}

	@Nullable
	private static OCamlElement findFileModule(@Nonnull final PsiFile sourceFile, @Nonnull final String moduleName)
	{
		final OCamlElement fakeModule = ourFakeModules.get(moduleName);
		if(fakeModule != null)
		{
			return fakeModule;
		}

		if(OCamlFileUtil.isImplementationFile(sourceFile))
		{
			final OCamlElement targetModule = findFileModuleDefinition(sourceFile, moduleName);
			if(targetModule != null)
			{
				return targetModule;
			}
		}

		return findFileModuleSpecification(sourceFile, moduleName);
	}

	@Nullable
	public static OCamlModuleDefinitionBinding findFileModuleDefinition(@Nonnull final PsiFile sourceFile, @Nonnull final String moduleName)
	{
		return doFindFileModule(sourceFile, moduleName, MLFileType.INSTANCE, OCamlModuleDefinitionBinding.class);
	}

	@Nullable
	public static OCamlModuleSpecificationBinding findFileModuleSpecification(@Nonnull final PsiFile sourceFile, @Nonnull final String moduleName)
	{
		return doFindFileModule(sourceFile, moduleName, MLIFileType.INSTANCE, OCamlModuleSpecificationBinding.class);
	}

	@SuppressWarnings({"unchecked"})
	@Nullable
	private static <T extends OCamlStructuredBinding> T doFindFileModule(@Nonnull final PsiFile sourceFile, @Nonnull final String moduleName,
			@Nonnull final FileType fileType, @Nonnull final Class<T> type)
	{
		final Project project = sourceFile.getProject();

		final Module module = ModuleUtil.findModuleForPsiElement(sourceFile);
		if(module == null)
		{
			return null;
		}

		final String fileName = OCamlFileUtil.getFileName(moduleName, fileType);
		final GlobalSearchScope scope = getScopeRestrictedByFileTypes(moduleWithDependenciesAndLibrariesScope(module), fileType);
		final T file = findFileModuleByFileName(project, scope, type, fileName);
		return file == null ? findFileModuleByFileName(project, scope, type, OCamlStringUtil.changeFirstLetterCase(fileName)) : file;
	}

	@Nullable
	private static <T extends OCamlStructuredBinding> T findFileModuleByFileName(@Nonnull final Project project,
			@Nonnull final GlobalSearchScope scope, @Nonnull final Class<T> type, @Nonnull final String fileName)
	{
		final PsiFile[] files = ApplicationManager.getApplication().runReadAction(new Computable<PsiFile[]>()
		{
			public PsiFile[] compute()
			{
				return FilenameIndex.getFilesByName(project, fileName, scope);
			}
		});

		for(final PsiFile file : files)
		{
			if(file instanceof OCamlFile)
			{
				final T moduleBinding = ((OCamlFile) file).getModuleBinding(type);
				if(moduleBinding != null)
				{
					return moduleBinding;
				}
			}
		}

		return null;
	}
}
