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

package manuylov.maxim.ocaml.actions;

import java.io.File;
import java.io.IOException;

import com.intellij.ide.IdeView;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import manuylov.maxim.ocaml.util.OCamlFileUtil;
import manuylov.maxim.ocaml.util.OCamlModuleUtil;

/**
 * @author Maxim.Manuylov
 *         Date: 13.04.2010
 */
public class SwitchModuleFileAction extends AnAction
{
	public void actionPerformed(final AnActionEvent e)
	{
		final Project project = e.getProject();
		if(project == null)
		{
			return;
		}

		final IdeView view = e.getData(LangDataKeys.IDE_VIEW);
		if(view == null)
		{
			return;
		}

		final VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
		if(file == null)
		{
			return;
		}

		final VirtualFile parent = file.getParent();
		if(parent == null)
		{
			return;
		}

		final File anotherFile = new File(parent.getPath(), OCamlFileUtil.getAnotherFileName(file));
		VirtualFile anotherVirtualFile = LocalFileSystem.getInstance().findFileByIoFile(anotherFile);

		if(anotherVirtualFile == null)
		{
			final String anotherFilePath = FileUtil.toSystemDependentName(anotherFile.getAbsolutePath());
			final Module module = ModuleUtil.findModuleForFile(file, project);
			if(OCamlModuleUtil.hasOCamlExtension(module) && ModuleRootManager.getInstance(module).getFileIndex().isInSourceContent(file))
			{
				if(Messages.showYesNoCancelDialog(project, "File \"" + anotherFilePath + "\" does not exist. Do you want to create it?",
						"Open file \"" + anotherFilePath + "\"", Messages.getQuestionIcon()) != 0)
				{
					return;
				}
				ApplicationManager.getApplication().runWriteAction(new Runnable()
				{
					public void run()
					{
						try
						{
							parent.createChildData(SwitchModuleFileAction.this, anotherFile.getName());
						}
						catch(final IOException e)
						{
							Messages.showErrorDialog(project, e.getMessage(), "Error");
						}
					}
				});
				anotherVirtualFile = LocalFileSystem.getInstance().findFileByIoFile(anotherFile);
				if(anotherVirtualFile == null)
				{
					return;
				}
			}
			else
			{
				Messages.showErrorDialog(project, "File \"" + anotherFilePath + "\" does not exist.", "Open file \"" + anotherFilePath + "\"");
				return;
			}
		}

		final PsiFile anotherPsiFile = PsiManager.getInstance(project).findFile(anotherVirtualFile);
		if(anotherPsiFile == null)
		{
			return;
		}

		view.selectElement(anotherPsiFile);
	}
}
