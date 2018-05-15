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

package manuylov.maxim.ocaml.lang.parser.psi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilderFactory;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import consulo.lang.LanguageVersion;
import consulo.lang.util.LanguageVersionUtil;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlModuleName;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlPathElement;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlStatement;

/**
 * @author Maxim.Manuylov
 *         Date: 23.03.2009
 */
public class OCamlPsiUtil
{
	@Nullable
	public static PsiElement getNonWhiteSpacePreviousLeaf(@Nonnull final PsiElement element, final boolean emptyErrorIsWhitespace)
	{
		PsiElement parent = element;
		PsiElement prevElement = getNonWhiteSpacePrevSibling(parent, emptyErrorIsWhitespace);

		while(prevElement == null)
		{
			parent = getParent(parent);
			if(parent == null)
			{
				break;
			}
			prevElement = getNonWhiteSpacePrevSibling(parent, emptyErrorIsWhitespace);
		}

		return prevElement == null ? null : getNonWhiteSpaceLastLeaf(prevElement, emptyErrorIsWhitespace);
	}

	@Nonnull
	public static PsiElement getNonWhiteSpaceLastLeaf(@Nonnull final PsiElement psiElement, final boolean emptyErrorIsWhitespace)
	{
		PsiElement result = psiElement;
		PsiElement lastChild = getNonWhiteSpaceLastChild(result, emptyErrorIsWhitespace);

		while(lastChild != null)
		{
			result = lastChild;
			lastChild = getNonWhiteSpaceLastChild(result, emptyErrorIsWhitespace);
		}

		return result;
	}

	@Nullable
	public static PsiElement getNonWhiteSpaceLastChild(@Nonnull final PsiElement element, final boolean emptyErrorIsWhitespace)
	{
		final PsiElement lastChild = element.getLastChild();
		if(lastChild == null || !isWhiteSpace(lastChild, emptyErrorIsWhitespace))
		{
			return lastChild;
		}
		return getNonWhiteSpacePrevSibling(lastChild, emptyErrorIsWhitespace);
	}

	@Nullable
	public static OCamlElement getPrevSibling(@Nonnull final PsiElement sibling)
	{
		PsiElement result = sibling;

		do
		{
			result = getStrictPrevSibling(result);
		}
		while(result != null && !(result instanceof OCamlElement));

		return (OCamlElement) result;
	}

	@Nullable
	public static PsiElement getStrictPrevSibling(@Nonnull final PsiElement element)
	{
		return ApplicationManager.getApplication().runReadAction(new Computable<PsiElement>()
		{
			public PsiElement compute()
			{
				return element.getPrevSibling();
			}
		});
	}

	@Nullable
	public static PsiElement getNonWhiteSpacePrevSibling(@Nonnull final PsiElement sibling, final boolean emptyErrorIsWhitespace)
	{
		PsiElement result = sibling;

		do
		{
			result = getStrictPrevSibling(result);
		}
		while(result != null && isWhiteSpace(result, emptyErrorIsWhitespace));

		return result;
	}

	@Nullable
	public static PsiElement getNonWhiteSpaceNextSibling(@Nonnull final PsiElement sibling, final boolean emptyErrorIsWhitespace)
	{
		PsiElement result = sibling;

		do
		{
			result = getStrictNextSibling(result);
		}
		while(result != null && isWhiteSpace(result, emptyErrorIsWhitespace));

		return result;
	}

	public static boolean isWhiteSpace(@Nonnull final PsiElement element, final boolean emptyErrorIsWhitespace)
	{
		return element instanceof PsiWhiteSpace || element instanceof PsiComment || emptyErrorIsWhitespace && isEmptyErrorMarker(element);
	}

	private static boolean isEmptyErrorMarker(@Nonnull final PsiElement element)
	{
		return isError(element) && getChildren(element).isEmpty();
	}

	@Nullable
	public static OCamlElement getNextSibling(@Nonnull final PsiElement sibling)
	{
		PsiElement result = sibling;

		do
		{
			result = getStrictNextSibling(result);
		}
		while(result != null && !(result instanceof OCamlElement));

		return (OCamlElement) result;
	}

