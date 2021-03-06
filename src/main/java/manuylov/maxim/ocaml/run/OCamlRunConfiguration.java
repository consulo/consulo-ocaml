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

package manuylov.maxim.ocaml.run;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.jdom.Element;

import javax.annotation.Nullable;
import consulo.ocaml.module.extension.OCamlModuleExtension;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ModuleBasedConfiguration;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunConfigurationModule;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.projectRoots.SdkTable;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.JDOMExternalizerUtil;
import com.intellij.openapi.util.WriteExternalException;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import manuylov.maxim.ocaml.entity.OCamlModule;
import manuylov.maxim.ocaml.sdk.OCamlSdkType;
import manuylov.maxim.ocaml.util.OCamlModuleUtil;

/**
 * @author Maxim.Manuylov
 *         Date: 07.04.2010
 */
public class OCamlRunConfiguration extends ModuleBasedConfiguration<RunConfigurationModule> implements RunConfiguration, OCamlRunConfigurationParams
{
	@Nullable
	private VirtualFile myMLFile = null;
	@Nonnull
	private String myProgramParams = "";
	private boolean myIsUsedModuleSdk = true;
	@Nullable
	private Sdk mySpecifiedSdk = null;
	@Nonnull
	private String myCompilerOptions = "";
	@Nonnull
	private String myLinkerOptions = "";
	@Nonnull
	private String myRunnerOptions = "";
	@Nonnull
	private String myWorkingDirectory = "";

	public OCamlRunConfiguration(@Nonnull final RunConfigurationModule runConfigurationModule, @Nonnull final ConfigurationFactory factory,
			@Nonnull final String name)
	{
		super(name, runConfigurationModule, factory);
	}

	@Override
	@Nonnull
	public List<Module> getValidModules()
	{
		final Module[] modules = ModuleManager.getInstance(getProject()).getModules();
		final List<Module> result = new ArrayList<Module>();
		for(final Module module : modules)
		{
			if(OCamlModuleUtil.hasOCamlExtension(module))
			{
				result.add(module);
			}
		}
		return result;
	}

	@Override
	@Nonnull
	protected ModuleBasedConfiguration createInstance()
	{
		return new OCamlRunConfiguration(getConfigurationModule(), getFactory(), getName());
	}

	@Nonnull
	public SettingsEditor<? extends RunConfiguration> getConfigurationEditor()
	{
		return new OCamlRunConfigurationEditor(this);
	}

	@Nonnull
	public RunProfileState getState(@Nonnull final Executor executor, @Nonnull final ExecutionEnvironment env) throws ExecutionException
	{
		return new OCamlCommandLineState(this, executor, env);
	}

	@Override
	public void readExternal(@Nonnull final Element element) throws InvalidDataException
	{
		super.readExternal(element);
		myMLFile = null;
		final String mlFilePath = JDOMExternalizerUtil.readField(element, "ocamlModule");
		if(mlFilePath != null)
		{
			myMLFile = LocalFileSystem.getInstance().findFileByPath(FileUtil.toSystemDependentName(mlFilePath));
		}
		myProgramParams = JDOMExternalizerUtil.readField(element, "programParams");
		myIsUsedModuleSdk = Boolean.valueOf(JDOMExternalizerUtil.readField(element, "useModuleSdk"));
		readModule(element);
		mySpecifiedSdk = null;
		final String systemIndependentSdkHomePath = JDOMExternalizerUtil.readField(element, "specifiedSdkHome");
		if(systemIndependentSdkHomePath != null)
		{
			final String sdkHomePath = FileUtil.toSystemDependentName(systemIndependentSdkHomePath);
			if(sdkHomePath != null)
			{
				final List<Sdk> sdks = SdkTable.getInstance().getSdksOfType(OCamlSdkType.getInstance());
				for(final Sdk sdk : sdks)
				{
					if(sdkHomePath.equals(sdk.getHomePath()))
					{
						mySpecifiedSdk = sdk;
						break;
					}
				}
			}
		}
		myCompilerOptions = JDOMExternalizerUtil.readField(element, "compilerOptions");
		myLinkerOptions = JDOMExternalizerUtil.readField(element, "linkerOptions");
		myRunnerOptions = JDOMExternalizerUtil.readField(element, "runnerOptions");
		myWorkingDirectory = FileUtil.toSystemDependentName(JDOMExternalizerUtil.readField(element, "workingDirectory"));
	}

