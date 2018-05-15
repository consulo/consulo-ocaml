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

package manuylov.maxim.ocaml.lang;

import javax.annotation.Nonnull;

import manuylov.maxim.ocaml.lang.feature.completion.DoNotSuggestInCompletionVariants;

/**
 * @author Maxim.Manuylov
 *         Date: 26.04.2010
 */
public interface Keywords
{
	@Nonnull
	String AND_KEYWORD = "and";
	@Nonnull
	String AS_KEYWORD = "as";
	@Nonnull
	String ASSERT_KEYWORD = "assert";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String ASR_KEYWORD = "asr";
	@Nonnull
	String BEGIN_KEYWORD = "begin";
	@Nonnull
	String CLASS_KEYWORD = "class";
	@Nonnull
	String CONSTRAINT_KEYWORD = "constraint";
	@Nonnull
	String DO_KEYWORD = "do";
	@Nonnull
	String DONE_KEYWORD = "done";
	@Nonnull
	String DOWNTO_KEYWORD = "downto";
	@Nonnull
	String ELSE_KEYWORD = "else";
	@Nonnull
	String END_KEYWORD = "end";
	@Nonnull
	String EXCEPTION_KEYWORD = "exception";
	@Nonnull
	String EXTERNAL_KEYWORD = "external";
	@Nonnull
	String FALSE_KEYWORD = "false";
	@Nonnull
	String FOR_KEYWORD = "for";
	@Nonnull
	String FUN_KEYWORD = "fun";
	@Nonnull
	String FUNCTION_KEYWORD = "function";
	@Nonnull
	String FUNCTOR_KEYWORD = "functor";
	@Nonnull
	String IF_KEYWORD = "if";
	@Nonnull
	String IN_KEYWORD = "in";
	@Nonnull
	String INCLUDE_KEYWORD = "include";
	@Nonnull
	String INHERIT_KEYWORD = "inherit";
	@Nonnull
	String INITIALIZER_KEYWORD = "initializer";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String LAND_KEYWORD = "land";
	@Nonnull
	String LAZY_KEYWORD = "lazy";
	@Nonnull
	String LET_KEYWORD = "let";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String LOR_KEYWORD = "lor";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String LSR_KEYWORD = "lsr";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String LSL_KEYWORD = "lsl";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String LXOR_KEYWORD = "lxor";
	@Nonnull
	String MATCH_KEYWORD = "match";
	@Nonnull
	String METHOD_KEYWORD = "method";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String MOD_KEYWORD = "mod";
	@Nonnull
	String MODULE_KEYWORD = "module";
	@Nonnull
	String MUTABLE_KEYWORD = "mutable";
	@Nonnull
	String NEW_KEYWORD = "new";
	@Nonnull
	String OBJECT_KEYWORD = "object";
	@Nonnull
	String OF_KEYWORD = "of";
	@Nonnull
	String OPEN_KEYWORD = "open";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String OR_KEYWORD = "or";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String PARSER_KEYWORD = "parser";
	@Nonnull
	String PRIVATE_KEYWORD = "private";
	@Nonnull
	String REC_KEYWORD = "rec";
	@Nonnull
	String SIG_KEYWORD = "sig";
	@Nonnull
	String STRUCT_KEYWORD = "struct";
	@Nonnull
	String THEN_KEYWORD = "then";
	@Nonnull
	String TO_KEYWORD = "to";
	@Nonnull
	String TRUE_KEYWORD = "true";
	@Nonnull
	String TRY_KEYWORD = "try";
	@Nonnull
	String TYPE_KEYWORD = "type";
	@Nonnull
	String VAL_KEYWORD = "val";
	@Nonnull
	String VIRTUAL_KEYWORD = "virtual";
	@Nonnull
	String WHEN_KEYWORD = "when";
	@Nonnull
	String WHILE_KEYWORD = "while";
	@Nonnull
	String WITH_KEYWORD = "with";

	@Nonnull
	@DoNotSuggestInCompletionVariants
	String NOT_EQ = "!=";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String HASH = "#";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String AMP = "&";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String AMP_AMP = "&&";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String QUOTE = "'";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String LPAR = "(";
	@Nonnull
	String RPAR = ")";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String MULT = "*";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String PLUS = "+";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String COMMA = ",";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String MINUS = "-";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String MINUS_DOT = "-.";
	@Nonnull
	String MINUS_GT = "->";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String DOT = ".";
	@Nonnull
	String DOT_DOT = "..";
	@Nonnull
	String COLON = ":";
	@Nonnull
	String COLON_COLON = "::";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String COLON_EQ = ":=";
	@Nonnull
	String COLON_GT = ":>";
	@Nonnull
	String SEMICOLON = ";";
	@Nonnull
	String SEMICOLON_SEMICOLON = ";;";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String LT = "<";
	@Nonnull
	String LT_MINUS = "<-";
	@Nonnull
	String EQ = "=";
	@Nonnull
	String GT = ">";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String GT_RBRACKET = ">]";
	@Nonnull
	String GT_RBRACE = ">}";
	@Nonnull
	String QUEST = "?";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String QUEST_QUEST = "??";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String LBRACKET = "[";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String LBRACKET_LT = "[<";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String LBRACKET_GT = "[>";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String LBRACKET_VBAR = "[|";
	@Nonnull
	String RBRACKET = "]";
	@Nonnull
	String UNDERSCORE = "_";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String ACCENT = "`";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String LBRACE = "{";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String LBRACE_LT = "{<";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String VBAR = "|";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String VBAR_VBAR = "||";
	@Nonnull
	String VBAR_RBRACKET = "|]";
	@Nonnull
	String RBRACE = "}";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String TILDE = "~";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String LT_LT = "<<";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String LT_COLON = "<:";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String GT_GT = ">>";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String DOLLAR = "$";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String DOLLAR_DOLLAR = "$$";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String DOLLAR_COLON = "$:";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String DOUBLE_QUOTE = "\"";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String AT = "@";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String XOR = "^";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String DIV = "/";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String PERCENT = "%";
	@Nonnull
	@DoNotSuggestInCompletionVariants
	String POWER = "**";
}
