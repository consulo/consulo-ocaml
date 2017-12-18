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

import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.project.Project;
import com.intellij.ui.content.ContentManager;

/**
 * @author Maxim.Manuylov
 *         Date: 04.04.2010
 */
abstract class BaseOCamlToolWindowView extends JPanel implements Disposable
{
	@NotNull
	private final ContentManager myContentManager;
	@NotNull
	protected final Project myProject;

	protected BaseOCamlToolWindowView(@NotNull final Project project, @NotNull final ContentManager contentManager)
	{
		myContentManager = contentManager;
		myProject = project;
	}

	@NotNull
	public OCamlToolWindowOpenCloseAction getOCamlToolWindowOpenCloseAction(final boolean openConsole, final boolean closeView)
	{
		return new OCamlToolWindowOpenCloseAction(myProject, myContentManager, openConsole, closeView);
	}

	@NotNull
	public OCamlToolWindowSettingsAction getOCamlToolWindowSettingsAction()
	{
		return new OCamlToolWindowSettingsAction(myProject, null);
	}

	public void dispose()
	{
	}
}
