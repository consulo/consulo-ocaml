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

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.CapturingProcessHandler;
import com.intellij.execution.process.ProcessOutput;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.vfs.VirtualFile;

/**
 * @author Maxim.Manuylov
 *         Date: 03.04.2010
 */
public class OCamlSystemUtil
{
	public static final int STANDARD_TIMEOUT = 10 * 1000;

	@Nonnull
	public static ProcessOutput getProcessOutput(@Nonnull final String workDir, @Nonnull final String exePath,
			@Nonnull final String... arguments) throws ExecutionException
	{
		return getProcessOutput(STANDARD_TIMEOUT, workDir, exePath, arguments);
	}

	@Nonnull
	public static ProcessOutput getProcessOutput(final int timeout, @Nonnull final String workDir, @Nonnull final String exePath,
			@Nonnull final String... arguments) throws ExecutionException
	{
		if(!new File(workDir).isDirectory() || !new File(exePath).canExecute())
		{
			return new ProcessOutput();
		}

		final GeneralCommandLine cmd = new GeneralCommandLine();
		cmd.setWorkDirectory(workDir);
		cmd.setExePath(exePath);
		cmd.addParameters(arguments);

		return execute(cmd, timeout);
	}

	@Nonnull
	public static ProcessOutput execute(@Nonnull final GeneralCommandLine cmd) throws ExecutionException
	{
		return execute(cmd, STANDARD_TIMEOUT);
	}

	@Nonnull
	public static ProcessOutput execute(@Nonnull final GeneralCommandLine cmd, final int timeout) throws ExecutionException
	{
		final CapturingProcessHandler processHandler = new CapturingProcessHandler(cmd);
		return timeout < 0 ? processHandler.runProcess() : processHandler.runProcess(timeout);
	}

	public static void addStdPaths(@Nonnull final GeneralCommandLine cmd, @Nonnull final Sdk sdk)
	{
		final List<VirtualFile> files = new ArrayList<VirtualFile>();
		files.addAll(Arrays.asList(sdk.getRootProvider().getFiles(OrderRootType.SOURCES)));
		files.addAll(Arrays.asList(sdk.getRootProvider().getFiles(OrderRootType.CLASSES)));
		final Set<String> paths = new HashSet<String>();
		for(final VirtualFile file : files)
		{
			paths.add(OCamlFileUtil.getPathToDisplay(file));
		}
		for(final String path : paths)
		{
			cmd.addParameter("-I");
			cmd.addParameter(path);
		}
	}
}
