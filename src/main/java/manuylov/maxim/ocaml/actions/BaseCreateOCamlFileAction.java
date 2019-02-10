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

package manuylov.maxim.ocaml.actions;

import java.io.File;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

import com.intellij.ide.IdeView;
import com.intellij.ide.actions.CreateElementActionBase;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import consulo.ui.image.Image;
import manuylov.maxim.ocaml.util.OCamlFileUtil;
import manuylov.maxim.ocaml.util.OCamlModuleUtil;

/**
 * @author Maxim.Manuylov
 *         Date: 13.04.2010
 */
abstract class BaseCreateOCamlFileAction extends CreateElementActionBase
{
	@Nonnull
	private static final Pattern MODULE_NAME_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9_']*");

	protected BaseCreateOCamlFileAction(@Nonnull final String text, @Nonnull final String description, @Nonnull final Image icon)
	{
		super(text, description, icon);
	}

	@Nonnull
	protected abstract String getCapitalizedType();

	@Nonnull
	protected abstract FileType getFileType();

	@Nonnull
	@Override
	protected PsiElement[] invokeDialog(@Nonnull final Project project, @Nonnull final PsiDirectory directory)
	{
		final MyInputValidator validator = new MyInputValidator(project, directory);
		Messages.showInputDialog(project, "Enter module name:", "New OCaml Module " + getCapitalizedType() + " File", Messages.getQuestionIcon(), null,
				validator);
		return validator.getCreatedElements();
	}

	@Nonnull
	protected String getFileName(@Nonnull final String newName)
	{
		return OCamlFileUtil.getFileName(newName, getFileType());
	}

	@Nonnull
	@Override
	protected PsiElement[] create(final String newName, final PsiDirectory directory) throws Exception
	{
		return new PsiElement[]{directory.createFile(getFileName(newName))};
	}

	@Override
	protected boolean isAvailable(@Nonnull final DataContext dataContext)
	{
		final Project project = dataContext.getData(PlatformDataKeys.PROJECT);
		if(project == null)
		{
			return false;
		}

		if(DumbService.getInstance(project).isDumb() && !isDumbAware())
		{
			return false;
		}

		final IdeView view = dataContext.getData(LangDataKeys.IDE_VIEW);
		if(view == null || view.getDirectories().length == 0)
		{
			return false;
		}

		final PsiDirectory dir = view.getOrChooseDirectory();
		if(dir == null)
		{
			return false;
		}

		final VirtualFile virtualDir = dir.getVirtualFile();

		final Module module = ModuleUtil.findModuleForFile(virtualDir, project);
		//noinspection SimplifiableIfStatement
		if(!OCamlModuleUtil.hasOCamlExtension(module))
		{
			return false;
		}

		return ModuleRootManager.getInstance(module).getFileIndex().isInSourceContent(virtualDir);
	}

	@Override
	@Nonnull
	protected String getErrorTitle()
	{
		return "Cannot create OCaml module " + getType() + " file";
	}

	@Nonnull
	private String getType()
	{
		return getCapitalizedType().toLowerCase();
	}

	@Override
	@Nonnull
	protected String getCommandName()
	{
		return "Create OCaml module " + getType() + " file";
	}

	@Override
	@Nonnull
	protected String getActionName(@Nonnull final PsiDirectory directory, @Nonnull final String newName)
	{
		return "Creating file \"" + FileUtil.toSystemDependentName(new File(directory.getVirtualFile().getPath(),
				getFileName(newName)).getAbsolutePath()) + "\"...";
	}
}