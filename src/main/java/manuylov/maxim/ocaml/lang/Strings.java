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

/**
 * @author Maxim.Manuylov
 *         Date: 28.02.2009
 */
public interface Strings
{
	@Nonnull
	String CLASS_EXPECTED = "'class' expected";
	@Nonnull
	String CLASS_TYPE_EXPECTED = "Class type expected";
	@Nonnull
	String TYPE_EXPECTED = "'type' expected";
	@Nonnull
	String INITIALIZER_KEYWORD_EXPECTED = "'initializer' expected";
	@Nonnull
	String METHOD_KEYWORD_EXPECTED = "'method' expected";
	@Nonnull
	String OBJECT_KEYWORD_EXPECTED = "'object' expected";
	@Nonnull
	String INHERIT_KEYWORD_EXPECTED = "'inherit' expected";
	@Nonnull
	String CLASS_KEYWORD_EXPECTED = "'class' expected";
	@Nonnull
	String LBRACE_LT_EXPECTED = "'{<' expected";
	@Nonnull
	String GT_RBRACE_EXPECTED = "'>}' expected";
	@Nonnull
	String LBRACKET_VBAR_EXPECTED = "'[|' expected";
	@Nonnull
	String LBRACKET_EXPECTED = "'[' expected";
	@Nonnull
	String WHILE_KEYWORD_EXPECTED = "'while' expected";
	@Nonnull
	String FOR_KEYWORD_EXPECTED = "'for' expected";
	@Nonnull
	String DO_KEYWORD_EXPECTED = "'do' expected";
	@Nonnull
	String DONE_KEYWORD_EXPECTED = "'done' expected";
	@Nonnull
	String IF_KEYWORD_EXPECTED = "'if' expected";
	@Nonnull
	String THEN_KEYWORD_EXPECTED = "'then' expected";
	@Nonnull
	String TRY_KEYWORD_EXPECTED = "'try' expected";
	@Nonnull
	String FUNCTION_KEYWORD_EXPECTED = "'function' expected";
	@Nonnull
	String FUN_KEYWORD_EXPECTED = "'fun' expected";
	@Nonnull
	String MATCH_KEYWORD_EXPECTED = "'match' expected";
	@Nonnull
	String WITH_KEYWORD_EXPECTED = "'with' expected";
	@Nonnull
	String ASSERT_KEYWORD_EXPECTED = "'assert' expected";
	@Nonnull
	String LAZY_KEYWORD_EXPECTED = "'lazy' expected";
	@Nonnull
	String END_KEYWORD_EXPECTED = "'end' expected";
	@Nonnull
	String LET_KEYWORD_EXPECTED = "'let' expected";
	@Nonnull
	String IN_KEYWORD_EXPECTED = "'in' expected";
	@Nonnull
	String FUNCTOR_KEYWORD_EXPECTED = "'functor' expected";
	@Nonnull
	String SIG_KEYWORD_EXPECTED = "'sig' expected";
	@Nonnull
	String MINUS_GT_EXPECTED = "'->' expected";
	@Nonnull
	String LPAR_EXPECTED = "'(' expected";
	@Nonnull
	String MODULE_KEYWORD_EXPECTED = "'module' expected";
	@Nonnull
	String VBAR_RBRACKET_EXPECTED = "'|]' expected";
	@Nonnull
	String VAL_KEYWORD_EXPECTED = "'val' expected";
	@Nonnull
	String INCLUDE_KEYWORD_EXPECTED = "'include' expected";
	@Nonnull
	String OPEN_KEYWORD_EXPECTED = "'open' expected";
	@Nonnull
	String EXTERNAL_KEYWORD_EXPECTED = "'external' expected";
	@Nonnull
	String EXCEPTION_KEYWORD_EXPECTED = "'exception' expected";
	@Nonnull
	String TYPE_KEYWORD_EXPECTED = "'type' expected";
	@Nonnull
	String CONSTRAINT_KEYWORD_EXPECTED = "'constraint' expected";
	@Nonnull
	String QUOTE_EXPECTED = "''' expected";
	@Nonnull
	String EQ_EXPECTED = "'=' expected";
	@Nonnull
	String LBRACE_EXPECTED = "'{' expected";
	@Nonnull
	String RBRACE_EXPECTED = "'}' expected";
	@Nonnull
	String COLON_EXPECTED = "':' expected";
	@Nonnull
	String RPAR_EXPECTED = "')' expected";
	@Nonnull
	String ACCENT_EXPECTED = "'`' expected";
	@Nonnull
	String RBRACKET_EXPECTED = "']' expected";
	@Nonnull
	String GT_EXPECTED = "'>' expected";
	@Nonnull
	String CHAR_LITERAL_EXPECTED = "Character literal expected";
	@Nonnull
	String ILLEGAL_CHAR_LITERAL = "Illegal character literal";
	@Nonnull
	String DOT_EXPECTED = "'.' expected";
	@Nonnull
	String SEMICOLON_SEMICOLON_EXPECTED = "';;' expected";
	@Nonnull
	String INHERIT_OR_VAL_OR_METHOD_OR_CONSTRAINT_OR_INITIALIZER_EXPECTED = "'inherit', 'val', 'method', 'constraint' or 'initializer' expected";
	@Nonnull
	String EXPRESSION_EXPECTED = "Expression expected";
	@Nonnull
	String RPAR_OR_COLON_GT_EXPECTED = "')' or ':>' expected";
	@Nonnull
	String RPAR_OR_COLON_OR_COLON_GT_EXPECTED = "')', ':' or ':>' expected";
	@Nonnull
	String BEGIN_OR_LPAR_EXPECTED = "'begin' or '(' expected";
	@Nonnull
	String TO_OR_DOWNTO_EXPECTED = "'to' or 'downto' expected";
	@Nonnull
	String TYPE_OR_MODULE_EXPECTED = "'type' or 'module' expected";
	@Nonnull
	String MODULE_NAME_EXPECTED = "Module name expected";
	@Nonnull
	String MODULE_TYPE_EXPECTED = "Module type expected";
	@Nonnull
	String CONSTRUCTOR_PATH_EXPECTED = "Constructor path expected";
	@Nonnull
	String IDENTIFIER_EXPECTED = "Identifier expected";
	@Nonnull
	String CLASS_PATH_EXPECTED = "Class path expected";
	@Nonnull
	String METHOD_NAME_EXPECTED = "Method name expected";
	@Nonnull
	String LABEL_NAME_EXPECTED = "Label name expected";
	@Nonnull
	String MODULE_TYPE_NAME_EXPECTED = "Module type name expected";
	@Nonnull
	String MODULE_PATH_EXPECTED = "Module path expected";
	@Nonnull
	String MODULE_EXPRESSION_EXPECTED = "Module expression expected";
	@Nonnull
	String EXTENDED_MODULE_PATH_EXPECTED = "Extended module path expected";
	@Nonnull
	String EXTENDED_MODULE_NAME_EXPECTED = "Extended module name expected";
	@Nonnull
	String TYPE_CONSTRUCTOR_PATH_EXPECTED = "Type constructor path expected";
	@Nonnull
	String MODULE_TYPE_PATH_EXPECTED = "Module type path expected";
	@Nonnull
	String TYPE_CONSTRUCTOR_NAME_EXPECTED = "Type constructor name expected";
	@Nonnull
	String TAG_NAME_EXPECTED = "Tag name expected";
	@Nonnull
	String CLASS_NAME_EXPECTED = "Class name expected";
	@Nonnull
	String CONSTRUCTOR_NAME_EXPECTED = "Constructor name expected";
	@Nonnull
	String INSTANCE_VARIABLE_NAME_EXPECTED = "Instance variable name expected";
	@Nonnull
	String VALUE_NAME_EXPECTED = "Value name expected";
	@Nonnull
	String FIELD_NAME_EXPECTED = "Field name expected";
	@Nonnull
	String FIELD_PATH_EXPECTED = "Field path expected";
	@Nonnull
	String PATTERN_EXPECTED = "Pattern expected";
	@Nonnull
	String RPAR_OR_COLON_EXPECTED = "')' or ':' expected";
	@Nonnull
	String SPECIFICATION_EXPECTED = "Specification expected";
	@Nonnull
	String TYPE_EXPRESSION_EXPECTED = "Type expression expected";
	@Nonnull
	String POLYMORPHIC_TYPE_EXPRESSION_EXPECTED = "Polymorphic type expression expected";
	@Nonnull
	String TYPE_CONSTRUCTOR_OR_HASH_EXPECTED = "Type constructor or '#' expected";
	@Nonnull
	String STRUCT_KEYWORD_EXPECTED = "'struct' expected";
	@Nonnull
	String UNEXPECTED_TOKEN = "Unexpected token";
	@Nonnull
	String DEFINITION_OR_EXPRESSION_EXPECTED = "Definition or expression expected";
	@Nonnull
	String UNCLOSED_COMMENT = "Unclosed comment";
	@Nonnull
	String UNEXPECTED_END_OF_FILE = "Unexpected end of file";
	@Nonnull
	String CLASS_EXPRESSION_EXPECTED = "Class expression expected";
	@Nonnull
	String INDEX_VARIABLE_NAME_EXPECTED = "Index variable name expected";
}
