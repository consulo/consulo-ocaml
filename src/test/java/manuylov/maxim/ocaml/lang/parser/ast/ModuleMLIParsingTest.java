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
import static manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes.LCFC_IDENTIFIER;
import static manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes.LPAR;
import static manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes.MODULE_KEYWORD;
import static manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes.RPAR;
import static manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes.TYPE_KEYWORD;
import static manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes.UCFC_IDENTIFIER;
import static manuylov.maxim.ocaml.lang.parser.ast.element.OCamlElementTypes.MODULE_NAME;
import static manuylov.maxim.ocaml.lang.parser.ast.element.OCamlElementTypes.MODULE_PARAMETER;
import static manuylov.maxim.ocaml.lang.parser.ast.element.OCamlElementTypes.MODULE_SPECIFICATION;
import static manuylov.maxim.ocaml.lang.parser.ast.element.OCamlElementTypes.MODULE_SPECIFICATION_BINDING;
import static manuylov.maxim.ocaml.lang.parser.ast.element.OCamlElementTypes.MODULE_TYPE_NAME;
import static manuylov.maxim.ocaml.lang.parser.ast.element.OCamlElementTypes.MODULE_TYPE_SPECIFICATION;
import static manuylov.maxim.ocaml.lang.parser.ast.element.OCamlElementTypes.MODULE_TYPE_SPECIFICATION_BINDING;
import static manuylov.maxim.ocaml.lang.parser.ast.element.OCamlElementTypes.PARENTHESES;

import javax.annotation.Nonnull;
import org.junit.Test;
import com.intellij.lang.ParserDefinition;
import com.intellij.psi.tree.IElementType;
import manuylov.maxim.ocaml.fileType.mli.parser.MLIParserDefinition;
import manuylov.maxim.ocaml.lang.parser.ast.element.OCamlElementTypes;

/**
 * @author Maxim.Manuylov
 *         Date: 19.03.2009
 */
public abstract class ModuleMLIParsingTest extends BaseModuleParsingTest
{
	@Test
	public void testModuleType() throws Exception
	{
		myTree.addNode(3, MODULE_TYPE_SPECIFICATION);
		myTree.addNode(4, MODULE_KEYWORD);
		myTree.addNode(4, TYPE_KEYWORD);
		myTree.addNode(4, MODULE_TYPE_SPECIFICATION_BINDING);
		myTree.addNode(5, MODULE_TYPE_NAME);
		myTree.addNode(6, LCFC_IDENTIFIER, "m");

		doTest("module type m", myTree.getStringRepresentation());
	}

	@Test
	public void testModuleSpecification() throws Exception
	{
		myTree.addNode(3, MODULE_SPECIFICATION);
		myTree.addNode(4, MODULE_KEYWORD);
		myTree.addNode(4, MODULE_SPECIFICATION_BINDING);
		myTree.addNode(5, MODULE_NAME);
		myTree.addNode(6, UCFC_IDENTIFIER, "MyModule");
		myTree.addNode(5, COLON);
		myTree.addNode(5, MODULE_TYPE_NAME);
		myTree.addNode(6, UCFC_IDENTIFIER, "ModuleTypeName");

		doTest("module MyModule : ModuleTypeName", myTree.getStringRepresentation());

		recreateTree();

		myTree.addNode(3, MODULE_SPECIFICATION);
		myTree.addNode(4, MODULE_KEYWORD);
		myTree.addNode(4, MODULE_SPECIFICATION_BINDING);
		myTree.addNode(5, MODULE_NAME);
		myTree.addNode(6, UCFC_IDENTIFIER, "MyModule");
		myTree.addNode(5, PARENTHESES);
		myTree.addNode(6, LPAR);
		myTree.addNode(6, MODULE_PARAMETER);
		myTree.addNode(7, MODULE_NAME);
		myTree.addNode(8, UCFC_IDENTIFIER, "Module1");
		myTree.addNode(7, COLON);
		myTree.addNode(7, MODULE_TYPE_NAME);
		myTree.addNode(8, UCFC_IDENTIFIER, "ModuleTypeName1");
		myTree.addNode(6, RPAR);
		myTree.addNode(5, PARENTHESES);
		myTree.addNode(6, LPAR);
		myTree.addNode(6, MODULE_PARAMETER);
		myTree.addNode(7, MODULE_NAME);
		myTree.addNode(8, UCFC_IDENTIFIER, "Module2");
		myTree.addNode(7, COLON);
		myTree.addNode(7, MODULE_TYPE_NAME);
		myTree.addNode(8, UCFC_IDENTIFIER, "ModuleTypeName2");
		myTree.addNode(6, RPAR);
		myTree.addNode(5, COLON);
		myTree.addNode(5, MODULE_TYPE_NAME);
		myTree.addNode(6, UCFC_IDENTIFIER, "ModuleTypeName");

		doTest("module MyModule (Module1 : ModuleTypeName1) (Module2 : ModuleTypeName2) : ModuleTypeName", myTree.getStringRepresentation());
	}

	@Nonnull
	protected IElementType getMainElement()
	{
		return MODULE_TYPE_SPECIFICATION;
	}

	@Nonnull
	@Override
	protected IElementType getTypeBindingElement()
	{
		return MODULE_TYPE_SPECIFICATION_BINDING;
	}

	@Nonnull
	protected ParserDefinition getParserDefinition()
	{
		return new MLIParserDefinition();
	}

	@Nonnull
	protected IElementType getModuleExpressionNodeType()
	{
		return OCamlElementTypes.FILE_MODULE_TYPE;
	}

	@Nonnull
	protected IElementType getModuleBindingNodeType()
	{
		return OCamlElementTypes.FILE_MODULE_SPECIFICATION_BINDING;
	}
}