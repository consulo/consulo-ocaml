package consulo.ocaml.module.extension;

import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.projectRoots.SdkType;
import consulo.extension.impl.ModuleExtensionWithSdkImpl;
import consulo.roots.ModuleRootLayer;
import manuylov.maxim.ocaml.sdk.OCamlSdkType;

/**
 * @author VISTALL
 * @since 18.02.14
 */
public class OCamlModuleExtension extends ModuleExtensionWithSdkImpl<OCamlModuleExtension>
{
	public OCamlModuleExtension(@NotNull String id, @NotNull ModuleRootLayer module)
	{
		super(id, module);
	}

	@NotNull
	@Override
	public Class<? extends SdkType> getSdkTypeClass()
	{
		return OCamlSdkType.class;
	}
}
