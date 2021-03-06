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

package manuylov.maxim.ocaml.settings;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Maxim.Manuylov
 *         Date: 04.04.2010
 */
public class OCamlState
{
	@Nullable
	private String myTopLevelSdkHomePath = null;
	@Nonnull
	private String myTopLevelCmdParams = "";
	@Nonnull
	private String myTopLevelCmdWorkingDir = "";
	@Nonnull
	private Map<String, Boolean> myExeFileStates = new HashMap<String, Boolean>();

	@Nullable
	public String getTopLevelSdkHomePath()
	{
		return myTopLevelSdkHomePath;
	}

	public void setTopLevelSdkHomePath(@Nullable final String topLevelSdkHomePath)
	{
		myTopLevelSdkHomePath = topLevelSdkHomePath;
	}

	@Nonnull
	public Map<String, Boolean> getExeFileStates()
	{
		return myExeFileStates;
	}

	public void setExeFileStates(@Nonnull final Map<String, Boolean> exeFileStates)
	{
		myExeFileStates = exeFileStates;
	}

	public void putExeFileState(@Nonnull final String exeFilePath, final boolean flag)
	{
		myExeFileStates.put(exeFilePath, flag);
	}

	public void setTopLevelCmdOptions(@Nonnull final String cmdParams)
	{
		myTopLevelCmdParams = cmdParams;
	}

	@Nonnull
	public String getTopLevelCmdOptions()
	{
		return myTopLevelCmdParams;
	}

	public void setTopLevelCmdWorkingDir(@Nonnull final String dir)
	{
		myTopLevelCmdWorkingDir = dir;
	}

	@Nonnull
	public String getTopLevelCmdWorkingDir()
	{
		return myTopLevelCmdWorkingDir;
	}
}
