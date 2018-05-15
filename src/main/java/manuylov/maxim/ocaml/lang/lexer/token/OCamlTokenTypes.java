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

package manuylov.maxim.ocaml.lang.lexer.token;

import javax.annotation.Nonnull;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import manuylov.maxim.ocaml.lang.OCamlElementType;

/**
 * @author Maxim.Manuylov
 *         Date: 05.02.2009
 */
public interface OCamlTokenTypes
{
	@Nonnull
	IElementType WHITE_SPACE = TokenType.WHITE_SPACE;
	@Nonnull
	IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;

	@Nonnull
	IElementType COMMENT = new OCamlElementType("COMMENT");
	@Nonnull
	IElementType COMMENT_BEGIN = new OCamlElementType("COMMENT_BEGIN");
	@Nonnull
	IElementType COMMENT_END = new OCamlElementType("COMMENT_END");

	@Nonnull
	IElementType AND_KEYWORD = new OCamlElementType("AND_KEYWORD");
	@Nonnull
	IElementType AS_KEYWORD = new OCamlElementType("AS_KEYWORD");
	@Nonnull
	IElementType ASSERT_KEYWORD = new OCamlElementType("ASSERT_KEYWORD");
	@Nonnull
	IElementType ASR_KEYWORD = new OCamlElementType("ASR_KEYWORD");
	@Nonnull
	IElementType BEGIN_KEYWORD = new OCamlElementType("BEGIN_KEYWORD");
	@Nonnull
	IElementType CLASS_KEYWORD = new OCamlElementType("CLASS_KEYWORD");
	@Nonnull
	IElementType CONSTRAINT_KEYWORD = new OCamlElementType("CONSTRAINT_KEYWORD");
	@Nonnull
	IElementType DO_KEYWORD = new OCamlElementType("DO_KEYWORD");
	@Nonnull
	IElementType DONE_KEYWORD = new OCamlElementType("DONE_KEYWORD");
	@Nonnull
	IElementType DOWNTO_KEYWORD = new OCamlElementType("DOWNTO_KEYWORD");
	@Nonnull
	IElementType ELSE_KEYWORD = new OCamlElementType("ELSE_KEYWORD");
	@Nonnull
	IElementType END_KEYWORD = new OCamlElementType("END_KEYWORD");
	@Nonnull
	IElementType EXCEPTION_KEYWORD = new OCamlElementType("EXCEPTION_KEYWORD");
	@Nonnull
	IElementType EXTERNAL_KEYWORD = new OCamlElementType("EXTERNAL_KEYWORD");
	@Nonnull
	IElementType FALSE_KEYWORD = new OCamlElementType("FALSE_KEYWORD");
	@Nonnull
	IElementType FOR_KEYWORD = new OCamlElementType("FOR_KEYWORD");
	@Nonnull
	IElementType FUN_KEYWORD = new OCamlElementType("FUN_KEYWORD");
	@Nonnull
	IElementType FUNCTION_KEYWORD = new OCamlElementType("FUNCTION_KEYWORD");
	@Nonnull
	IElementType FUNCTOR_KEYWORD = new OCamlElementType("FUNCTOR_KEYWORD");
	@Nonnull
	IElementType IF_KEYWORD = new OCamlElementType("IF_KEYWORD");
	@Nonnull
	IElementType IN_KEYWORD = new OCamlElementType("IN_KEYWORD");
	@Nonnull
	IElementType INCLUDE_KEYWORD = new OCamlElementType("INCLUDE_KEYWORD");
	@Nonnull
	IElementType INHERIT_KEYWORD = new OCamlElementType("INHERIT_KEYWORD");
	@Nonnull
	IElementType INITIALIZER_KEYWORD = new OCamlElementType("INITIALIZER_KEYWORD");
	@Nonnull
	IElementType LAND_KEYWORD = new OCamlElementType("LAND_KEYWORD");
	@Nonnull
	IElementType LAZY_KEYWORD = new OCamlElementType("LAZY_KEYWORD");
	@Nonnull
	IElementType LET_KEYWORD = new OCamlElementType("LET_KEYWORD");
	@Nonnull
	IElementType LOR_KEYWORD = new OCamlElementType("LOR_KEYWORD");
	@Nonnull
	IElementType LSR_KEYWORD = new OCamlElementType("LSR_KEYWORD");
	@Nonnull
	IElementType LSL_KEYWORD = new OCamlElementType("LSL_KEYWORD");
	@Nonnull
	IElementType LXOR_KEYWORD = new OCamlElementType("LXOR_KEYWORD");
	@Nonnull
	IElementType MATCH_KEYWORD = new OCamlElementType("MATCH_KEYWORD");
	@Nonnull
	IElementType METHOD_KEYWORD = new OCamlElementType("METHOD_KEYWORD");
	@Nonnull
	IElementType MOD_KEYWORD = new OCamlElementType("MOD_KEYWORD");
	@Nonnull
	IElementType MODULE_KEYWORD = new OCamlElementType("MODULE_KEYWORD");
	@Nonnull
	IElementType MUTABLE_KEYWORD = new OCamlElementType("MUTABLE_KEYWORD");
	@Nonnull
	IElementType NEW_KEYWORD = new OCamlElementType("NEW_KEYWORD");
	@Nonnull
	IElementType OBJECT_KEYWORD = new OCamlElementType("OBJECT_KEYWORD");
	@Nonnull
	IElementType OF_KEYWORD = new OCamlElementType("OF_KEYWORD");
	@Nonnull
	IElementType OPEN_KEYWORD = new OCamlElementType("OPEN_KEYWORD");
	@Nonnull
	IElementType OR_KEYWORD = new OCamlElementType("OR_KEYWORD");
	@Nonnull
	IElementType PRIVATE_KEYWORD = new OCamlElementType("PRIVATE_KEYWORD");
	@Nonnull
	IElementType REC_KEYWORD = new OCamlElementType("REC_KEYWORD");
	@Nonnull
	IElementType SIG_KEYWORD = new OCamlElementType("SIG_KEYWORD");
	@Nonnull
	IElementType STRUCT_KEYWORD = new OCamlElementType("STRUCT_KEYWORD");
	@Nonnull
	IElementType THEN_KEYWORD = new OCamlElementType("THEN_KEYWORD");
	@Nonnull
	IElementType TO_KEYWORD = new OCamlElementType("TO_KEYWORD");
	@Nonnull
	IElementType TRUE_KEYWORD = new OCamlElementType("TRUE_KEYWORD");
	@Nonnull
	IElementType TRY_KEYWORD = new OCamlElementType("TRY_KEYWORD");
	@Nonnull
	IElementType TYPE_KEYWORD = new OCamlElementType("TYPE_KEYWORD");
	@Nonnull
	IElementType VAL_KEYWORD = new OCamlElementType("VAL_KEYWORD");
	@Nonnull
	IElementType VIRTUAL_KEYWORD = new OCamlElementType("VIRTUAL_KEYWORD");
	@Nonnull
	IElementType WHEN_KEYWORD = new OCamlElementType("WHEN_KEYWORD");
	@Nonnull
	IElementType WHILE_KEYWORD = new OCamlElementType("WHILE_KEYWORD");
	@Nonnull
	IElementType WITH_KEYWORD = new OCamlElementType("WITH_KEYWORD");

