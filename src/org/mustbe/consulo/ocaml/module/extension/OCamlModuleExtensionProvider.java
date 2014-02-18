package org.mustbe.consulo.ocaml.module.extension;

import javax.swing.Icon;

import org.consulo.module.extension.ModuleExtensionProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.module.Module;
import manuylov.maxim.ocaml.util.OCamlIconUtil;

/**
 * @author VISTALL
 * @since 18.02.14
 */
public class OCamlModuleExtensionProvider implements ModuleExtensionProvider<OCamlModuleExtension, OCamlMutableModuleExtension>
{
	@Nullable
	@Override
	public Icon getIcon()
	{
		return OCamlIconUtil.ourOCamlSmallIcon;
	}

	@NotNull
	@Override
	public String getName()
	{
		return "OCaml";
	}

	@NotNull
	@Override
	public OCamlModuleExtension createImmutable(@NotNull String s, @NotNull Module module)
	{
		return new OCamlModuleExtension(s, module);
	}

	@NotNull
	@Override
	public OCamlMutableModuleExtension createMutable(@NotNull String s, @NotNull Module module)
	{
		return new OCamlMutableModuleExtension(s, module);
	}
}
