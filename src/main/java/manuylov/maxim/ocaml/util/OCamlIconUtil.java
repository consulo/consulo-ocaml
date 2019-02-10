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

import javax.annotation.Nonnull;

import com.intellij.openapi.util.IconLoader;
import consulo.ui.image.Image;

/**
 * @author Maxim.Manuylov
 *         Date: 04.04.2010
 */
public class OCamlIconUtil
{
	@Nonnull
	public static final Image ourMLFileIcon = IconLoader.getIcon("/img/ml-file.png");
	@Nonnull
	public static final Image ourMLIFileIcon = IconLoader.getIcon("/img/mli-file.png");
	@Nonnull
	public static final Image ourOCamlBigIcon = IconLoader.getIcon("/img/ocaml-big.png");
	@Nonnull
	public static final Image ourOCamlSmallIcon = IconLoader.getIcon("/img/ocaml-small.png");
	@Nonnull
	public static final Image ourCloseViewIcon = IconLoader.getIcon("/img/cancel.png");
	@Nonnull
	public static final Image ourSettingsIcon = IconLoader.getIcon("/img/settings.png");
	@Nonnull
	public static final Image ourOpenConsoleIcon = IconLoader.getIcon("/img/open-console.png");

	@Nonnull
	public static Image getSmallOCamlIcon()
	{
		return ourOCamlSmallIcon;
	}

	@Nonnull
	public static Image getBigOCamlIcon()
	{
		return ourOCamlBigIcon;
	}

	@Nonnull
	public static Image getMLFileIcon()
	{
		return ourMLFileIcon;
	}

	@Nonnull
	public static Image getMLIFileIcon()
	{
		return ourMLIFileIcon;
	}

	@Nonnull
	public static Image getOpenConsoleIcon()
	{
		return ourOpenConsoleIcon;
	}

	@Nonnull
	public static Image getCloseViewIcon()
	{
		return ourCloseViewIcon;
	}

	@Nonnull
	public static Image getSettingsIcon()
	{
		return ourSettingsIcon;
	}
}