	@Nullable
	private static PsiElement getStrictNextSibling(@Nonnull final PsiElement element)
	{
		return ApplicationManager.getApplication().runReadAction(new Computable<PsiElement>()
		{
			public PsiElement compute()
			{
				return element.getNextSibling();
			}
		});
	}

	@Nullable
	public static OCamlElement getParent(@Nonnull final PsiElement node)
	{
		final PsiElement result = getStrictParent(node);
		if(!(result instanceof OCamlElement))
		{
			return null;
		}
		return (OCamlElement) result;
	}

	@Nullable
	public static PsiElement getStrictParent(@Nonnull final PsiElement element)
	{
		return ApplicationManager.getApplication().runReadAction(new Computable<PsiElement>()
		{
			public PsiElement compute()
			{
				return element.getParent();
			}
		});
	}

	@Nullable
	public static <T extends PsiElement> T getParentOfType(@Nonnull final PsiElement element, @Nonnull final Class<T> clazz)
	{
		OCamlElement parent = element instanceof OCamlElement ? (OCamlElement) element : getParent(element);

		while(parent != null && !clazz.isInstance(parent))
		{
			parent = getParent(parent);
		}

		//noinspection unchecked
		return (T) parent;
	}

	public static boolean areSiblings(@Nonnull final OCamlElement firstNode, @Nonnull final OCamlElement secondNode)
	{
		return getParent(firstNode) == getParent(secondNode);
	}

	@Nonnull
	public static <T extends OCamlElement> List<T> getModulePath(@Nonnull final OCamlElement psiElement, @Nonnull final Class<T> siblingsType)
	{
		final List<T> result = new ArrayList<T>();

		if(!(psiElement.getParent() instanceof OCamlPathElement))
		{
			return result;
		}

		OCamlElement prevSibling = getPrevSibling(psiElement);

		while(prevSibling != null)
		{
			if(siblingsType.isInstance(prevSibling))
			{
				//noinspection unchecked
				result.add(0, (T) prevSibling);
			}
			prevSibling = getPrevSibling(prevSibling);
		}

		return result;
	}

	@Nonnull
	public static <T extends OCamlElement> List<T> getChildrenOfType(@Nonnull final PsiElement parent, @Nonnull final Class<T> type)
	{
		final List<T> result = new ArrayList<T>();

		final PsiElement[] children = ApplicationManager.getApplication().runReadAction(new Computable<PsiElement[]>()
		{
			public PsiElement[] compute()
			{
				return parent.getChildren();
			}
		});
		for(final PsiElement child : children)
		{
			if(type.isInstance(child))
			{
				//noinspection unchecked
				result.add((T) child);
			}
		}

		return result;
	}

	@Nonnull
	public static List<OCamlElement> getChildren(@Nonnull final PsiElement parent)
	{
		return getChildrenOfType(parent, OCamlElement.class);
	}

	@Nullable
	public static <T extends OCamlElement> T getFirstChildOfType(@Nonnull final PsiElement parent, @Nonnull final Class<T> type)
	{
		final List<OCamlElement> children = getChildren(parent);
		for(final OCamlElement child : children)
		{
			if(type.isInstance(child))
			{
				//noinspection unchecked
				return (T) child;
			}
		}
		return null;
	}

	@Nullable
	public static <T extends OCamlElement> T getLastChildOfType(@Nonnull final OCamlElement parent, @Nonnull final Class<T> type)
	{
		final List<OCamlElement> children = getChildren(parent);
		for(int i = children.size() - 1; i >= 0; i--)
		{
			final OCamlElement child = children.get(i);
			if(type.isInstance(child))
			{
				//noinspection unchecked
				return (T) child;
			}
		}
		return null;
	}

