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

import javax.swing.Icon;

import org.jetbrains.annotations.NotNull;
import manuylov.maxim.ocaml.fileType.OCamlFileType;
import manuylov.maxim.ocaml.fileType.ml.MLFileType;
import manuylov.maxim.ocaml.util.OCamlIconUtil;

/**
 * @author Maxim.Manuylov
 *         Date: 05.02.2009
 */
public class MLIFileType extends OCamlFileType
{
	@NotNull
	public static final MLIFileType INSTANCE = new MLIFileType();

	private MLIFileType()
	{
		super(MLIFileTypeLanguage.INSTANCE);
	}

	@Override
	@NotNull
	public String getName()
	{
		return "OCAML_MLI_FILE";
	}

	@Override
	@NotNull
	public String getDescription()
	{
		return "OCaml module interface files";
	}

	@Override
	@NotNull
	public String getDefaultExtension()
	{
		return "mli";
	}

	@Override
	@NotNull
	public Icon getIcon()
	{
		return OCamlIconUtil.getMLIFileIcon();
	}

	@NotNull
	@Override
	public OCamlFileType getAnotherFileType()
	{
		return MLFileType.INSTANCE;
	}
}