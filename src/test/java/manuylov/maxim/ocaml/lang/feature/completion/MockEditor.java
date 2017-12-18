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

package manuylov.maxim.ocaml.lang.feature.completion;

import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.border.Border;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.event.CaretListener;
import com.intellij.openapi.editor.event.EditorMouseEventArea;
import com.intellij.openapi.editor.event.EditorMouseListener;
import com.intellij.openapi.editor.event.EditorMouseMotionListener;
import com.intellij.openapi.editor.event.SelectionListener;
import com.intellij.openapi.editor.markup.MarkupModel;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;

/**
 * @author Maxim.Manuylov
 *         Date: 26.05.2010
 */
@SuppressWarnings({"ConstantConditions"})
public class MockEditor implements Editor
{
	@NotNull
	public Document getDocument()
	{
		return new MyMockDocument();
	}

	public boolean isViewer()
	{
		return false;
	}

	@NotNull
	public JComponent getComponent()
	{
		return null;
	}

	@NotNull
	public JComponent getContentComponent()
	{
		return null;
	}

	@Override
	public void setBorder(@Nullable Border border)
	{
		
	}

	@Override
	public Insets getInsets()
	{
		return null;
	}

	@NotNull
	public SelectionModel getSelectionModel()
	{
		return new SelectionModel()
		{
			public int getSelectionStart()
			{
				return 0;
			}

			@Nullable
			@Override
			public VisualPosition getSelectionStartPosition()
			{
				return null;
			}

			public int getSelectionEnd()
			{
				return 0;
			}

			@Nullable
			@Override
			public VisualPosition getSelectionEndPosition()
			{
				return null;
			}

			public String getSelectedText()
			{
				return null;
			}

			@Nullable
			@Override
			public String getSelectedText(boolean b)
			{
				return null;
			}

			public int getLeadSelectionOffset()
			{
				return 0;
			}

			@Nullable
			@Override
			public VisualPosition getLeadSelectionPosition()
			{
				return null;
			}

			public boolean hasSelection()
			{
				return false;
			}

			@Override
			public boolean hasSelection(boolean b)
			{
				return false;
			}

			public void setSelection(final int startOffset, final int endOffset)
			{
			}

			@Override
			public void setSelection(int i, @Nullable VisualPosition visualPosition, int i1)
			{

			}

			@Override
			public void setSelection(@Nullable VisualPosition visualPosition, int i, @Nullable VisualPosition visualPosition1, int i1)
			{

			}

			public void removeSelection()
			{
			}

			@Override
			public void removeSelection(boolean b)
			{

			}

			public void addSelectionListener(final SelectionListener listener)
			{
			}

			public void removeSelectionListener(final SelectionListener listener)
			{
			}

			public void selectLineAtCaret()
			{
			}

			public void selectWordAtCaret(final boolean honorCamelWordsSettings)
			{
			}

			public void copySelectionToClipboard()
			{
			}

			public void setBlockSelection(final LogicalPosition blockStart, final LogicalPosition blockEnd)
			{
			}

			public void removeBlockSelection()
			{
			}

			public boolean hasBlockSelection()
			{
				return false;
			}

			@NotNull
			public int[] getBlockSelectionStarts()
			{
				return new int[0];
			}

			@NotNull
			public int[] getBlockSelectionEnds()
			{
				return new int[0];
			}

			public LogicalPosition getBlockStart()
			{
				return null;
			}

			public LogicalPosition getBlockEnd()
			{
				return null;
			}

			public boolean isBlockSelectionGuarded()
			{
				return false;
			}

			public RangeMarker getBlockSelectionGuard()
			{
				return null;
			}

			public TextAttributes getTextAttributes()
			{
				return null;
			}
		};
	}

	@NotNull
	public MarkupModel getMarkupModel()
	{
		return null;
	}

	@NotNull
	public FoldingModel getFoldingModel()
	{
		return null;
	}

	@NotNull
	public ScrollingModel getScrollingModel()
	{
		return null;
	}

