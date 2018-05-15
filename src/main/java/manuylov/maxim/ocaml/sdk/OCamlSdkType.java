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

package manuylov.maxim.ocaml.sdk;

import java.io.File;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.jetbrains.annotations.NonNls;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.process.ProcessOutput;
import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.projectRoots.SdkModificator;
import com.intellij.openapi.projectRoots.SdkType;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.SmartList;
import consulo.roots.types.BinariesOrderRootType;
import consulo.roots.types.SourcesOrderRootType;
import consulo.ui.image.Image;
import manuylov.maxim.ocaml.util.OCamlIconUtil;
import manuylov.maxim.ocaml.util.OCamlSystemUtil;

/**
 * @author Maxim.Manuylov
 *         Date: 03.04.2010
 */
public class OCamlSdkType extends SdkType
{
	@Nonnull
	public static OCamlSdkType getInstance()
	{
		return EP_NAME.findExtension(OCamlSdkType.class);
	}

	public OCamlSdkType()
	{
		super("OCaml SDK");
	}

	@Override
	@Nonnull
	public Image getIcon()
	{
		return OCamlIconUtil.getSmallOCamlIcon();
	}

	@Nonnull
	@Override
	public Collection<String> suggestHomePaths()
	{
		List<String> list = new SmartList<String>();
		if(SystemInfo.isWindows)
		{
			list.add("C:\\cygwin\\bin");
		}
		else if(SystemInfo.isLinux)
		{
			list.add("/usr/bin");
		}
		return list;
	}

	@Override
	public boolean isValidSdkHome(@Nonnull final String path)
	{
		final File ocaml = getTopLevelExecutable(path);
		final File ocamlc = getByteCodeCompilerExecutable(path);
		final File ocamlrun = getByteCodeInterpreterExecutable(path);
		final File ocamlopt = getNativeCompilerExecutable(path);
		final File ocamldebug = getDebuggerExecutable(path);
		return ocaml.canExecute() && ocamlc.canExecute() && ocamlrun.canExecute() && ocamlopt.canExecute() && ocamldebug.canExecute();
	}

	@Nonnull
	public static File getTopLevelExecutable(@Nonnull final String sdkHome)
	{
		return getExecutable(sdkHome, "ocaml");
	}

	@Nonnull
	public static File getByteCodeCompilerExecutable(@Nonnull final String sdkHome)
	{
		return getExecutable(sdkHome, "ocamlc");
	}

	@Nonnull
	public static File getByteCodeInterpreterExecutable(@Nonnull final String sdkHome)
	{
		return getExecutable(sdkHome, "ocamlrun");
	}

	@Nonnull
	public static File getDebuggerExecutable(@Nonnull final String sdkHome)
	{
		return getExecutable(sdkHome, "ocamldebug");
	}

	@Nonnull
	public static File getNativeCompilerExecutable(@Nonnull final String sdkHome)
	{
		return getExecutable(sdkHome, "ocamlopt");
	}

	@Override
	@Nonnull
	public String suggestSdkName(@Nullable final String currentSdkName, @Nonnull final String sdkHome)
	{
		String version = getVersionString(sdkHome);
		if(version == null)
		{
			return "Unknown at " + sdkHome;
		}
		return "OCaml " + version;
	}

	@Override
	@Nullable
	public String getVersionString(@Nonnull final String sdkHome)
	{
		final String exePath = getByteCodeCompilerExecutable(sdkHome).getAbsolutePath();
		final ProcessOutput processOutput;
		try
		{
			processOutput = OCamlSystemUtil.getProcessOutput(sdkHome, exePath, "-version");
		}
		catch(final ExecutionException e)
		{
			return null;
		}
		if(processOutput.getExitCode() != 0)
		{
			return null;
		}
		final String stdout = processOutput.getStdout().trim();
		return stdout.isEmpty() ? null : stdout;
	}

	@Nonnull
	@Override
	@NonNls
	public String getPresentableName()
	{
		return "OCaml SDK";
	}