	@Nonnull
	IElementType NOT_EQ = new OCamlElementType("NOT_EQ"); // !=
	@Nonnull
	IElementType HASH = new OCamlElementType("HASH"); // #
	@Nonnull
	IElementType AMP = new OCamlElementType("AMP"); // &
	@Nonnull
	IElementType AMP_AMP = new OCamlElementType("AMP_AMP"); // &&
	@Nonnull
	IElementType QUOTE = new OCamlElementType("QUOTE"); // '
	@Nonnull
	IElementType LPAR = new OCamlElementType("LPAR"); // (
	@Nonnull
	IElementType RPAR = new OCamlElementType("RPAR"); // )
	@Nonnull
	IElementType MULT = new OCamlElementType("MULT"); // *
	@Nonnull
	IElementType PLUS = new OCamlElementType("PLUS"); // +
	@Nonnull
	IElementType COMMA = new OCamlElementType("COMMA"); // ,
	@Nonnull
	IElementType MINUS = new OCamlElementType("MINUS"); // -
	@Nonnull
	IElementType MINUS_DOT = new OCamlElementType("MINUS_DOT"); // -.
	@Nonnull
	IElementType MINUS_GT = new OCamlElementType("MINUS_GT"); // ->
	@Nonnull
	IElementType DOT = new OCamlElementType("DOT"); // .
	@Nonnull
	IElementType DOT_DOT = new OCamlElementType("DOT_DOT"); // ..
	@Nonnull
	IElementType COLON = new OCamlElementType("COLON"); // :
	@Nonnull
	IElementType COLON_COLON = new OCamlElementType("COLON_COLON"); // ::
	@Nonnull
	IElementType COLON_EQ = new OCamlElementType("COLON_EQ"); // :=
	@Nonnull
	IElementType COLON_GT = new OCamlElementType("COLON_GT"); // :>
	@Nonnull
	IElementType SEMICOLON = new OCamlElementType("SEMICOLON"); // ;
	@Nonnull
	IElementType SEMICOLON_SEMICOLON = new OCamlElementType("SEMICOLON_SEMICOLON"); // ;;
	@Nonnull
	IElementType LT = new OCamlElementType("LT"); // <
	@Nonnull
	IElementType LT_MINUS = new OCamlElementType("LT_MINUS"); // <-
	@Nonnull
	IElementType EQ = new OCamlElementType("EQ"); // =
	@Nonnull
	IElementType GT = new OCamlElementType("GT"); // >
	@Nonnull
	IElementType GT_RBRACKET = new OCamlElementType("GT_RBRACKET"); // >]
	@Nonnull
	IElementType GT_RBRACE = new OCamlElementType("GT_RBRACE"); // >}
	@Nonnull
	IElementType QUEST = new OCamlElementType("QUEST"); // ?
	@Nonnull
	IElementType QUEST_QUEST = new OCamlElementType("QUEST_QUEST"); // ??
	@Nonnull
	IElementType LBRACKET = new OCamlElementType("LBRACKET"); // [
	@Nonnull
	IElementType LBRACKET_LT = new OCamlElementType("LBRACKET_LT"); // [<
	@Nonnull
	IElementType LBRACKET_GT = new OCamlElementType("LBRACKET_GT"); // [>
	@Nonnull
	IElementType LBRACKET_VBAR = new OCamlElementType("LBRACKET_VBAR"); // [|
	@Nonnull
	IElementType RBRACKET = new OCamlElementType("RBRACKET"); // ]
	@Nonnull
	IElementType UNDERSCORE = new OCamlElementType("UNDERSCORE"); // _
	@Nonnull
	IElementType ACCENT = new OCamlElementType("ACCENT"); // `
	@Nonnull
	IElementType LBRACE = new OCamlElementType("LBRACE"); // {
	@Nonnull
	IElementType LBRACE_LT = new OCamlElementType("LBRACE_LT"); // {<
	@Nonnull
	IElementType VBAR = new OCamlElementType("VBAR"); // |
	@Nonnull
	IElementType VBAR_VBAR = new OCamlElementType("VBAR_VBAR"); // ||
	@Nonnull
	IElementType VBAR_RBRACKET = new OCamlElementType("VBAR_RBRACKET"); // |]
	@Nonnull
	IElementType RBRACE = new OCamlElementType("RBRACE"); // }
	@Nonnull
	IElementType TILDE = new OCamlElementType("TILDE"); // ~