	@Nonnull
	public static List<? extends OCamlElement> getChildrenOfTypes(@Nonnull final OCamlElement parent, @Nonnull final Class<? extends OCamlElement>... types)
	{
		final List<OCamlElement> result = new ArrayList<OCamlElement>();

		final List<OCamlElement> children = getChildren(parent);
		for(final OCamlElement child : children)
		{
			for(final Class<? extends OCamlElement> type : types)
			{
				if(type.isInstance(child))
				{
					result.add(child);
				}
			}
		}

		return result;
	}

	public static List<OCamlModuleName> collectModuleReferences(@Nonnull final OCamlElement psiElement)
	{
		final List<OCamlModuleName> moduleReferences = new ArrayList<OCamlModuleName>();
		acceptRecursively(psiElement, new OCamlElementVisitorAdapter()
		{
			@Override
			public void visitModuleName(@Nonnull final OCamlModuleName psiElement)
			{
				moduleReferences.add(psiElement);
			}
		});
		return moduleReferences;
	}

	public static void acceptRecursively(@Nonnull final PsiElement psiElement, @Nonnull final PsiElementVisitor visitor)
	{
		final Stack<PsiElement> stack = new Stack<PsiElement>();
		stack.push(psiElement);
		while(!stack.isEmpty())
		{
			final PsiElement element = stack.pop();
			element.accept(visitor);
			stack.addAll(getChildren(element));
		}
	}

	@Nullable
	public static PsiElement findCommonParent(@Nonnull final PsiElement element1, @Nonnull final PsiElement element2)
	{
		if(element1 == element2)
		{
			return element1;
		}

		final ArrayList<PsiElement> parents1 = getParents(element1);
		final ArrayList<PsiElement> parents2 = getParents(element2);
		int size = Math.min(parents1.size(), parents2.size());
		for(int i = 1; i <= size; i++)
		{
			final PsiElement parent1 = parents1.get(parents1.size() - i);
			final PsiElement parent2 = parents2.get(parents2.size() - i);
			if(!parent1.equals(parent2))
			{
				return parent1;
			}
		}
		return null;
	}

	@Nonnull
	private static ArrayList<PsiElement> getParents(@Nonnull final PsiElement element)
	{
		final ArrayList<PsiElement> parents = new ArrayList<PsiElement>();
		PsiElement parent = element;
		while(parent != null)
		{
			parents.add(parent);
			parent = getParent(parent);
		}
		return parents;
	}

	@Nullable
	public static PsiElement findElementOfTypeInRange(@Nonnull final PsiElement root, @Nonnull final Class<? extends PsiElement> elementClass,
			final int startOffset, final int endOffset, final boolean emptyErrorIsWhitespace)
	{
		PsiElement element1 = root.findElementAt(startOffset);
		PsiElement element2 = root.findElementAt(endOffset - 1);

		if(element1 != null && isWhiteSpace(element1, emptyErrorIsWhitespace))
		{
			element1 = getNonWhiteSpaceNextSibling(element1, true);
		}

		if(element2 != null && isWhiteSpace(element2, emptyErrorIsWhitespace))
		{
			element2 = getNonWhiteSpacePrevSibling(element2, emptyErrorIsWhitespace);
		}

		if(element1 == null || element2 == null)
		{
			return null;
		}

		final PsiElement commonParent = findCommonParent(element1, element2);
		if(commonParent == null)
		{
			return null;
		}

		final PsiElement parent = getParentOfType(commonParent, elementClass);
		if(parent != null && new TextRange(startOffset, endOffset).contains(parent.getTextRange()))
		{
			return parent;
		}

		return null;
	}

	@Nullable
	public static PsiElement findElementInRange(@Nonnull final String text, @Nonnull final TextRange range, @Nonnull final Language language,
			@Nonnull final Project project)
	{
		final ParserDefinition parserDefinition = LanguageParserDefinitions.INSTANCE.forLanguage(language);
		if(parserDefinition == null)
		{
			return null;
		}

		final PsiElement psiRoot = parse(text, parserDefinition, project, false, LanguageVersionUtil.findDefaultVersion(language));

		return findElementInRange(psiRoot, range);
	}

