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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.projectRoots.Sdk;
import manuylov.maxim.ocaml.entity.OCamlModule;

/**
 * @author Maxim.Manuylov
 *         Date: 07.04.2010
 */
public interface OCamlRunConfigurationParams
{
	@Nullable
	OCamlModule getMainOCamlModule();

	void setMainOCamlModule(@Nullable OCamlModule ocamlModule);

	@Nonnull
	String getProgramParams();

	void setProgramParams(@Nonnull String params);

	boolean isUsedModuleSdk();

	void setUsedModuleSdk(boolean usedModuleSdk);

	@Nullable
	Module getModule();

	void setModule(@Nullable Module module);

	@Nullable
	Sdk getSpecifiedSdk();

	void setSpecifiedSdk(@Nullable Sdk sdk);

	@Nonnull
	String getCompilerOptions();

	void setCompilerOptions(@Nonnull String options);

	@Nonnull
	String getLinkerOptions();

	void setLinkerOptions(@Nonnull String options);

	@Nonnull
	String getRunnerOptions();

	void setRunnerOptions(@Nonnull String options);

	@Nonnull
	String getWorkingDirectory();

	void setWorkingDirectory(@Nonnull String dirPath);
}
