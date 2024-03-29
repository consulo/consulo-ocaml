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

package manuylov.maxim.ocaml.fileType.mli;

import consulo.localize.LocalizeValue;
import consulo.ui.image.Image;
import manuylov.maxim.ocaml.fileType.OCamlFileType;
import manuylov.maxim.ocaml.fileType.ml.MLFileType;
import manuylov.maxim.ocaml.util.OCamlIconUtil;

import javax.annotation.Nonnull;

/**
 * @author Maxim.Manuylov
 *         Date: 05.02.2009
 */
public class MLIFileType extends OCamlFileType
{
	@Nonnull
	public static final MLIFileType INSTANCE = new MLIFileType();

	private MLIFileType()
	{
		super(MLIFileTypeLanguage.INSTANCE);
	}

	@Override
	@Nonnull
	public String getId()
	{
		return "OCAML_MLI_FILE";
	}

	@Override
	@Nonnull
	public LocalizeValue getDescription()
	{
		return LocalizeValue.localizeTODO("OCaml module interface files");
	}

	@Override
	@Nonnull
	public String getDefaultExtension()
	{
		return "mli";
	}

	@Override
	@Nonnull
	public Image getIcon()
	{
		return OCamlIconUtil.getMLIFileIcon();
	}

	@Nonnull
	@Override
	public OCamlFileType getAnotherFileType()
	{
		return MLFileType.INSTANCE;
	}
}