    /* Camlp4 extensions compatibility { */

	@Nonnull
	IElementType PARSER_KEYWORD = new OCamlElementType("PARSER_KEYWORD");
	@Nonnull
	IElementType LT_LT = new OCamlElementType("LT_LT"); // <<
	@Nonnull
	IElementType LT_COLON = new OCamlElementType("LT_COLON"); // <:
	@Nonnull
	IElementType GT_GT = new OCamlElementType("GT_GT"); // >>
	@Nonnull
	IElementType DOLLAR = new OCamlElementType("DOLLAR"); // $
	@Nonnull
	IElementType DOLLAR_DOLLAR = new OCamlElementType("DOLLAR_DOLLAR"); // $$
	@Nonnull
	IElementType DOLLAR_COLON = new OCamlElementType("DOLLAR_COLON"); // $:

    /* } */

	@Nonnull
	IElementType LCFC_IDENTIFIER = new OCamlElementType("LCFC_IDENTIFIER");
	@Nonnull
	IElementType UCFC_IDENTIFIER = new OCamlElementType("UCFC_IDENTIFIER");

	@Nonnull
	IElementType INTEGER_LITERAL = new OCamlElementType("INTEGER_LITERAL");
	@Nonnull
	IElementType FLOAT_LITERAL = new OCamlElementType("FLOAT_LITERAL");
	@Nonnull
	IElementType CHAR_LITERAL = new OCamlElementType("CHAR_LITERAL");
	@Nonnull
	IElementType EMPTY_CHAR_LITERAL = new OCamlElementType("EMPTY_CHAR_LITERAL");
	@Nonnull
	IElementType STRING_LITERAL = new OCamlElementType("STRING_LITERAL");

	@Nonnull
	IElementType INFIX_OPERATOR = new OCamlElementType("INFIX_OPERATOR");
	@Nonnull
	IElementType PREFIX_OPERATOR = new OCamlElementType("PREFIX_OPERATOR");

    /* Highlighting only tokens { */

