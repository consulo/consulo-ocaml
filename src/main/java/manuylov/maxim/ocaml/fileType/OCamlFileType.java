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

package manuylov.maxim.ocaml.fileType;

import javax.annotation.Nonnull;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.LanguageFileType;

/**
 * @author Maxim.Manuylov
 *         Date: 28.03.2009
 */
public abstract class OCamlFileType extends LanguageFileType implements FileType
{
	@Nonnull
	private final OCamlFileTypeLanguage myLanguage;

	protected OCamlFileType(@Nonnull final OCamlFileTypeLanguage language)
	{
		super(language);
		myLanguage = language;
	}

	@Nonnull
	public OCamlFileTypeLanguage getOCamlFileTypeLanguage()
	{
		return myLanguage;
	}

	@Nonnull
	public abstract OCamlFileType getAnotherFileType();
}
