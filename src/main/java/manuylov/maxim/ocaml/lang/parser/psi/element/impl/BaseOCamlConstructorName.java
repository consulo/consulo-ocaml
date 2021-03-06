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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.intellij.lang.ASTNode;
import manuylov.maxim.ocaml.lang.feature.resolving.NameType;
import manuylov.maxim.ocaml.lang.feature.resolving.OCamlResolvedReference;
import manuylov.maxim.ocaml.lang.feature.resolving.impl.BaseOCamlReference;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlPsiUtil;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlConstructorDefinition;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlConstructorName;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlConstructorNameDefinition;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlModuleName;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlResolvedMethod;

/**
 * @author Maxim.Manuylov
 *         Date: 21.03.2009
 */
abstract class BaseOCamlConstructorName extends BaseOCamlReference implements OCamlConstructorName
{
	@Nonnull
	private static final Set<String> ourBundledConstructors = new HashSet<String>()
	{{
			add("Division_by_zero");
			add("End_of_file");
			add("Failure");
			add("Invalid_argument");
			add("None");
			add("Some");
			add("Sys_error");
		}};

	@Override
	public boolean isBundled()
	{
		return ourBundledConstructors.contains(getName());
	}

	public BaseOCamlConstructorName(@Nonnull final ASTNode node)
	{
		super(node);
	}

	@Nullable
	public ASTNode getNameElement()
	{
		return getNode();
	}

	@Nonnull
	public NameType getNameType()
	{
		return NameType.UpperCase;
	}

	@Nonnull
	public String getDescription()
	{
		return "constructor";
	}

	@Nonnull
	public List<Class<? extends OCamlResolvedReference>> getPossibleResolvedTypes()
	{
		return Arrays.asList(OCamlConstructorDefinition.class, OCamlConstructorNameDefinition.class);
	}

	@Nonnull
	public List<OCamlModuleName> getModulePath()
	{
		return OCamlPsiUtil.getModulePath(this, OCamlModuleName.class);
	}

	@Nonnull
	public List<OCamlResolvedMethod> getAvailableMethods()
	{
		return Collections.emptyList();
	}
}
