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

package manuylov.maxim.ocaml.lang.parser;

import javax.annotation.Nonnull;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LanguageUtil;
import com.intellij.lang.ParserDefinition;
import com.intellij.lexer.Lexer;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import consulo.lang.LanguageVersion;
import manuylov.maxim.ocaml.lang.lexer.flex.OCamlParsingFlexLexer;
import manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes;
import manuylov.maxim.ocaml.lang.parser.ast.element.OCamlElementTypes;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlElementFactory;

/**
 * @author Maxim.Manuylov
 *         Date: 22.02.2009
 */
public abstract class BaseParserDefinition implements ParserDefinition
{
	@Override
	@Nonnull
	public Lexer createLexer(@Nonnull LanguageVersion languageVersion)
	{
		return doCreateLexer();
	}

	@Override
	@Nonnull
	public TokenSet getWhitespaceTokens(@Nonnull LanguageVersion languageVersion)
	{
		return OCamlTokenTypes.WHITE_SPACES;
	}

	@Override
	@Nonnull
	public TokenSet getCommentTokens(@Nonnull LanguageVersion languageVersion)
	{
		return OCamlTokenTypes.COMMENTS;
	}

	@Override
	@Nonnull
	public TokenSet getStringLiteralElements(@Nonnull LanguageVersion languageVersion)
	{
		return OCamlTokenTypes.STRING_LITERALS;
	}

	@Override
	@Nonnull
	public SpaceRequirements spaceExistanceTypeBetweenTokens(@Nonnull final ASTNode left, @Nonnull final ASTNode right)
	{
		if(left.getElementType() == OCamlElementTypes.LABEL_NAME && right.getElementType() == OCamlTokenTypes.COLON)
		{
			return SpaceRequirements.MUST_NOT;
		}
		return LanguageUtil.canStickTokensTogetherByLexer(left, right, doCreateLexer());
	}

	@Override
	@Nonnull
	public PsiElement createElement(@Nonnull final ASTNode astNode)
	{
		return OCamlElementFactory.INSTANCE.createElement(astNode);
	}

	@Nonnull
	private Lexer doCreateLexer()
	{
		return new OCamlParsingFlexLexer();
	}
}
