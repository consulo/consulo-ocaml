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

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.lang.ASTNode;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlElementVisitor;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlPsiUtil;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlClassMethodAccessingExpression;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlExpression;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlMethodName;

/**
 * @author Maxim.Manuylov
 *         Date: 21.03.2009
 */
public class OCamlClassMethodAccessingExpressionImpl extends BaseOCamlElement implements OCamlClassMethodAccessingExpression
{
	public OCamlClassMethodAccessingExpressionImpl(@NotNull final ASTNode node)
	{
		super(node);
	}

	@Override
	public boolean endsCorrectly()
	{
		return OCamlPsiUtil.endsCorrectlyWith(this, OCamlMethodName.class);
	}

	public void visit(@NotNull final OCamlElementVisitor visitor)
	{
		visitor.visitClassMethodAccessingExpression(this);
	}

	@Nullable
	public OCamlExpression getObject()
	{
		final List<OCamlExpression> children = OCamlPsiUtil.getChildrenOfType(this, OCamlExpression.class);
		return children.size() == 0 ? null : children.get(0);
	}
}