	@NotNull
	public CaretModel getCaretModel()
	{
		return new CaretModel()
		{
			public void moveCaretRelatively(final int columnShift, final int lineShift, final boolean withSelection, final boolean blockSelection, final boolean scrollToCaret)
			{
			}

			public void moveToLogicalPosition(final LogicalPosition pos)
			{
			}

			public void moveToVisualPosition(final VisualPosition pos)
			{
			}

			public void moveToOffset(final int offset)
			{
			}

			@Override
			public void moveToOffset(int i, boolean b)
			{

			}

			@Override
			public boolean isUpToDate()
			{
				return false;
			}

			public LogicalPosition getLogicalPosition()
			{
				return null;
			}

			public VisualPosition getVisualPosition()
			{
				return null;
			}

			public int getOffset()
			{
				return 0;
			}

			public void addCaretListener(final CaretListener listener)
			{
			}

			public void removeCaretListener(final CaretListener listener)
			{
			}

			public int getVisualLineStart()
			{
				return 0;
			}

			public int getVisualLineEnd()
			{
				return 0;
			}

			public TextAttributes getTextAttributes()
			{
				return null;
			}

			@Override
			public boolean supportsMultipleCarets()
			{
				return false;
			}

			@NotNull
			@Override
			public Caret getCurrentCaret()
			{
				return null;
			}

			@NotNull
			@Override
			public Caret getPrimaryCaret()
			{
				return null;
			}

			@Override
			public int getCaretCount()
			{
				return 0;
			}

			@NotNull
			@Override
			public List<Caret> getAllCarets()
			{
				return null;
			}

			@Nullable
			@Override
			public Caret getCaretAt(@NotNull VisualPosition visualPosition)
			{
				return null;
			}

			@Nullable
			@Override
			public Caret addCaret(@NotNull VisualPosition visualPosition)
			{
				return null;
			}

			@Nullable
			@Override
			public Caret addCaret(@NotNull VisualPosition visualPosition, boolean b)
			{
				return null;
			}

			@Override
			public boolean removeCaret(@NotNull Caret caret)
			{
				return false;
			}

			@Override
			public void removeSecondaryCarets()
			{

			}

			@Override
			public void setCaretsAndSelections(@NotNull List<CaretState> list)
			{

			}

			@Override
			public void setCaretsAndSelections(@NotNull List<CaretState> list, boolean b)
			{

			}

			@NotNull
			@Override
			public List<CaretState> getCaretsAndSelections()
			{
				return null;
			}

			@Override
			public void runForEachCaret(@NotNull CaretAction caretAction)
			{

			}

			@Override
			public void runForEachCaret(@NotNull CaretAction caretAction, boolean b)
			{

			}

			@Override
			public void runBatchCaretOperation(@NotNull Runnable runnable)
			{

			}
		};
	}

	@NotNull
	@Override
	public SoftWrapModel getSoftWrapModel()
	{
		return null;
	}

	@NotNull
	public EditorSettings getSettings()
	{
		return null;
	}

	@NotNull
	public EditorColorsScheme getColorsScheme()
	{
		return null;
	}

	public int getLineHeight()
	{
		return 0;
	}

	@NotNull
	public Point logicalPositionToXY(@NotNull final LogicalPosition pos)
	{
		return null;
	}

	public int logicalPositionToOffset(@NotNull final LogicalPosition pos)
	{
		return 0;
	}

	@NotNull
	public VisualPosition logicalToVisualPosition(@NotNull final LogicalPosition logicalPos)
	{
		return null;
	}

	@NotNull
	public Point visualPositionToXY(@NotNull final VisualPosition visible)
	{
		return null;
	}

	@NotNull
	@Override
	public Point2D visualPositionToPoint2D(@NotNull VisualPosition visualPosition)
	{
		return null;
	}

	@NotNull
	public LogicalPosition visualToLogicalPosition(@NotNull final VisualPosition visiblePos)
	{
		return null;
	}

	@NotNull
	public LogicalPosition offsetToLogicalPosition(final int offset)
	{
		return null;
	}

	@NotNull
	public VisualPosition offsetToVisualPosition(final int offset)
	{
		return null;
	}

	@NotNull
	@Override
	public VisualPosition offsetToVisualPosition(int i, boolean b, boolean b1)
	{
		return null;
	}

	@NotNull
	public LogicalPosition xyToLogicalPosition(@NotNull final Point p)
	{
		return null;
	}

	@NotNull
	public VisualPosition xyToVisualPosition(@NotNull final Point p)
	{
		return null;
	}

	@NotNull
	@Override
	public VisualPosition xyToVisualPosition(@NotNull Point2D point2D)
	{
		return null;
	}

	public void addEditorMouseListener(@NotNull final EditorMouseListener listener)
	{

	}

	public void removeEditorMouseListener(@NotNull final EditorMouseListener listener)
	{

	}

	public void addEditorMouseMotionListener(@NotNull final EditorMouseMotionListener listener)
	{

	}

	public void removeEditorMouseMotionListener(@NotNull final EditorMouseMotionListener listener)
	{

	}

	public boolean isDisposed()
	{
		return false;
	}

	public Project getProject()
	{
		return null;
	}

	public boolean isInsertMode()
	{
		return false;
	}

	public boolean isColumnMode()
	{
		return false;
	}

	public boolean isOneLineMode()
	{
		return false;
	}

	@NotNull
	public EditorGutter getGutter()
	{
		return null;
	}

	public EditorMouseEventArea getMouseEventArea(@NotNull final MouseEvent e)
	{
		return null;
	}

	public void setHeaderComponent(@Nullable final JComponent header)
	{

	}

	public boolean hasHeaderComponent()
	{
		return false;
	}

	public JComponent getHeaderComponent()
	{
		return null;
	}

	public IndentsModel getIndentsModel()
	{
		return null;
	}

	@NotNull
	@Override
	public InlayModel getInlayModel()
	{
		return null;
	}

	public <T> T getUserData(@NotNull final Key<T> key)
	{
		return null;
	}

	public <T> void putUserData(@NotNull final Key<T> key, @Nullable final T value)
	{

	}
}
