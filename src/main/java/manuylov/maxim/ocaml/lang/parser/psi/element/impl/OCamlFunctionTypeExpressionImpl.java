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
import manuylov.maxim.ocaml.lang.parser.psi.OCamlElementVisitor;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlPsiUtil;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlFunctionTypeExpression;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlStructuredElement;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlTypeExpression;

/**
 * @author Maxim.Manuylov
 *         Date: 21.03.2009
 */
public class OCamlFunctionTypeExpressionImpl extends BaseOCamlElement implements OCamlFunctionTypeExpression
{
	public OCamlFunctionTypeExpressionImpl(@Nonnull final ASTNode node)
	{
		super(node);
	}

	public void visit(@Nonnull final OCamlElementVisitor visitor)
	{
		visitor.visitFunctionTypeExpression(this);
	}

	@Override
	public boolean endsCorrectly()
	{
		return OCamlPsiUtil.endsCorrectlyWith(this, OCamlTypeExpression.class);
	}

	@Nonnull
	public List<OCamlStructuredElement> findActualDefinitions()
	{
		return Collections.<OCamlStructuredElement>singletonList(this);
	}
}