	@Override
	public void writeExternal(@Nonnull final Element element) throws WriteExternalException
	{
		super.writeExternal(element);
		if(myMLFile != null)
		{
			final String mlFilePath = FileUtil.toSystemIndependentName(myMLFile.getPath());
			JDOMExternalizerUtil.writeField(element, "ocamlModule", mlFilePath);
		}
		JDOMExternalizerUtil.writeField(element, "programParams", myProgramParams);
		JDOMExternalizerUtil.writeField(element, "useModuleSdk", String.valueOf(myIsUsedModuleSdk));
		writeModule(element);
		if(mySpecifiedSdk != null)
		{
			final String sdkHomePath = FileUtil.toSystemIndependentName(mySpecifiedSdk.getHomePath());
			JDOMExternalizerUtil.writeField(element, "specifiedSdkHome", sdkHomePath);
		}
		JDOMExternalizerUtil.writeField(element, "compilerOptions", myCompilerOptions);
		JDOMExternalizerUtil.writeField(element, "linkerOptions", myLinkerOptions);
		JDOMExternalizerUtil.writeField(element, "runnerOptions", myRunnerOptions);
		JDOMExternalizerUtil.writeField(element, "workingDirectory", FileUtil.toSystemIndependentName(myWorkingDirectory));
	}

	@Override
	public void checkConfiguration() throws RuntimeConfigurationException
	{
		super.checkConfiguration();

		if(myMLFile == null)
		{
			throw new RuntimeConfigurationException("Application main file must be an OCaml source implementation file and must be located under the some " +
					"OCaml module source root.");
		}

		if(myIsUsedModuleSdk)
		{
			final Module module = getModule();
			if(module == null)
			{
				throw new RuntimeConfigurationException("Please choose the valid OCaml module or select the \"Use specified SDK\" option.");
			}
			final Sdk sdk = ModuleUtilCore.getSdk(module, OCamlModuleExtension.class);
			if(!OCamlModuleUtil.isOCamlSdk(sdk))
			{
				throw new RuntimeConfigurationException("There is no valid OCaml SDK in the specified module.");
			}
		}
		else
		{
			if(mySpecifiedSdk == null || !OCamlModuleUtil.isOCamlSdk(mySpecifiedSdk))
			{
				throw new RuntimeConfigurationException("The specified SDK is not a valid OCaml SDK.");
			}
		}
	}

	@Nullable
	private OCamlModule getOCamlModule()
	{
		//noinspection ConstantConditions
		return myMLFile == null ? null : OCamlModule.getBySourceFile(myMLFile, getProject());
	}

	@Override
	public boolean isGeneratedName()
	{
		return Comparing.equal(getName(), suggestedName());
	}

	@Override
	@Nonnull
	public String suggestedName()
	{
		final OCamlModule ocamlModule = getOCamlModule();
		return ocamlModule == null ? "Unnamed" : ocamlModule.getName();
	}

	@Nullable
	public OCamlModule getMainOCamlModule()
	{
		return getOCamlModule();
	}

	public void setMainOCamlModule(@Nullable final OCamlModule ocamlModule)
	{
		myMLFile = ocamlModule == null ? null : LocalFileSystem.getInstance().findFileByIoFile(ocamlModule.getImplementationFile());
	}

	@Nonnull
	public String getProgramParams()
	{
		return myProgramParams;
	}

	public void setProgramParams(@Nonnull final String params)
	{
		myProgramParams = params;
	}

	public boolean isUsedModuleSdk()
	{
		return myIsUsedModuleSdk;
	}

	public void setUsedModuleSdk(final boolean usedModuleSdk)
	{
		myIsUsedModuleSdk = usedModuleSdk;
	}

	@Nullable
	public Module getModule()
	{
		return getConfigurationModule().getModule();
	}

	@Nullable
	public Sdk getSpecifiedSdk()
	{
		return mySpecifiedSdk;
	}

	public void setSpecifiedSdk(@Nullable final Sdk sdk)
	{
		mySpecifiedSdk = sdk;
	}

	@Nonnull
	public String getCompilerOptions()
	{
		return myCompilerOptions;
	}

	public void setCompilerOptions(@Nonnull final String options)
	{
		myCompilerOptions = options;
	}

	@Nonnull
	public String getLinkerOptions()
	{
		return myLinkerOptions;
	}

	public void setLinkerOptions(@Nonnull final String options)
	{
		myLinkerOptions = options;
	}

	@Nonnull
	public String getRunnerOptions()
	{
		return myRunnerOptions;
	}

	public void setRunnerOptions(@Nonnull final String options)
	{
		myRunnerOptions = options;
	}

	@Nonnull
	public String getWorkingDirectory()
	{
		return myWorkingDirectory;
	}

	public void setWorkingDirectory(@Nonnull final String dirPath)
	{
		myWorkingDirectory = dirPath;
	}
}
