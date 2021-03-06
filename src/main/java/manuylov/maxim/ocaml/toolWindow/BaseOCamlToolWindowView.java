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

import javax.swing.JPanel;

import javax.annotation.Nonnull;

import com.intellij.openapi.project.Project;
import com.intellij.ui.content.ContentManager;
import consulo.disposer.Disposable;

/**
 * @author Maxim.Manuylov
 *         Date: 04.04.2010
 */
abstract class BaseOCamlToolWindowView extends JPanel implements Disposable
{
	@Nonnull
	private final ContentManager myContentManager;
	@Nonnull
	protected final Project myProject;

	protected BaseOCamlToolWindowView(@Nonnull final Project project, @Nonnull final ContentManager contentManager)
	{
		myContentManager = contentManager;
		myProject = project;
	}

	@Nonnull
	public OCamlToolWindowOpenCloseAction getOCamlToolWindowOpenCloseAction(final boolean openConsole, final boolean closeView)
	{
		return new OCamlToolWindowOpenCloseAction(myProject, myContentManager, openConsole, closeView);
	}

	@Nonnull
	public OCamlToolWindowSettingsAction getOCamlToolWindowSettingsAction()
	{
		return new OCamlToolWindowSettingsAction(myProject, null);
	}

	public void dispose()
	{
	}
}
