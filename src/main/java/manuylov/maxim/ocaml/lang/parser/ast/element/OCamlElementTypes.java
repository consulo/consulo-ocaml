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

package manuylov.maxim.ocaml.lang.parser.ast.element;

import javax.annotation.Nonnull;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import manuylov.maxim.ocaml.fileType.ml.MLFileTypeLanguage;
import manuylov.maxim.ocaml.fileType.mli.MLIFileTypeLanguage;
import manuylov.maxim.ocaml.lang.OCamlElementType;

/**
 * @author Maxim.Manuylov
 *         Date: 05.02.2009
 */
public interface OCamlElementTypes
{
	@Nonnull
	IFileElementType ML_FILE = new IFileElementType("OCaml:ML_FILE", MLFileTypeLanguage.INSTANCE);
	@Nonnull
	IFileElementType MLI_FILE = new IFileElementType("OCaml:MLI_FILE", MLIFileTypeLanguage.INSTANCE);

    /* Let parsing { */

	@Nonnull
	IElementType LET_BINDING = new OCamlElementType("LET_BINDING");
	@Nonnull
	IElementType LET_BINDING_PATTERN = new OCamlElementType("LET_BINDING_PATTERN");
	@Nonnull
	IElementType LET_STATEMENT = new OCamlElementType("LET_STATEMENT");
	@Nonnull
	IElementType LET_EXPRESSION = new OCamlElementType("LET_EXPRESSION");
	@Nonnull
	IElementType LET_CLASS_EXPRESSION = new OCamlElementType("LET_CLASS_EXPRESSION");

    /* } */

    /* Statement parsing { */

	@Nonnull
	IElementType EXTERNAL_DEFINITION = new OCamlElementType("EXTERNAL_DEFINITION");
	@Nonnull
	IElementType EXCEPTION_DEFINITION = new OCamlElementType("EXCEPTION_DEFINITION");
	@Nonnull
	IElementType OPEN_DIRECTIVE = new OCamlElementType("OPEN_DIRECTIVE");
	@Nonnull
	IElementType INCLUDE_DIRECTIVE_DEFINITION = new OCamlElementType("INCLUDE_DIRECTIVE_DEFINITION");
	@Nonnull
	IElementType EXCEPTION_SPECIFICATION = new OCamlElementType("EXCEPTION_SPECIFICATION");
	@Nonnull
	IElementType INCLUDE_DIRECTIVE_SPECIFICATION = new OCamlElementType("INCLUDE_DIRECTIVE_SPECIFICATION");
	@Nonnull
	IElementType VALUE_SPECIFICATION = new OCamlElementType("VALUE_SPECIFICATION");
	@Nonnull
	IElementType EXTERNAL_DECLARATION = new OCamlElementType("EXTERNAL_DECLARATION");

    /* } */

    /* Type parsing { */

