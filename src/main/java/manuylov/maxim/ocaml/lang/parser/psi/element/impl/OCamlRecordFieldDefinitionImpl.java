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
import manuylov.maxim.ocaml.lang.feature.resolving.NameType;
import manuylov.maxim.ocaml.lang.feature.resolving.impl.BaseOCamlResolvedReference;
import manuylov.maxim.ocaml.lang.parser.ast.element.OCamlElementTypes;
import manuylov.maxim.ocaml.lang.parser.ast.util.OCamlASTTreeUtil;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlElementVisitor;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlPsiUtil;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlPolyTypeExpression;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlRecordFieldDefinition;

/**
 * @author Maxim.Manuylov
 *         Date: 21.03.2009
 */
public class OCamlRecordFieldDefinitionImpl extends BaseOCamlResolvedReference implements OCamlRecordFieldDefinition
{
	public OCamlRecordFieldDefinitionImpl(@Nonnull final ASTNode node)
	{
		super(node);
	}

	@Override
	public boolean endsCorrectly()
	{
		return OCamlPsiUtil.endsCorrectlyWith(this, OCamlPolyTypeExpression.class);
	}

	public void visit(@Nonnull final OCamlElementVisitor visitor)
	{
		visitor.visitRecordFieldDefinition(this);
	}

	@Nullable
	public ASTNode getNameElement()
	{
		return OCamlASTTreeUtil.findChildOfType(getNode(), OCamlElementTypes.FIELD_NAME);
	}

	@Nonnull
	public NameType getNameType()
	{
		return NameType.LowerCase;
	}

	@Nonnull
	public String getDescription()
	{
		return "record field";
	}
}