	@Nonnull
	public static PsiElement parse(@Nonnull final CharSequence text, @Nonnull final ParserDefinition parserDefinition,
			@Nonnull final Project project, final boolean isTestMode, LanguageVersion languageVersion)
	{
		final Lexer lexer = parserDefinition.createLexer(languageVersion);
		final PsiParser parser = parserDefinition.createParser(languageVersion);
		final PsiBuilder builder = PsiBuilderFactory.getInstance().createBuilder(parserDefinition, lexer, languageVersion, text);
		builder.setDebugMode(isTestMode);
		return parserDefinition.createElement(parser.parse(parserDefinition.getFileNodeType(), builder, languageVersion));
	}

	public static boolean endsCorrectlyIfOCamlElement(@Nonnull final PsiElement element)
	{
		return !(element instanceof OCamlElement) || ((OCamlElement) element).endsCorrectly();
	}

	public static boolean endsWith(@Nonnull final OCamlElement element, @Nonnull final IElementType type)
	{
		return getLastNodeType(element) == type;
	}

	public static boolean endsWith(@Nonnull final OCamlElement element, @Nonnull final TokenSet tokenSet)
	{
		return tokenSet.contains(getLastNodeType(element));
	}

	@Nullable
	private static IElementType getLastNodeType(@Nonnull final OCamlElement element)
	{
		final PsiElement lastChild = getLastChild(element);
		if(lastChild == null)
		{
			return null;
		}
		final ASTNode node = lastChild.getNode();
		if(node == null)
		{
			return null;
		}
		return node.getElementType();
	}

	public static boolean endsCorrectlyWith(@Nonnull final OCamlElement element, @Nonnull final Class<? extends OCamlElement> clazz)
	{
		final PsiElement lastChild = getLastChild(element);
		return lastChild != null && clazz.isInstance(lastChild) && ((OCamlElement) lastChild).endsCorrectly();
	}

	@Nullable
	private static PsiElement getLastChild(@Nonnull final OCamlElement element)
	{
		return ApplicationManager.getApplication().runReadAction(new Computable<PsiElement>()
		{
			public PsiElement compute()
			{
				return element.getLastChild();
			}
		});
	}

	@Nullable
	public static OCamlStatement getStatementOf(@Nonnull final PsiElement element)
	{
		return OCamlPsiUtil.getParentOfType(element, OCamlStatement.class);
	}

	public static boolean isError(@Nonnull final PsiElement element)
	{
		return element instanceof PsiErrorElement;
	}

	public static boolean isFirstChildOf(@Nonnull final PsiElement parent, @Nonnull final PsiElement element)
	{
		PsiElement current = element;
		while(current != null)
		{
			if(current == parent)
			{
				return true;
			}
			if(OCamlPsiUtil.getStrictPrevSibling(current) != null)
			{
				break;
			}
			current = OCamlPsiUtil.getParent(current);
		}
		return false;
	}

	public static boolean hasChildOfType(@Nonnull final PsiElement parent, @Nonnull final Class<? extends OCamlElement> clazz)
	{
		return !getChildrenOfType(parent, clazz).isEmpty();
	}

	@Nonnull
	public static PsiElement copy(@Nonnull final PsiElement element)
	{
		final PsiElement fileCopy = element.getContainingFile().copy();
		final TextRange range = element.getTextRange();
		final PsiElement result = findElementInRange(fileCopy, range);
		assert result != null;
		return result;
	}

	@Nullable
	public static PsiElement findElementInRange(@Nonnull final PsiElement root, @Nonnull final TextRange range)
	{
		return findElementOfTypeInRange(root, PsiElement.class, range.getStartOffset(), range.getEndOffset(), true);
	}

	public static boolean isParentOf(@Nonnull final PsiElement parent, @Nonnull final PsiElement child)
	{
		PsiElement current = child;
		while(current != null)
		{
			if(current == parent)
			{
				return true;
			}
			current = getParent(current);
		}
		return false;
	}
}
