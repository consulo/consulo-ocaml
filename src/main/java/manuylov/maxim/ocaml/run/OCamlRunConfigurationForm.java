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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Nonnull;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.annotation.Nullable;
import com.intellij.application.options.ModuleListCellRenderer;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ui.configuration.projectRoot.ProjectSdksModel;
import com.intellij.openapi.ui.ComponentWithBrowseButton;
import com.intellij.openapi.ui.TextComponentAccessor;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.util.Conditions;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.CollectionComboBoxModel;
import com.intellij.ui.RawCommandLineEditor;
import consulo.roots.ui.configuration.SdkComboBox;
import manuylov.maxim.ocaml.entity.OCamlModule;
import manuylov.maxim.ocaml.sdk.OCamlSdkType;
import manuylov.maxim.ocaml.util.OCamlFileUtil;

/**
 * @author Maxim.Manuylov
 *         Date: 09.04.2010
 */
public class OCamlRunConfigurationForm implements OCamlRunConfigurationParams
{
	@Nonnull
	private JPanel myRootPanel;
	@Nonnull
	private TextFieldWithBrowseButton myMainFileEditor;
	@Nonnull
	private RawCommandLineEditor myProgramParamsEditor;
	@Nonnull
	private RawCommandLineEditor myCompilerParamsEditor;
	@Nonnull
	private RawCommandLineEditor myLinkerParamsEditor;
	@Nonnull
	private TextFieldWithBrowseButton myWorkingDirectoryEditor;
	private RawCommandLineEditor myRunnerParamsEditor;
	@Nonnull
	private JRadioButton myUseModuleSdkRadioButton;
	@Nonnull
	private JRadioButton myUseSpecifiedSdkRadioButton;
	@Nonnull
	private JComboBox myModuleComboBox;
	@Nonnull
	private consulo.roots.ui.configuration.SdkComboBox mySpecifiedSdkComboBox;
	private JButton myConfigureSdkButton;

	@Nonnull
	private final Project myProject;