	@Nonnull
	IElementType TYPE_DEFINITION = new OCamlElementType("TYPE_DEFINITION");
	@Nonnull
	IElementType TYPE_PARAMETERIZED_BINDING = new OCamlElementType("TYPE_PARAMETERIZED_BINDING");
	@Nonnull
	IElementType TYPE_BINDING = new OCamlElementType("TYPE_BINDING");
	@Nonnull
	IElementType TYPE_PARAMETER = new OCamlElementType("TYPE_PARAMETER");
	@Nonnull
	IElementType TYPE_PARAMETER_DEFINITION = new OCamlElementType("TYPE_PARAMETER_DEFINITION");
	@Nonnull
	IElementType PLUS_MINUS_TYPE_PARAMETER = new OCamlElementType("PLUS_MINUS_TYPE_PARAMETER");
	@Nonnull
	IElementType RECORD_TYPE_DEFINITION = new OCamlElementType("RECORD_TYPE_DEFINITION");
	@Nonnull
	IElementType RECORD_FIELD_DEFINITION = new OCamlElementType("RECORD_FIELD_DEFINITION");
	@Nonnull
	IElementType VARIANT_TYPE_DEFINITION = new OCamlElementType("VARIANT_TYPE_DEFINITION");
	@Nonnull
	IElementType CONSTRUCTOR_DEFINITION = new OCamlElementType("CONSTRUCTOR_DEFINITION");
	@Nonnull
	IElementType TYPE_DEFINITION_CONSTRAINT = new OCamlElementType("TYPE_DEFINITION_CONSTRAINT");
	@Nonnull
	IElementType AS_TYPE_EXPRESSION = new OCamlElementType("AS_TYPE_EXPRESSION");
	@Nonnull
	IElementType FUNCTION_TYPE_EXPRESSION = new OCamlElementType("FUNCTION_TYPE_EXPRESSION");
	@Nonnull
	IElementType TUPLE_TYPE_EXPRESSION = new OCamlElementType("TUPLE_TYPE_EXPRESSION");
	@Nonnull
	IElementType SUPER_CLASS_TYPE_EXPRESSION = new OCamlElementType("SUPER_CLASS_TYPE_EXPRESSION");
	@Nonnull
	IElementType TYPE_CONSTRUCTOR_APPLICATION_TYPE_EXPRESSION = new OCamlElementType("TYPE_CONSTRUCTOR_APPLICATION_TYPE_EXPRESSION");
	@Nonnull
	IElementType OBJECT_INTERFACE_TYPE_EXPRESSION = new OCamlElementType("OBJECT_INTERFACE_TYPE_EXPRESSION");
	@Nonnull
	IElementType METHOD_TYPE = new OCamlElementType("METHOD_TYPE");
	@Nonnull
	IElementType VARIANT_TYPE_TYPE_EXPRESSION = new OCamlElementType("VARIANT_TYPE_TYPE_EXPRESSION");
	@Nonnull
	IElementType TAG_SPEC = new OCamlElementType("TAG_SPEC");
	@Nonnull
	IElementType TAG_SPEC_FULL = new OCamlElementType("TAG_SPEC_FULL");
	@Nonnull
	IElementType POLY_TYPE_EXPRESSION = new OCamlElementType("POLY_TYPE_EXPRESSION");
	@Nonnull
	IElementType PARENTHESES_TYPE_EXPRESSION = new OCamlElementType("PARENTHESES_TYPE_EXPRESSION");
	@Nonnull
	IElementType PARENTHESES_TYPE_PARAMETERS = new OCamlElementType("PARENTHESES_TYPE_PARAMETERS");
	@Nonnull
	IElementType UNDERSCORE_TYPE_EXPRESSION = new OCamlElementType("UNDERSCORE_TYPE_EXPRESSION");

    /* } */

    /* Class parsing { */

	@Nonnull
	IElementType CLASS_DEFINITION = new OCamlElementType("CLASS_DEFINITION");
	@Nonnull
	IElementType CLASS_BINDING = new OCamlElementType("CLASS_BINDING");
	@Nonnull
	IElementType CLASS_TYPE_DEFINITION = new OCamlElementType("CLASS_TYPE_DEFINITION");
	@Nonnull
	IElementType CLASS_TYPE_BINDING = new OCamlElementType("CLASS_TYPE_BINDING");
	@Nonnull
	IElementType FUNCTION_CLASS_TYPE = new OCamlElementType("FUNCTION_CLASS_TYPE");
	@Nonnull
	IElementType CLASS_PATH_APPLICATION = new OCamlElementType("CLASS_PATH_APPLICATION");
	@Nonnull
	IElementType OBJECT_END_CLASS_BODY_TYPE = new OCamlElementType("OBJECT_END_CLASS_BODY_TYPE");
	@Nonnull
	IElementType INHERIT_CLASS_FILED_SPECIFICATION = new OCamlElementType("INHERIT_CLASS_FILED_SPECIFICATION");
	@Nonnull
	IElementType VALUE_CLASS_FIELD_SPECIFICATION = new OCamlElementType("VALUE_CLASS_FIELD_SPECIFICATION");
	@Nonnull
	IElementType METHOD_CLASS_FIELD_SPECIFICATION = new OCamlElementType("METHOD_CLASS_FIELD_SPECIFICATION");
	@Nonnull
	IElementType CONSTRAINT_CLASS_FIELD_SPECIFICATION = new OCamlElementType("CONSTRAINT_CLASS_FIELD_SPECIFICATION");
	@Nonnull
	IElementType FUNCTION_APPLICATION_CLASS_EXPRESSION = new OCamlElementType("FUNCTION_APPLICATION_CLASS_EXPRESSION");
	@Nonnull
	IElementType OBJECT_END_CLASS_EXPRESSION = new OCamlElementType("OBJECT_END_CLASS_EXPRESSION");
	@Nonnull
	IElementType OBJECT_SELF_DEFINITION = new OCamlElementType("OBJECT_SELF_DEFINITION");
	@Nonnull
	IElementType OBJECT_SELF_SPECIFICATION = new OCamlElementType("OBJECT_SELF_SPECIFICATION");
	@Nonnull
	IElementType INHERIT_CLASS_FIELD_DEFINITION = new OCamlElementType("INHERIT_CLASS_FIELD_DEFINITION");
	@Nonnull
	IElementType INITIALIZER_CLASS_FIELD_DEFINITION = new OCamlElementType("INITIALIZER_CLASS_FIELD_DEFINITION");
	@Nonnull
	IElementType CONSTRAINT_CLASS_FIELD_DEFINITION = new OCamlElementType("CONSTRAINT_CLASS_FIELD_DEFINITION");
	@Nonnull
	IElementType VALUE_CLASS_FIELD_DEFINITION = new OCamlElementType("VALUE_CLASS_FIELD_DEFINITION");
	@Nonnull
	IElementType METHOD_CLASS_FIELD_DEFINITION = new OCamlElementType("METHOD_CLASS_FIELD_DEFINITION");
	@Nonnull
	IElementType FUNCTION_CLASS_EXPRESSION = new OCamlElementType("FUNCTION_CLASS_EXPRESSION");
	@Nonnull
	IElementType CLASS_SPECIFICATION = new OCamlElementType("CLASS_SPECIFICATION");
	@Nonnull
	IElementType CLASS_SPECIFICATION_BINDING = new OCamlElementType("CLASS_SPECIFICATION_BINDING");
	@Nonnull
	IElementType CLASS_TYPE_CONSTRAINT = new OCamlElementType("CLASS_TYPE_CONSTRAINT");
	@Nonnull
	IElementType PARENTHESES_CLASS_EXPRESSION = new OCamlElementType("PARENTHESES_CLASS_EXPRESSION");

