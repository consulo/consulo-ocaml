package consulo.ocaml.module.extension;

import javax.annotation.Nonnull;
import com.intellij.openapi.projectRoots.SdkType;
import consulo.module.extension.impl.ModuleExtensionWithSdkImpl;
import consulo.roots.ModuleRootLayer;
import manuylov.maxim.ocaml.sdk.OCamlSdkType;

/**
 * @author VISTALL
 * @since 18.02.14
 */
public class OCamlModuleExtension extends ModuleExtensionWithSdkImpl<OCamlModuleExtension>
{
	public OCamlModuleExtension(@Nonnull String id, @Nonnull ModuleRootLayer module)
	{
		super(id, module);
	}

	@Nonnull
	@Override
	public Class<? extends SdkType> getSdkTypeClass()
	{
		return OCamlSdkType.class;
	}
}
