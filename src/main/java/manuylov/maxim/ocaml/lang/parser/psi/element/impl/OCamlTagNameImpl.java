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
import javax.annotation.Nullable;
import com.intellij.lang.ASTNode;
import manuylov.maxim.ocaml.lang.feature.resolving.NameType;
import manuylov.maxim.ocaml.lang.feature.resolving.OCamlResolvedReference;
import manuylov.maxim.ocaml.lang.feature.resolving.impl.BaseOCamlReference;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlElementVisitor;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlExtendedModuleName;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlTagName;

/**
 * @author Maxim.Manuylov
 *         Date: 21.03.2009
 */
public class OCamlTagNameImpl extends BaseOCamlReference implements OCamlTagName
{
	public OCamlTagNameImpl(@Nonnull final ASTNode node)
	{
		super(node);
	}

	public void visit(@Nonnull final OCamlElementVisitor visitor)
	{
		visitor.visitTagName(this);
	}

	@Nullable
	public ASTNode getNameElement()
	{
		return getNode();
	}

	@Nonnull
	public NameType getNameType()
	{
		return NameType.AnyCase;
	}

	@Nonnull
	public String getDescription()
	{
		return "tag";
	}

	@Nonnull
	public List<Class<? extends OCamlResolvedReference>> getPossibleResolvedTypes()
	{
		return Collections.emptyList(); //todo
	}

	@Nonnull
	public List<OCamlExtendedModuleName> getModulePath()
	{
		return Collections.emptyList();
	}

	@Override
	public boolean isSoft()
	{
		return true; // todo
	}
}
