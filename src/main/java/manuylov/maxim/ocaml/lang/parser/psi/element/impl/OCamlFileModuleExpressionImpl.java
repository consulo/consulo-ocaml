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

package manuylov.maxim.ocaml.lang.parser.psi.element.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import com.intellij.lang.ASTNode;
import manuylov.maxim.ocaml.lang.feature.resolving.ElementPosition;
import manuylov.maxim.ocaml.lang.feature.resolving.ResolvingBuilder;
import manuylov.maxim.ocaml.lang.feature.resolving.util.OCamlDeclarationsUtil;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlElementVisitor;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlDefinition;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlExpression;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlFileModuleExpression;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlStructuredElement;

/**
 * @author Maxim.Manuylov
 *         Date: 24.05.2009
 */
public class OCamlFileModuleExpressionImpl extends BaseOCamlElement implements OCamlFileModuleExpression
{
	public OCamlFileModuleExpressionImpl(@Nonnull final ASTNode node)
	{
		super(node);
	}

	public void visit(@Nonnull final OCamlElementVisitor visitor)
	{
		visitor.visitFileModuleExpression(this);
	}

	@Override
	public boolean processDeclarations(@Nonnull final ResolvingBuilder builder)
	{
		return builder.getLastParentPosition() == ElementPosition.Sibling && OCamlDeclarationsUtil.processDeclarationsInChildren(builder, this,
				OCamlDefinition.class, OCamlExpression.class);
	}

	@Nonnull
	public List<OCamlStructuredElement> findActualDefinitions()
	{
		return Collections.<OCamlStructuredElement>singletonList(this);
	}
}
