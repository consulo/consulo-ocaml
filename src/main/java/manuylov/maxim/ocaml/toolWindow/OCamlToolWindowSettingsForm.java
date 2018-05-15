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

package manuylov.maxim.ocaml.toolWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ui.configuration.projectRoot.ProjectSdksModel;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.util.Conditions;
import com.intellij.ui.RawCommandLineEditor;
import consulo.roots.ui.configuration.SdkComboBox;
import manuylov.maxim.ocaml.sdk.OCamlSdkType;

/**
 * @author Maxim.Manuylov
 *         Date: 13.04.2010
 */
public class OCamlToolWindowSettingsForm
{
	private RawCommandLineEditor myCommandLineParamsEditor;
	private consulo.roots.ui.configuration.SdkComboBox mySdkComboBox;
	private JButton myConfigureButton;
	private JPanel myRootPanel;
	private TextFieldWithBrowseButton myWorkingDirectoryEditor;

	@Nonnull
	private final Project myProject;

	public OCamlToolWindowSettingsForm(@Nonnull final Project project)
	{
		myProject = project;

		myConfigureButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(@Nonnull final ActionEvent e)
			{
				/*final ProjectJdksEditor editor = new ProjectJdksEditor((Sdk) mySdkComboBox.getSelectedItem(), myProject, mySdkComboBox);
				editor.show();
				if(editor.isOK())
				{
					setSelectedSdk(editor.getSelectedJdk());
				} */
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

	@Nonnull
	public JComboBox getSdkComboBox()
	{
		return mySdkComboBox;
	}

	@Nonnull
	public String getCmdParams()
	{
		return myCommandLineParamsEditor.getText();
	}

	public void setCmdParams(@Nonnull final String params)
	{
		myCommandLineParamsEditor.setText(params);
	}

	@Nonnull
	public String getWorkingDirectory()
	{
		return myWorkingDirectoryEditor.getText();
	}

	public void setWorkingDirectory(@Nonnull final String dir)
	{
		myWorkingDirectoryEditor.setText(dir);
	}

	@Nullable
	public Sdk getSelectedSdk()
	{
		return (Sdk) mySdkComboBox.getSelectedItem();
	}

	public void setSelectedSdk(@Nullable final Sdk sdk)
	{
		if(sdk == null)
		{
			mySdkComboBox.setSelectedItem(null);
			return;
		}
		final String sdkHome = sdk.getHomePath();
		final int count = mySdkComboBox.getItemCount();
		for(int i = 0; i < count; i++)
		{
			final Sdk item = (Sdk) mySdkComboBox.getItemAt(i);
			if(item != null && sdkHome.equals(item.getHomePath()))
			{
				mySdkComboBox.setSelectedIndex(i);
				return;
			}
		}
	}

	private void createUIComponents()
	{
		ProjectSdksModel model = new ProjectSdksModel();
		model.reset();
		mySdkComboBox = new SdkComboBox(model, Conditions.equalTo(OCamlSdkType.getInstance()), true);
	}
}
