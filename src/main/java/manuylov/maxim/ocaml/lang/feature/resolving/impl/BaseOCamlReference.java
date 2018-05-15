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

package manuylov.maxim.ocaml.lang.feature.resolving.impl;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import manuylov.maxim.ocaml.lang.feature.resolving.OCamlReference;
import manuylov.maxim.ocaml.lang.feature.resolving.OCamlResolvedReference;
import manuylov.maxim.ocaml.lang.feature.resolving.ResolvingContext;
import manuylov.maxim.ocaml.lang.feature.resolving.util.OCamlResolvingUtil;
import manuylov.maxim.ocaml.lang.parser.psi.element.OCamlFile;

/**
 * @author Maxim.Manuylov
 *         Date: 23.03.2009
 */
public abstract class BaseOCamlReference extends BaseOCamlNamedElement implements OCamlReference
{
	public BaseOCamlReference(@Nonnull final ASTNode astNode)
	{
		super(astNode);
	}

	@Nonnull
	public PsiElement getElement()
	{
		return this;
	}

	@Nonnull
	@Override
	public PsiReference getReference()
	{
		return this;
	}

	@Nonnull
	public TextRange getRangeInElement()
	{
		return new TextRange(0, getTextLength());
	}

	@Nullable
	public String getCanonicalText()
	{
		return getCanonicalPath();
	}

	@Nonnull
	public PsiElement handleElementRename(@Nonnull final String newElementName) throws IncorrectOperationException
	{
		return setName(newElementName);
	}

	@Nullable
	public PsiElement bindToElement(@Nonnull final PsiElement element)
	{
		return null;
	}

	public boolean isReferenceTo(@Nonnull final PsiElement element)
	{
		return isReferenceTo_weak(element) && resolve() == element;
	}

	public boolean isReferenceToWithFakeModules(@Nonnull final PsiElement element, @Nonnull final OCamlFile... fakeModules)
	{
		return isReferenceTo_weak(element) && OCamlResolvingUtil.resolveWithFakeModules(this, fakeModules) == element;
	}

	private boolean isReferenceTo_weak(@Nonnull final PsiElement element)
	{
		return hasPossibleType(element) && Comparing.equal(getName(), ((OCamlResolvedReference) element).getName());
	}

	private boolean hasPossibleType(@Nonnull final PsiElement element)
	{
		for(final Class<? extends OCamlResolvedReference> type : getPossibleResolvedTypes())
		{
			if(type.isInstance(element))
			{
				return true;
			}
		}
		return false;
	}

	@Nonnull
	public LookupElement[] getVariants()
	{
		return OCamlResolvingUtil.getVariants(getResolvingContext(), getPossibleResolvedTypes());
	}

	public boolean isSoft()
	{
		return false;
	}

	@Nullable
	public OCamlResolvedReference resolve()
	{
		return OCamlResolvingUtil.resolve(getResolvingContext(), getPossibleResolvedTypes());
	}

	public boolean isBundled()
	{
		return false;
	}

	@Nonnull
	private ResolvingContext getResolvingContext()
	{
		return new ResolvingContext(this, getModulePath());
	}
}
