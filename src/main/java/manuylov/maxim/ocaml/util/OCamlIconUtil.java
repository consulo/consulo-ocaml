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

package manuylov.maxim.ocaml.util;

import consulo.ocaml.icon.OcamlIconGroup;
import consulo.ui.image.Image;

import javax.annotation.Nonnull;

/**
 * @author Maxim.Manuylov
 *         Date: 04.04.2010
 */
public class OCamlIconUtil
{
	@Nonnull
	public static Image getSmallOCamlIcon()
	{
		return OcamlIconGroup.ocaml_small();
	}

	@Nonnull
	public static Image getBigOCamlIcon()
	{
		return OcamlIconGroup.ocaml_big();
	}

	@Nonnull
	public static Image getMLFileIcon()
	{
		return OcamlIconGroup.ml_file();
	}

	@Nonnull
	public static Image getMLIFileIcon()
	{
		return OcamlIconGroup.mli_file();
	}

	@Nonnull
	public static Image getOpenConsoleIcon()
	{
		return OcamlIconGroup.open_console();
	}

	@Nonnull
	public static Image getCloseViewIcon()
	{
		return OcamlIconGroup.cancel();
	}

	@Nonnull
	public static Image getSettingsIcon()
	{
		return OcamlIconGroup.settings();
	}
}
