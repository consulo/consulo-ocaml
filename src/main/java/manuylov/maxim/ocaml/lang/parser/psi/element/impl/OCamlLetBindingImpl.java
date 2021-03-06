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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.intellij.lang.ASTNode;
import manuylov.maxim.ocaml.lang.feature.resolving.ResolvingBuilder;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlElement;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlElementVisitor;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlPsiUtil;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlExpression;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlLetBinding;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlLetElement;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlPattern;

/**
 * @author Maxim.Manuylov
 *         Date: 21.03.2009
 */
public class OCamlLetBindingImpl extends BaseOCamlElement implements OCamlLetBinding
{
	public OCamlLetBindingImpl(@Nonnull final ASTNode node)
	{
		super(node);
	}

	public void visit(@Nonnull final OCamlElementVisitor visitor)
	{
		visitor.visitLetBinding(this);
	}

	@Override
	public boolean endsCorrectly()
	{
		return OCamlPsiUtil.endsCorrectlyWith(this, OCamlExpression.class);
	}

	@Override
	public boolean processDeclarations(@Nonnull final ResolvingBuilder builder)
	{
		final OCamlExpression expression = getExpression();
		//noinspection SimplifiableIfStatement
		if(expression != null && builder.childWasAlreadyProcessed(expression) && !isParentRecursive())
		{
			return false;
		}
		final OCamlPattern pattern = getPattern();
		return pattern != null && pattern.processDeclarations(builder);
	}

	@Nullable
	private OCamlExpression getExpression()
	{
		return OCamlPsiUtil.getLastChildOfType(this, OCamlExpression.class);
	}

	@Nullable
	private OCamlPattern getPattern()
	{
		return OCamlPsiUtil.getFirstChildOfType(this, OCamlPattern.class);
	}

	private boolean isParentRecursive()
	{
		final OCamlElement parent = OCamlPsiUtil.getParent(this);
		return parent != null && parent instanceof OCamlLetElement && ((OCamlLetElement) parent).isRecursive();
	}
}