	public OCamlRunConfigurationForm(@Nonnull final OCamlRunConfiguration configuration)
	{
		myProject = configuration.getProject();

		final FileChooserDescriptor mlFileChooserDescriptor = new FileChooserDescriptor(true, false, false, false, false, false)
		{
			public boolean isFileVisible(@Nonnull final VirtualFile file, final boolean showHiddenFiles)
			{
				return file.isDirectory() || OCamlFileUtil.isImplementationFile(file);
			}
		};
		mlFileChooserDescriptor.setRoots(myProject.getBaseDir());

		final ComponentWithBrowseButton.BrowseFolderActionListener<JTextField> listener = new ComponentWithBrowseButton
				.BrowseFolderActionListener<JTextField>("Select OCaml Application Main File", "", myMainFileEditor, myProject, mlFileChooserDescriptor,
				TextComponentAccessor.TEXT_FIELD_WHOLE_TEXT)
		{
			protected void onFileChosen(@Nonnull final VirtualFile chosenFile)
			{
				super.onFileChosen(chosenFile);
				setWorkingDirectory(chosenFile.getParent().getPath());
			}
		};

		myMainFileEditor.addActionListener(listener);

		final List<Module> validModules = configuration.getValidModules();
		Collections.sort(validModules, new Comparator<Module>()
		{
			public int compare(@Nonnull final Module module1, @Nonnull final Module module2)
			{
				return module1.getName().compareTo(module2.getName());
			}
		});
		validModules.add(0, null);
		myModuleComboBox.setModel(new CollectionComboBoxModel(validModules, null));
		myModuleComboBox.setRenderer(new ModuleListCellRenderer());
		myModuleComboBox.addItemListener(new ItemListener()
		{
			public void itemStateChanged(@Nonnull final ItemEvent e)
			{
				myUseModuleSdkRadioButton.setSelected(true);
				myUseSpecifiedSdkRadioButton.setSelected(false);
			}
		});

		mySpecifiedSdkComboBox.addItemListener(new ItemListener()
		{
			public void itemStateChanged(@Nonnull final ItemEvent e)
			{
				myUseSpecifiedSdkRadioButton.setSelected(true);
				myUseModuleSdkRadioButton.setSelected(false);
			}
		});

		myConfigureSdkButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(@Nonnull final ActionEvent e)
			{
			/*	final ProjectJdksEditor editor = new ProjectJdksEditor((Sdk) mySpecifiedSdkComboBox.getSelectedItem(), myProject,
					mySpecifiedSdkComboBox);
				editor.show();
				if(editor.isOK())
				{
				setSpecifiedSdk(editor.getSelectedJdk());
				}*/
			}
		});

		final FileChooserDescriptor workingDirChooserDescriptor = new FileChooserDescriptor(false, true, false, false, false, false);
		workingDirChooserDescriptor.setRoots(myProject.getBaseDir());
		myWorkingDirectoryEditor.addBrowseFolderListener("Select Working Directory", "", myProject, workingDirChooserDescriptor);
	}

	@Nonnull
	public JComponent getRootPanel()
	{
		return myRootPanel;
	}

	@Nullable
	public OCamlModule getMainOCamlModule()
	{
		final String filePath = FileUtil.toSystemIndependentName(myMainFileEditor.getText());
		final VirtualFile file = LocalFileSystem.getInstance().findFileByPath(filePath);
		if(file == null)
		{
			return null;
		}
		return OCamlModule.getBySourceFile(file, myProject);
	}

	public void setMainOCamlModule(@Nullable final OCamlModule ocamlModule)
	{
		myMainFileEditor.setText(ocamlModule == null ? "" : FileUtil.toSystemDependentName(ocamlModule.getImplementationFile().getAbsolutePath()));
	}

	@Nonnull
	public String getProgramParams()
	{
		return myProgramParamsEditor.getText();
	}

	public void setProgramParams(@Nonnull final String params)
	{
		myProgramParamsEditor.setText(params);
	}

	public boolean isUsedModuleSdk()
	{
		return myUseModuleSdkRadioButton.isSelected();
	}

	public void setUsedModuleSdk(final boolean usedModuleSdk)
	{
		myUseModuleSdkRadioButton.setSelected(usedModuleSdk);
		myUseSpecifiedSdkRadioButton.setSelected(!usedModuleSdk);
	}

	@Nullable
	public Module getModule()
	{
		return (Module) myModuleComboBox.getSelectedItem();
	}

	public void setModule(@Nullable final Module module)
	{
		if(module == null)
		{
			myModuleComboBox.setSelectedItem(null);
			return;
		}
		final String moduleName = module.getName();
		final int count = myModuleComboBox.getItemCount();
		for(int i = 0; i < count; i++)
		{
			final Module item = (Module) myModuleComboBox.getItemAt(i);
			if(item != null && moduleName.equals(item.getName()))
			{
				myModuleComboBox.setSelectedIndex(i);
				return;
			}
		}
	}

	@Nullable
	public Sdk getSpecifiedSdk()
	{
		return (Sdk) mySpecifiedSdkComboBox.getSelectedItem();
	}

	public void setSpecifiedSdk(@Nullable final Sdk sdk)
	{
		if(sdk == null)
		{
			mySpecifiedSdkComboBox.setSelectedItem(null);
			return;
		}
		final String sdkHome = sdk.getHomePath();
		final int count = mySpecifiedSdkComboBox.getItemCount();
		for(int i = 0; i < count; i++)
		{
			final Sdk item = (Sdk) mySpecifiedSdkComboBox.getItemAt(i);
			if(item != null && sdkHome.equals(item.getHomePath()))
			{
				mySpecifiedSdkComboBox.setSelectedIndex(i);
				return;
			}
		}
	}

	@Nonnull
	public String getCompilerOptions()
	{
		return myCompilerParamsEditor.getText();
	}

	public void setCompilerOptions(@Nonnull final String options)
	{
		myCompilerParamsEditor.setText(options);
	}

	@Nonnull
	public String getLinkerOptions()
	{
		return myLinkerParamsEditor.getText();
	}

	public void setLinkerOptions(@Nonnull final String options)
	{
		myLinkerParamsEditor.setText(options);
	}

	@Nonnull
	public String getRunnerOptions()
	{
		return myRunnerParamsEditor.getText();
	}

	public void setRunnerOptions(@Nonnull final String options)
	{
		myRunnerParamsEditor.setText(options);
	}

	@Nonnull
	public String getWorkingDirectory()
	{
		return FileUtil.toSystemIndependentName(myWorkingDirectoryEditor.getText());
	}

	public void setWorkingDirectory(@Nonnull final String dirPath)
	{
		myWorkingDirectoryEditor.setText(FileUtil.toSystemDependentName(dirPath));
	}

	private void createUIComponents()
	{
		ProjectSdksModel model = new ProjectSdksModel();
		model.reset();
		mySpecifiedSdkComboBox = new SdkComboBox(model, Conditions.equalTo(OCamlSdkType.getInstance()), true);
	}
}
