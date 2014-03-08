package org.mustbe.consulo.ocaml.module.extension;

import org.consulo.module.extension.impl.ModuleExtensionWithSdkImpl;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.projectRoots.SdkType;
import com.intellij.openapi.roots.ModifiableRootModel;
import manuylov.maxim.ocaml.sdk.OCamlSdkType;

/**
 * @author VISTALL
 * @since 18.02.14
 */
public class OCamlModuleExtension extends ModuleExtensionWithSdkImpl<OCamlModuleExtension>
{
	public OCamlModuleExtension(@NotNull String id, @NotNull ModifiableRootModel module)
	{
		super(id, module);
	}

	@Override
	protected Class<? extends SdkType> getSdkTypeClass()
	{
		return OCamlSdkType.class;
	}
}
