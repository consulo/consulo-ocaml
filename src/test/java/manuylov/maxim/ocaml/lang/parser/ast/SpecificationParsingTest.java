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

package manuylov.maxim.ocaml.lang.parser.ast;

import static manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes.COLON;
import static manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes.EXCEPTION_KEYWORD;
import static manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes.INCLUDE_KEYWORD;
import static manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes.LCFC_IDENTIFIER;
import static manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes.OF_KEYWORD;
import static manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes.SEMICOLON_SEMICOLON;
import static manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes.UCFC_IDENTIFIER;
import static manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes.VAL_KEYWORD;
import static manuylov.maxim.ocaml.lang.parser.ast.element.OCamlElementTypes.*;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import com.intellij.lang.ParserDefinition;
import com.intellij.psi.tree.IElementType;
import manuylov.maxim.ocaml.fileType.mli.parser.MLIParserDefinition;
import manuylov.maxim.ocaml.lang.parser.ast.element.OCamlElementTypes;
import manuylov.maxim.ocaml.lang.parser.ast.util.TreeStringBuilder;

/**
 * @author Maxim.Manuylov
 *         Date: 13.03.2009
 */
public class SpecificationParsingTest extends BaseStatementParsingTest
{
	@Test
	public void testDoubleSemicolon() throws Exception
	{
		myTree.addNode(3, VALUE_SPECIFICATION);
		myTree.addNode(4, VAL_KEYWORD);
		myTree.addNode(4, VALUE_NAME_PATTERN);
		myTree.addNode(5, LCFC_IDENTIFIER, "a");
		myTree.addNode(4, COLON);
		myTree.addNode(4, TYPE_CONSTRUCTOR_NAME);
		myTree.addNode(5, LCFC_IDENTIFIER, "int");
		myTree.addNode(3, VALUE_SPECIFICATION);
		myTree.addNode(4, VAL_KEYWORD);
		myTree.addNode(4, VALUE_NAME_PATTERN);
		myTree.addNode(5, LCFC_IDENTIFIER, "b");
		myTree.addNode(4, COLON);
		myTree.addNode(4, TYPE_CONSTRUCTOR_NAME);
		myTree.addNode(5, LCFC_IDENTIFIER, "int");
		myTree.addNode(3, SEMICOLON_SEMICOLON);
		myTree.addNode(3, VALUE_SPECIFICATION);
		myTree.addNode(4, VAL_KEYWORD);
		myTree.addNode(4, VALUE_NAME_PATTERN);
		myTree.addNode(5, LCFC_IDENTIFIER, "c");
		myTree.addNode(4, COLON);
		myTree.addNode(4, TYPE_CONSTRUCTOR_NAME);
		myTree.addNode(5, LCFC_IDENTIFIER, "int");

		doTest("val a : int val b : int;; val c : int", myTree.getStringRepresentation());
	}

	@Test
	public void testValueSpecification() throws Exception
	{
		myTree.addNode(3, VALUE_SPECIFICATION);
		myTree.addNode(4, VAL_KEYWORD);
		myTree.addNode(4, VALUE_NAME_PATTERN);
		myTree.addNode(5, LCFC_IDENTIFIER, "a");
		myTree.addNode(4, COLON);
		myTree.addNode(4, TYPE_CONSTRUCTOR_NAME);
		myTree.addNode(5, LCFC_IDENTIFIER, "int");

		doTest("val a : int", myTree.getStringRepresentation());
	}

	@Test
	public void testExceptionSpecification() throws Exception
	{
		myTree.addNode(3, EXCEPTION_SPECIFICATION);
		myTree.addNode(4, EXCEPTION_KEYWORD);
		myTree.addNode(4, CONSTRUCTOR_NAME_DEFINITION);
		myTree.addNode(5, UCFC_IDENTIFIER, "Error");

		doTest("exception Error", myTree.getStringRepresentation());

		recreateTree();

		myTree.addNode(3, EXCEPTION_SPECIFICATION);
		myTree.addNode(4, EXCEPTION_KEYWORD);
		myTree.addNode(4, CONSTRUCTOR_NAME_DEFINITION);
		myTree.addNode(5, UCFC_IDENTIFIER, "Error");
		myTree.addNode(4, OF_KEYWORD);
		myTree.addNode(4, TYPE_CONSTRUCTOR_NAME);
		myTree.addNode(5, LCFC_IDENTIFIER, "int");

		doTest("exception Error of int", myTree.getStringRepresentation());
	}

	@Test
	public void testIncludeSpecification() throws Exception
	{
		myTree.addNode(3, INCLUDE_DIRECTIVE_SPECIFICATION);
		myTree.addNode(4, INCLUDE_KEYWORD);
		myTree.addNode(4, MODULE_TYPE_NAME);
		myTree.addNode(5, UCFC_IDENTIFIER, "ModuleType");

		doTest("include ModuleType", myTree.getStringRepresentation());
	}

	@Test
	public void testEmptyFile() throws Exception
	{
		myTree = new TreeStringBuilder(false);
		myTree.addNode(0, MLI_FILE);
		myTree.addNode(1, FILE_MODULE_SPECIFICATION_BINDING);
		myTree.addNode(2, FILE_MODULE_TYPE, "");

		doTest("", myTree.getStringRepresentation());
	}

	@NotNull
	protected ParserDefinition getParserDefinition()
	{
		return new MLIParserDefinition();
	}

	@NotNull
	protected IElementType getModuleExpressionNodeType()
	{
		return OCamlElementTypes.FILE_MODULE_TYPE;
	}

	@NotNull
	protected IElementType getModuleBindingNodeType()
	{
		return OCamlElementTypes.FILE_MODULE_SPECIFICATION_BINDING;
	}
}