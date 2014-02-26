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

import javax.swing.Icon;

import org.jetbrains.annotations.NotNull;
import org.mustbe.consulo.module.extension.ModuleExtensionHelper;
import org.mustbe.consulo.ocaml.module.extension.OCamlModuleExtension;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunConfigurationModule;
import com.intellij.openapi.extensions.Extensions;
import com.intellij.openapi.project.Project;
import manuylov.maxim.ocaml.util.OCamlIconUtil;

/**
 * @author Maxim.Manuylov
 *         Date: 07.04.2010
 */
public class OCamlConfigurationType implements ConfigurationType
{
	@NotNull
	public static OCamlConfigurationType getInstance()
	{
		for(final ConfigurationType configurationType : Extensions.getExtensions(CONFIGURATION_TYPE_EP))
		{
			if(configurationType instanceof OCamlConfigurationType)
			{
				return (OCamlConfigurationType) configurationType;
			}
		}
		throw new Error();
	}

	@NotNull
	private final ConfigurationFactory myConfigurationFactory = new ConfigurationFactory(this)
	{
		@Override
		public RunConfiguration createTemplateConfiguration(@NotNull final Project project)
		{
			return new OCamlRunConfiguration(new RunConfigurationModule(project), this, "");
		}

		@Override
		public boolean isApplicable(@NotNull Project project)
		{
			return ModuleExtensionHelper.getInstance(project).hasModuleExtension(OCamlModuleExtension.class);
		}
	};

	@Override
	@NotNull
	public String getDisplayName()
	{
		return "OCaml Application";
	}

	@Override
	@NotNull
	public String getConfigurationTypeDescription()
	{
		return "OCaml application run configuration";
	}

	@Override
	@NotNull
	public Icon getIcon()
	{
		return OCamlIconUtil.getSmallOCamlIcon();
	}

	@Override
	@NotNull
	public String getId()
	{
		return "OCAML_CONFIGURATION_TYPE";
	}

	@Override
	@NotNull
	public ConfigurationFactory[] getConfigurationFactories()
	{
		return new ConfigurationFactory[]{myConfigurationFactory};
	}
}
