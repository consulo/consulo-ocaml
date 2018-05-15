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

package manuylov.maxim.ocaml.lang.feature.highlighting;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import manuylov.maxim.ocaml.lang.lexer.OCamlHighlightingLexer;
import manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes;

/**
 * @author Maxim.Manuylov
 *         Date: 09.02.2009
 */
class OCamlSyntaxHighlighter extends SyntaxHighlighterBase
{
	@Nonnull
	private static final Map<IElementType, TextAttributesKey> keys = new HashMap<IElementType, TextAttributesKey>();

	@Nonnull
	public static final TextAttributesKey OCAML_KEYWORD = TextAttributesKey.createTextAttributesKey("OCAML.KEYWORD",
			DefaultLanguageHighlighterColors.KEYWORD);
	@Nonnull
	public static final TextAttributesKey OCAML_STRING = TextAttributesKey.createTextAttributesKey("OCAML.STRING",
			DefaultLanguageHighlighterColors.STRING);
	@Nonnull
	public static final TextAttributesKey OCAML_ESCAPE = TextAttributesKey.createTextAttributesKey("OCAML.ESCAPE",
			DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE);
	@Nonnull
	public static final TextAttributesKey OCAML_NUMBER = TextAttributesKey.createTextAttributesKey("OCAML.NUMBER",
			DefaultLanguageHighlighterColors.NUMBER);
	@Nonnull
	public static final TextAttributesKey OCAML_COMMENT = TextAttributesKey.createTextAttributesKey("OCAML.COMMENT",
			DefaultLanguageHighlighterColors.LINE_COMMENT);
	@Nonnull
	public static final TextAttributesKey OCAML_SYNTAX_SYMBOL = TextAttributesKey.createTextAttributesKey("OCAML.SYNTAX.SYMBOL",
			DefaultLanguageHighlighterColors.LABEL);

	@Nonnull
	public Lexer getHighlightingLexer()
	{
		return new OCamlHighlightingLexer();
	}

	@Nonnull
	public TextAttributesKey[] getTokenHighlights(@Nonnull final IElementType tokenType)
	{
		return pack(keys.get(tokenType));
	}

	static
	{
		fillMap(keys, OCamlTokenTypes.KEYWORDS, OCAML_KEYWORD);
		fillMap(keys, OCamlTokenTypes.COMMENTS, OCAML_COMMENT);

		keys.put(OCamlTokenTypes.INTEGER_LITERAL, OCAML_NUMBER);
		keys.put(OCamlTokenTypes.FLOAT_LITERAL, OCAML_NUMBER);
		keys.put(OCamlTokenTypes.REGULAR_CHARS, OCAML_STRING);
		keys.put(OCamlTokenTypes.ESCAPE_SEQUENCES, OCAML_ESCAPE);

		keys.put(OCamlTokenTypes.COMMA, OCAML_SYNTAX_SYMBOL);
		keys.put(OCamlTokenTypes.DOT, OCAML_SYNTAX_SYMBOL);
		keys.put(OCamlTokenTypes.SEMICOLON, OCAML_SYNTAX_SYMBOL);
		keys.put(OCamlTokenTypes.SEMICOLON_SEMICOLON, OCAML_SYNTAX_SYMBOL);

		keys.put(OCamlTokenTypes.BAD_CHARACTER, HighlighterColors.BAD_CHARACTER);
	}
}