    /* } */

    /* Module parsing { */

	@Nonnull
	IElementType MODULE_DEFINITION = new OCamlElementType("MODULE_DEFINITION");
	@Nonnull
	IElementType MODULE_TYPE_DEFINITION = new OCamlElementType("MODULE_TYPE_DEFINITION");
	@Nonnull
	IElementType FUNCTOR_MODULE_TYPE = new OCamlElementType("FUNCTOR_MODULE_TYPE");
	@Nonnull
	IElementType SIG_END_MODULE_TYPE = new OCamlElementType("SIG_END_MODULE_TYPE");
	@Nonnull
	IElementType MODULE_TYPE_TYPE_CONSTRAINT = new OCamlElementType("MODULE_TYPE_TYPE_CONSTRAINT");
	@Nonnull
	IElementType MODULE_TYPE_MODULE_CONSTRAINT = new OCamlElementType("MODULE_TYPE_MODULE_CONSTRAINT");
	@Nonnull
	IElementType FUNCTOR_APPLICATION_MODULE_EXPRESSION = new OCamlElementType("FUNCTOR_APPLICATION_MODULE_EXPRESSION");
	@Nonnull
	IElementType STRUCT_END_MODULE_EXPRESSION = new OCamlElementType("STRUCT_END_MODULE_EXPRESSION");
	@Nonnull
	IElementType FUNCTOR_MODULE_EXPRESSION = new OCamlElementType("FUNCTOR_MODULE_EXPRESSION");
	@Nonnull
	IElementType MODULE_TYPE_CONSTRAINT_MODULE_EXPRESSION = new OCamlElementType("MODULE_TYPE_CONSTRAINT_MODULE_EXPRESSION");
	@Nonnull
	IElementType MODULE_TYPE_WITH_CONSTRAINTS = new OCamlElementType("MODULE_TYPE_WITH_CONSTRAINTS");
	@Nonnull
	IElementType MODULE_TYPE_SPECIFICATION = new OCamlElementType("MODULE_TYPE_SPECIFICATION");
	@Nonnull
	IElementType MODULE_SPECIFICATION = new OCamlElementType("MODULE_SPECIFICATION");
	@Nonnull
	IElementType MODULE_TYPE_DEFINITION_BINDING = new OCamlElementType("MODULE_TYPE_DEFINITION_BINDING");
	@Nonnull
	IElementType MODULE_TYPE_SPECIFICATION_BINDING = new OCamlElementType("MODULE_TYPE_SPECIFICATION_BINDING");
	@Nonnull
	IElementType MODULE_DEFINITION_BINDING = new OCamlElementType("MODULE_DEFINITION_BINDING");
	@Nonnull
	IElementType MODULE_SPECIFICATION_BINDING = new OCamlElementType("MODULE_SPECIFICATION_BINDING");
	@Nonnull
	IElementType MODULE_PARAMETER = new OCamlElementType("MODULE_PARAMETER");
	@Nonnull
	IElementType FILE_MODULE_DEFINITION_BINDING = new OCamlElementType("FILE_MODULE_DEFINITION_BINDING");
	@Nonnull
	IElementType FILE_MODULE_EXPRESSION = new OCamlElementType("FILE_MODULE_EXPRESSION");
	@Nonnull
	IElementType FILE_MODULE_SPECIFICATION_BINDING = new OCamlElementType("FILE_MODULE_SPECIFICATION_BINDING");
	@Nonnull
	IElementType FILE_MODULE_TYPE = new OCamlElementType("FILE_MODULE_TYPE");
	@Nonnull
	IElementType PARENTHESES_MODULE_EXPRESSION = new OCamlElementType("PARENTHESES_MODULE_EXPRESSION");
	@Nonnull
	IElementType PARENTHESES_MODULE_TYPE = new OCamlElementType("PARENTHESES_MODULE_TYPE");