	@Nonnull
	IElementType REGULAR_CHARS = new OCamlElementType("REGULAR_CHARS");
	@Nonnull
	IElementType ESCAPE_SEQUENCES = new OCamlElementType("ESCAPE_SEQUENCES");
	@Nonnull
	IElementType OPENING_QUOTE = new OCamlElementType("OPENING_QUOTE"); // '
	@Nonnull
	IElementType CLOSING_QUOTE = new OCamlElementType("CLOSING_QUOTE"); // '
	@Nonnull
	IElementType OPENING_DOUBLE_QUOTE = new OCamlElementType("OPENING_DOUBLE_QUOTE"); // "
	@Nonnull
	IElementType CLOSING_DOUBLE_QUOTE = new OCamlElementType("CLOSING_DOUBLE_QUOTE"); // "

    /* } */

	@Nonnull
	TokenSet IDENTIFIERS = TokenSet.create(LCFC_IDENTIFIER, UCFC_IDENTIFIER);

	@Nonnull
	TokenSet KEYWORDS = TokenSet.create(AND_KEYWORD, AS_KEYWORD, ASSERT_KEYWORD, BEGIN_KEYWORD, CLASS_KEYWORD, CONSTRAINT_KEYWORD, DO_KEYWORD,
			DONE_KEYWORD, DOWNTO_KEYWORD, ELSE_KEYWORD, END_KEYWORD, EXCEPTION_KEYWORD, EXTERNAL_KEYWORD, FALSE_KEYWORD, FOR_KEYWORD, FUN_KEYWORD,
			FUNCTION_KEYWORD, FUNCTOR_KEYWORD, IF_KEYWORD, IN_KEYWORD, INCLUDE_KEYWORD, INHERIT_KEYWORD, INITIALIZER_KEYWORD, LAZY_KEYWORD, LET_KEYWORD,
			MATCH_KEYWORD, METHOD_KEYWORD, MODULE_KEYWORD, MUTABLE_KEYWORD, NEW_KEYWORD, OBJECT_KEYWORD, OF_KEYWORD, OPEN_KEYWORD, OR_KEYWORD,
			PARSER_KEYWORD, PRIVATE_KEYWORD, REC_KEYWORD, SIG_KEYWORD, STRUCT_KEYWORD, THEN_KEYWORD, TO_KEYWORD, TRUE_KEYWORD, TRY_KEYWORD, TYPE_KEYWORD,
			VAL_KEYWORD, VIRTUAL_KEYWORD, WHEN_KEYWORD, WHILE_KEYWORD, WITH_KEYWORD);

	@Nonnull
	TokenSet PREFIX_OPERATORS = TokenSet.create(PREFIX_OPERATOR, NOT_EQ, QUEST_QUEST);

	@Nonnull
	TokenSet INFIX_OPERATORS = TokenSet.create(INFIX_OPERATOR, EQ, LT, GT, AMP, PLUS, MINUS, MULT, DOLLAR, AMP_AMP, MINUS_DOT, VBAR_VBAR, LT_LT,
			LT_COLON, GT_GT, DOLLAR_DOLLAR, DOLLAR_COLON, OR_KEYWORD, COLON_EQ, MOD_KEYWORD, LAND_KEYWORD, LOR_KEYWORD, LXOR_KEYWORD, LSL_KEYWORD,
			LSR_KEYWORD, ASR_KEYWORD);

	@Nonnull
	TokenSet WHITE_SPACES = TokenSet.create(WHITE_SPACE);

	@Nonnull
	TokenSet STRING_LITERALS = TokenSet.create(STRING_LITERAL);
	@Nonnull
	TokenSet CHAR_LITERALS = TokenSet.create(CHAR_LITERAL, EMPTY_CHAR_LITERAL);
	@Nonnull
	TokenSet COMMENTS = TokenSet.create(COMMENT, COMMENT_BEGIN, COMMENT_END);

    /* TokenSets for DefaultWordsScanner { */

	@Nonnull
	TokenSet DWS_IDENTIFIERS = IDENTIFIERS;
	@Nonnull
	TokenSet DWS_COMMENTS = TokenSet.create(COMMENT);
	@Nonnull
	TokenSet DWS_LITERALS = TokenSet.create(INTEGER_LITERAL, FLOAT_LITERAL, REGULAR_CHARS, ESCAPE_SEQUENCES);

    /* } */

    /* TokenSets for QuoteHandler { */

	@Nonnull
	TokenSet QH_OPENING_QUOTES = TokenSet.create(OPENING_QUOTE, OPENING_DOUBLE_QUOTE);
	@Nonnull
	TokenSet QH_CLOSING_QUOTES = TokenSet.create(CLOSING_QUOTE, CLOSING_DOUBLE_QUOTE);
	@Nonnull
	TokenSet QH_STRING_LITERALS = TokenSet.create(REGULAR_CHARS, ESCAPE_SEQUENCES);

    /* } */
}

