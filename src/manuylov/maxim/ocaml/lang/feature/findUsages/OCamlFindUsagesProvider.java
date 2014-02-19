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

package manuylov.maxim.ocaml.lang.feature.findUsages;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import manuylov.maxim.ocaml.lang.feature.resolving.OCamlNamedElement;
import manuylov.maxim.ocaml.lang.lexer.OCamlHighlightingLexer;
import manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes;
import manuylov.maxim.ocaml.util.OCamlStringUtil;

/**
 * @author Maxim.Manuylov
 *         Date: 26.04.2010
 */
public class OCamlFindUsagesProvider implements FindUsagesProvider
{
	@Override
	@NotNull
	public WordsScanner getWordsScanner()
	{
		DefaultWordsScanner defaultWordsScanner = new DefaultWordsScanner(new OCamlHighlightingLexer(), OCamlTokenTypes.DWS_IDENTIFIERS,
				OCamlTokenTypes.DWS_COMMENTS, OCamlTokenTypes.DWS_LITERALS);
		defaultWordsScanner.setMayHaveFileRefsInLiterals(true);

		return defaultWordsScanner;
	}

	@Override
	public boolean canFindUsagesFor(@NotNull final PsiElement psiElement)
	{
		return true;
	}

	@Override
	@Nullable
	public String getHelpId(@NotNull final PsiElement psiElement)
	{
		return null;
	}

	@Override
	@NotNull
	public String getType(@NotNull final PsiElement element)
	{
		if(element instanceof OCamlNamedElement)
		{
			return ((OCamlNamedElement) element).getDescription();
		}
		return "";
	}

	@Override
	@NotNull
	public String getDescriptiveName(@NotNull final PsiElement element)
	{
		return getName(element);
	}

	@Override
	@NotNull
	public String getNodeText(@NotNull final PsiElement element, final boolean useFullName)
	{
		final StringBuilder sb = new StringBuilder(OCamlStringUtil.firstLetterToUpperCase(getType(element)));
		if(sb.length() > 0)
		{
			sb.append(" ");
		}
		sb.append(useFullName ? getCanonicalPath(element) : getName(element));
		return sb.toString();
	}

	@NotNull
	private String getName(@NotNull final PsiElement element)
	{
		if(element instanceof OCamlNamedElement)
		{
			return OCamlStringUtil.getNotNull(((OCamlNamedElement) element).getName());
		}
		return "";
	}

	@NotNull
	private String getCanonicalPath(@NotNull final PsiElement element)
	{
		if(element instanceof OCamlNamedElement)
		{
			return OCamlStringUtil.getNotNull(((OCamlNamedElement) element).getCanonicalPath());
		}
		return "";
	}
}