    /* } */

    /* Name parsing { */

	@Nonnull
	IElementType VALUE_NAME = new OCamlElementType("VALUE_NAME");
	@Nonnull
	IElementType OPERATOR_NAME = new OCamlElementType("OPERATOR_NAME");
	@Nonnull
	IElementType MODULE_PATH = new OCamlElementType("MODULE_PATH");
	@Nonnull
	IElementType MODULE_NAME = new OCamlElementType("MODULE_NAME");
	@Nonnull
	IElementType CONSTRUCTOR_PATH_EXPRESSION = new OCamlElementType("CONSTRUCTOR_PATH_EXPRESSION");
	@Nonnull
	IElementType CONSTRUCTOR_NAME_EXPRESSION = new OCamlElementType("CONSTRUCTOR_NAME_EXPRESSION");
	@Nonnull
	IElementType CONSTRUCTOR_PATH_PATTERN = new OCamlElementType("CONSTRUCTOR_PATH_PATTERN");
	@Nonnull
	IElementType CONSTRUCTOR_NAME_PATTERN = new OCamlElementType("CONSTRUCTOR_NAME_PATTERN");
	@Nonnull
	IElementType TYPE_CONSTRUCTOR_NAME = new OCamlElementType("TYPE_CONSTRUCTOR_NAME");
	@Nonnull
	IElementType INST_VAR_NAME_DEFINITION = new OCamlElementType("INST_VAR_NAME_DEFINITION");
	@Nonnull
	IElementType CONSTRUCTOR_NAME_DEFINITION = new OCamlElementType("CONSTRUCTOR_NAME_DEFINITION");
	@Nonnull
	IElementType CONSTRUCTOR_NAME = new OCamlElementType("CONSTRUCTOR_NAME");
	@Nonnull
	IElementType CONSTRUCTOR_PATH = new OCamlElementType("CONSTRUCTOR_PATH");
	@Nonnull
	IElementType TYPE_PARAMETER_NAME = new OCamlElementType("TYPE_PARAMETER_NAME");
	@Nonnull
	IElementType FIELD_NAME = new OCamlElementType("FIELD_NAME");
	@Nonnull
	IElementType CLASS_PATH = new OCamlElementType("CLASS_PATH");
	@Nonnull
	IElementType CLASS_NAME = new OCamlElementType("CLASS_NAME");
	@Nonnull
	IElementType METHOD_NAME = new OCamlElementType("METHOD_NAME");
	@Nonnull
	IElementType INST_VAR_NAME = new OCamlElementType("INST_VAR_NAME");
	@Nonnull
	IElementType LABEL_NAME = new OCamlElementType("LABEL_NAME");
	@Nonnull
	IElementType MODULE_TYPE_NAME = new OCamlElementType("MODULE_TYPE_NAME");
	@Nonnull
	IElementType EXTENDED_MODULE_PATH = new OCamlElementType("EXTENDED_MODULE_PATH");
	@Nonnull
	IElementType EXTENDED_MODULE_NAME = new OCamlElementType("EXTENDED_MODULE_NAME");
	@Nonnull
	IElementType TYPE_CONSTRUCTOR_PATH = new OCamlElementType("TYPE_CONSTRUCTOR_PATH");
	@Nonnull
	IElementType MODULE_TYPE_PATH = new OCamlElementType("MODULE_TYPE_PATH");
	@Nonnull
	IElementType TAG_NAME = new OCamlElementType("TAG_NAME");
	@Nonnull
	IElementType VALUE_PATH = new OCamlElementType("VALUE_PATH");
	@Nonnull
	IElementType FIELD_PATH = new OCamlElementType("FIELD_PATH");
	@Nonnull
	IElementType FOR_EXPRESSION_INDEX_VARIABLE_NAME = new OCamlElementType("FOR_EXPRESSION_INDEX_VARIABLE_NAME");

