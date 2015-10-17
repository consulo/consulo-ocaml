package org.mustbe.consulo.ocaml.module.extension;

import javax.swing.JComponent;

import org.consulo.module.extension.MutableModuleExtensionWithSdk;
import org.consulo.module.extension.MutableModuleInheritableNamedPointer;
import org.consulo.module.extension.ui.ModuleExtensionSdkBoxBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mustbe.consulo.RequiredDispatchThread;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ModuleRootLayer;
import com.intellij.util.ui.JBUI;

/**
 * @author VISTALL
 * @since 18.02.14
 */
public class OCamlMutableModuleExtension extends OCamlModuleExtension implements MutableModuleExtensionWithSdk<OCamlModuleExtension>
{
	public OCamlMutableModuleExtension(@NotNull String id, @NotNull ModuleRootLayer module)
	{
		super(id, module);
	}

	@RequiredDispatchThread
	@Nullable
	@Override
	public JComponent createConfigurablePanel(@Nullable Runnable runnable)
	{
		return JBUI.Panels.simplePanel().addToTop(ModuleExtensionSdkBoxBuilder.createAndDefine(this, runnable).build());
	}

	@NotNull
	@Override
	public MutableModuleInheritableNamedPointer<Sdk> getInheritableSdk()
	{
		return (MutableModuleInheritableNamedPointer<Sdk>) super.getInheritableSdk();
	}

	@Override
	public void setEnabled(boolean b)
	{
		myIsEnabled = b;
	}

	@Override
	public boolean isModified(@NotNull OCamlModuleExtension oCamlModuleExtension)
	{
		return isModifiedImpl(oCamlModuleExtension);
	}
}
