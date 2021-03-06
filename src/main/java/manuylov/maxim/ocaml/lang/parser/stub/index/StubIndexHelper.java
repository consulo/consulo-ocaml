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

package manuylov.maxim.ocaml.lang.parser.stub.index;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.annotation.Nonnull;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.stubs.StubIndexKey;
import manuylov.maxim.ocaml.fileType.ml.MLFileType;
import manuylov.maxim.ocaml.fileType.mli.MLIFileType;

/**
 * @author Maxim.Manuylov
 *         Date: 30.04.2010
 */
public class StubIndexHelper<Key, Psi extends PsiElement>
{
	@Nonnull
	private final StubIndexKey<Key, Psi> myIndexKey;

	private StubIndexHelper(@Nonnull final StubIndexKey<Key, Psi> indexKey)
	{
		myIndexKey = indexKey;
	}

	@Nonnull
	public static <Key, Psi extends PsiElement> StubIndexHelper<Key, Psi> getInstance(@Nonnull final StubIndexKey<Key, Psi> indexKey)
	{
		return new StubIndexHelper<Key, Psi>(indexKey);
	}

	@Nonnull
	public Collection<Key> getAllKeysInScope(@Nonnull final Project project, @Nonnull final GlobalSearchScope scope)
	{
		final StubIndex stubIndex = StubIndex.getInstance();

		final Collection<Key> allKeys = new HashSet<Key>();
		allKeys.addAll(stubIndex.getAllKeys(myIndexKey, project));

		final Iterator<Key> iterator = allKeys.iterator();
		while(iterator.hasNext())
		{
			final Key key = iterator.next();
			if(stubIndex.get(myIndexKey, key, project, scope).isEmpty())
			{
				iterator.remove();
			}
		}

		return allKeys;
	}

	@Nonnull
	public Collection<Key> getAllKeys(@Nonnull final Project project, final boolean includeNonProjectItems)
	{
		return getAllKeysInScope(project, createScope(project, includeNonProjectItems));
	}

	@Nonnull
	public static GlobalSearchScope createScope(@Nonnull final Project project, final boolean includeNonProjectItems)
	{
		final GlobalSearchScope baseScope = includeNonProjectItems ? GlobalSearchScope.allScope(project) : GlobalSearchScope.projectScope(project);
		return GlobalSearchScope.getScopeRestrictedByFileTypes(baseScope, MLFileType.INSTANCE, MLIFileType.INSTANCE);
	}
}