    /* } */

    /* Expression parsing { */

	@Nonnull
	IElementType MATCH_EXPRESSION = new OCamlElementType("MATCH_EXPRESSION");
	@Nonnull
	IElementType FUN_EXPRESSION = new OCamlElementType("FUN_EXPRESSION");
	@Nonnull
	IElementType FUNCTION_EXPRESSION = new OCamlElementType("FUNCTION_EXPRESSION");
	@Nonnull
	IElementType TRY_EXPRESSION = new OCamlElementType("TRY_EXPRESSION");
	@Nonnull
	IElementType PATTERN_MATCHING = new OCamlElementType("PATTERN_MATCHING");
	@Nonnull
	IElementType SEMICOLON_EXPRESSION = new OCamlElementType("SEMICOLON_EXPRESSION");
	@Nonnull
	IElementType IF_EXPRESSION = new OCamlElementType("IF_EXPRESSION");
	@Nonnull
	IElementType FOR_EXPRESSION = new OCamlElementType("FOR_EXPRESSION");
	@Nonnull
	IElementType FOR_EXPRESSION_BINDING = new OCamlElementType("FOR_EXPRESSION_BINDING");
	@Nonnull
	IElementType WHILE_EXPRESSION = new OCamlElementType("WHILE_EXPRESSION");
	@Nonnull
	IElementType ASSIGNMENT_EXPRESSION = new OCamlElementType("ASSIGNMENT_EXPRESSION");
	@Nonnull
	IElementType COMMA_EXPRESSION = new OCamlElementType("COMMA_EXPRESSION");
	@Nonnull
	IElementType BINARY_EXPRESSION = new OCamlElementType("BINARY_EXPRESSION");
	@Nonnull
	IElementType HEAD_TAIL_EXPRESSION = new OCamlElementType("HEAD_TAIL_EXPRESSION");
	@Nonnull
	IElementType ASSERT_EXPRESSION = new OCamlElementType("ASSERT_EXPRESSION");
	@Nonnull
	IElementType LAZY_EXPRESSION = new OCamlElementType("LAZY_EXPRESSION");
	@Nonnull
	IElementType CONSTRUCTOR_APPLICATION_EXPRESSION = new OCamlElementType("CONSTRUCTOR_APPLICATION_EXPRESSION");
	@Nonnull
	IElementType FUNCTION_APPLICATION_EXPRESSION = new OCamlElementType("FUNCTION_APPLICATION_EXPRESSION");
	@Nonnull
	IElementType ARRAY_ELEMENT_ACCESSING_EXPRESSION = new OCamlElementType("ARRAY_ELEMENT_ACCESSING_EXPRESSION");
	@Nonnull
	IElementType STRING_CHAR_ACCESSING_EXPRESSION = new OCamlElementType("STRING_CHAR_ACCESSING_EXPRESSION");
	@Nonnull
	IElementType RECORD_FIELD_ACCESSING_EXPRESSION = new OCamlElementType("RECORD_FIELD_ACCESSING_EXPRESSION");
	@Nonnull
	IElementType RECORD_FIELD_INITIALIZATION_IN_EXPRESSION = new OCamlElementType("RECORD_FIELD_INITIALIZATION_IN_EXPRESSION");
	@Nonnull
	IElementType RECORD_FIELD_INITIALIZATION_IN_PATTERN = new OCamlElementType("RECORD_FIELD_INITIALIZATION_IN_PATTERN");
	@Nonnull
	IElementType UNARY_EXPRESSION = new OCamlElementType("UNARY_EXPRESSION");
	@Nonnull
	IElementType CLASS_METHOD_ACCESSING_EXPRESSION = new OCamlElementType("CLASS_METHOD_ACCESSING_EXPRESSION");
	@Nonnull
	IElementType TAGGED_EXPRESSION = new OCamlElementType("TAGGED_EXPRESSION");
	@Nonnull
	IElementType TYPE_CONSTRAINT_EXPRESSION = new OCamlElementType("TYPE_CONSTRAINT_EXPRESSION");
	@Nonnull
	IElementType CASTING_EXPRESSION = new OCamlElementType("CASTING_EXPRESSION");
	@Nonnull
	IElementType LIST_EXPRESSION = new OCamlElementType("LIST_EXPRESSION");
	@Nonnull
	IElementType ARRAY_EXPRESSION = new OCamlElementType("ARRAY_EXPRESSION");
	@Nonnull
	IElementType RECORD_EXPRESSION = new OCamlElementType("RECORD_EXPRESSION");
	@Nonnull
	IElementType INHERITED_RECORD_EXPRESSION = new OCamlElementType("INHERITED_RECORD_EXPRESSION");
	@Nonnull
	IElementType INSTANCE_DUPLICATING_EXPRESSION = new OCamlElementType("INSTANCE_DUPLICATING_EXPRESSION");
	@Nonnull
	IElementType OBJECT_CLASS_BODY_END_EXPRESSION = new OCamlElementType("OBJECT_CLASS_BODY_END_EXPRESSION");
	@Nonnull
	IElementType NEW_INSTANCE_EXPRESSION = new OCamlElementType("NEW_INSTANCE_EXPRESSION");
	@Nonnull
	IElementType ARGUMENT = new OCamlElementType("ARGUMENT");
	@Nonnull
	IElementType PARAMETER = new OCamlElementType("PARAMETER");
	@Nonnull
	IElementType LABEL_DEFINITION = new OCamlElementType("LABEL_DEFINITION");
	@Nonnull
	IElementType PARENTHESES_EXPRESSION = new OCamlElementType("PARENTHESES_EXPRESSION");
	@Nonnull
	IElementType EXPRESSION_STATEMENT = new OCamlElementType("EXPRESSION_STATEMENT");
	@Nonnull
	IElementType CONSTANT_EXPRESSION = new OCamlElementType("CONSTANT_EXPRESSION");