	@Override
	public void setupSdkPaths(@Nonnull final Sdk sdk)
	{
		final SdkModificator[] sdkModificatorHolder = new SdkModificator[]{null};
		final ProgressManager progressManager = ProgressManager.getInstance();
		final Project project = DataManager.getInstance().getDataContext().getData(PlatformDataKeys.PROJECT);
		final Task.Modal setupTask = new Task.Modal(project, "Setting up library files", false)
		{
			@Override
			public void run(@Nonnull final ProgressIndicator indicator)
			{
				sdkModificatorHolder[0] = setupSdkPathsUnderProgress(sdk);
			}
		};
		progressManager.run(setupTask);
		if(sdkModificatorHolder[0] != null)
		{
			sdkModificatorHolder[0].commitChanges();
		}
	}

	@Nonnull
	protected SdkModificator setupSdkPathsUnderProgress(@Nonnull final Sdk sdk)
	{
		final SdkModificator sdkModificator = sdk.getSdkModificator();
		doSetupSdkPaths(sdkModificator);
		return sdkModificator;
	}

	public void doSetupSdkPaths(@Nonnull final SdkModificator sdkModificator)
	{
		final String sdkHome = sdkModificator.getHomePath();

		{
			final File stdLibDir = new File(new File(new File(sdkHome).getParentFile(), "lib"), "ocaml");
			if(tryToProcessAsStandardLibraryDir(sdkModificator, stdLibDir))
			{
				return;
			}
		}

		try
		{
			final String exePath = getByteCodeCompilerExecutable(sdkHome).getAbsolutePath();
			final ProcessOutput processOutput = OCamlSystemUtil.getProcessOutput(sdkHome, exePath, "-where");
			if(processOutput.getExitCode() == 0)
			{
				final String stdout = processOutput.getStdout().trim();
				if(!stdout.isEmpty())
				{
					if(SystemInfo.isWindows && stdout.startsWith("/"))
					{
						for(final File root : File.listRoots())
						{
							final File stdLibDir = new File(root, stdout);
							if(tryToProcessAsStandardLibraryDir(sdkModificator, stdLibDir))
							{
								return;
							}
						}
					}
					else
					{
						final File stdLibDir = new File(stdout);
						if(tryToProcessAsStandardLibraryDir(sdkModificator, stdLibDir))
						{
							return;
						}
					}
				}
			}
		}
		catch(final ExecutionException ignore)
		{
		}

		final File stdLibDir = new File("/usr/lib/ocaml");
		tryToProcessAsStandardLibraryDir(sdkModificator, stdLibDir);
	}

	private boolean tryToProcessAsStandardLibraryDir(@Nonnull final SdkModificator sdkModificator, @Nonnull final File stdLibDir)
	{
		if(!isStandardLibraryDir(stdLibDir))
		{
			return false;
		}
		final VirtualFile dir = LocalFileSystem.getInstance().findFileByIoFile(stdLibDir);
		if(dir != null)
		{
			sdkModificator.addRoot(dir, SourcesOrderRootType.getInstance());
			sdkModificator.addRoot(dir, BinariesOrderRootType.getInstance());
		}
		return true;
	}

	private boolean isStandardLibraryDir(@Nonnull final File dir)
	{
		if(!dir.isDirectory())
		{
			return false;
		}
		final File pervasives_ml = new File(dir, "pervasives.ml");
		final File pervasives_mli = new File(dir, "pervasives.mli");
		final File pervasives_cmi = new File(dir, "pervasives.cmi");
		final File pervasives_cmx = new File(dir, "pervasives.cmx");
		return pervasives_ml.isFile() && pervasives_mli.isFile() && pervasives_cmi.isFile() && pervasives_cmx.isFile();
	}

	@Nonnull
	private static File getExecutable(@Nonnull final String path, @Nonnull final String command)
	{
		return new File(path, SystemInfo.isWindows ? command + ".exe" : command);
	}
}