    /* } */

    /* Pattern parsing { */

	@Nonnull
	IElementType VALUE_NAME_PATTERN = new OCamlElementType("VALUE_NAME_PATTERN");
	@Nonnull
	IElementType AS_PATTERN = new OCamlElementType("AS_PATTERN");
	@Nonnull
	IElementType OR_PATTERN = new OCamlElementType("OR_PATTERN");
	@Nonnull
	IElementType COMMA_PATTERN = new OCamlElementType("COMMA_PATTERN");
	@Nonnull
	IElementType HEAD_TAIL_PATTERN = new OCamlElementType("HEAD_TAIL_PATTERN");
	@Nonnull
	IElementType CONSTRUCTOR_APPLICATION_PATTERN = new OCamlElementType("CONSTRUCTOR_APPLICATION_PATTERN");
	@Nonnull
	IElementType TAGGED_PATTERN = new OCamlElementType("TAGGED_PATTERN");
	@Nonnull
	IElementType TYPE_CONSTRUCTOR_PATTERN = new OCamlElementType("TYPE_CONSTRUCTOR_PATTERN");
	@Nonnull
	IElementType LAZY_PATTERN = new OCamlElementType("LAZY_PATTERN");
	@Nonnull
	IElementType LIST_PATTERN = new OCamlElementType("LIST_PATTERN");
	@Nonnull
	IElementType ARRAY_PATTERN = new OCamlElementType("ARRAY_PATTERN");
	@Nonnull
	IElementType RECORD_PATTERN = new OCamlElementType("RECORD_PATTERN");
	@Nonnull
	IElementType TYPE_CONSTRAINT_PATTERN = new OCamlElementType("TYPE_CONSTRAINT_PATTERN");
	@Nonnull
	IElementType CHAR_RANGE_PATTERN = new OCamlElementType("CHAR_RANGE_PATTERN");
	@Nonnull
	IElementType PARENTHESES_PATTERN = new OCamlElementType("PARENTHESES_PATTERN");
	@Nonnull
	IElementType UNDERSCORE_PATTERN = new OCamlElementType("UNDERSCORE_PATTERN");
	@Nonnull
	IElementType CONSTANT_PATTERN = new OCamlElementType("CONSTANT_PATTERN");

    /* } */

    /* Comments { */

	@Nonnull
	IElementType COMMENT_BLOCK = new OCamlElementType("COMMENT_BLOCK");
	@Nonnull
	IElementType UNCLOSED_COMMENT = new OCamlElementType("UNCLOSED_COMMENT");

    /* } */

	@Nonnull
	IElementType PARENTHESES = new OCamlElementType("PARENTHESES");
	@Nonnull
	IElementType BRACKETS = new OCamlElementType("BRACKETS");
}

