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

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.swing.*;
import javax.swing.border.Border;

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
import consulo.disposer.Disposable;
import consulo.util.dataholder.Key;

/**
 * @author Maxim.Manuylov
 *         Date: 26.05.2010
 */
@SuppressWarnings({"ConstantConditions"})
public class MockEditor implements Editor
{
	@Nonnull
	public Document getDocument()
	{
		return new MyMockDocument();
	}

	public boolean isViewer()
	{
		return false;
	}

	@Nonnull
	public JComponent getComponent()
	{
		return null;
	}

	@Nonnull
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

	@Nonnull
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

			@Nonnull
			public int[] getBlockSelectionStarts()
			{
				return new int[0];
			}

			@Nonnull
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

	@Nonnull
	public MarkupModel getMarkupModel()
	{
		return null;
	}

	@Nonnull
	public FoldingModel getFoldingModel()
	{
		return null;
	}

	@Nonnull
	public ScrollingModel getScrollingModel()
	{
		return null;
	}

	@Nonnull
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

			@Nonnull
			@Override
			public Caret getCurrentCaret()
			{
				return null;
			}

			@Nonnull
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

			@Nonnull
			@Override
			public List<Caret> getAllCarets()
			{
				return null;
			}

			@Nullable
			@Override
			public Caret getCaretAt(@Nonnull VisualPosition visualPosition)
			{
				return null;
			}

			@Nullable
			@Override
			public Caret addCaret(@Nonnull VisualPosition visualPosition)
			{
				return null;
			}

			@Nullable
			@Override
			public Caret addCaret(@Nonnull VisualPosition visualPosition, boolean b)
			{
				return null;
			}

			@Override
			public boolean removeCaret(@Nonnull Caret caret)
			{
				return false;
			}

			@Override
			public void removeSecondaryCarets()
			{

			}

			@Override
			public void setCaretsAndSelections(@Nonnull List<? extends CaretState> list)
			{

			}

			@Override
			public void setCaretsAndSelections(@Nonnull List<? extends CaretState> list, boolean b)
			{

			}

			@Nonnull
			@Override
			public List<CaretState> getCaretsAndSelections()
			{
				return null;
			}

			@Override
			public void runForEachCaret(@Nonnull CaretAction caretAction)
			{

			}

			@Override
			public void runForEachCaret(@Nonnull CaretAction caretAction, boolean b)
			{

			}

			@Override
			public void addCaretActionListener(@Nonnull CaretActionListener caretActionListener, @Nonnull Disposable disposable)
			{

			}

			@Override
			public void runBatchCaretOperation(@Nonnull Runnable runnable)
			{

			}
		};
	}

	@Nonnull
	@Override
	public SoftWrapModel getSoftWrapModel()
	{
		return null;
	}

	@Nonnull
	public EditorSettings getSettings()
	{
		return null;
	}

	@Nonnull
	public EditorColorsScheme getColorsScheme()
	{
		return null;
	}

	public int getLineHeight()
	{
		return 0;
	}

	@Nonnull
	public Point logicalPositionToXY(@Nonnull final LogicalPosition pos)
	{
		return null;
	}

	public int logicalPositionToOffset(@Nonnull final LogicalPosition pos)
	{
		return 0;
	}

	@Nonnull
	public VisualPosition logicalToVisualPosition(@Nonnull final LogicalPosition logicalPos)
	{
		return null;
	}

	@Nonnull
	public Point visualPositionToXY(@Nonnull final VisualPosition visible)
	{
		return null;
	}

	@Nonnull
	@Override
	public Point2D visualPositionToPoint2D(@Nonnull VisualPosition visualPosition)
	{
		return null;
	}

	@Nonnull
	public LogicalPosition visualToLogicalPosition(@Nonnull final VisualPosition visiblePos)
	{
		return null;
	}

	@Nonnull
	public LogicalPosition offsetToLogicalPosition(final int offset)
	{
		return null;
	}

	@Nonnull
	public VisualPosition offsetToVisualPosition(final int offset)
	{
		return null;
	}

	@Nonnull
	@Override
	public VisualPosition offsetToVisualPosition(int i, boolean b, boolean b1)
	{
		return null;
	}

	@Nonnull
	public LogicalPosition xyToLogicalPosition(@Nonnull final Point p)
	{
		return null;
	}

	@Nonnull
	public VisualPosition xyToVisualPosition(@Nonnull final Point p)
	{
		return null;
	}

	@Nonnull
	@Override
	public VisualPosition xyToVisualPosition(@Nonnull Point2D point2D)
	{
		return null;
	}

	public void addEditorMouseListener(@Nonnull final EditorMouseListener listener)
	{

	}

	public void removeEditorMouseListener(@Nonnull final EditorMouseListener listener)
	{

	}

	public void addEditorMouseMotionListener(@Nonnull final EditorMouseMotionListener listener)
	{

	}

	public void removeEditorMouseMotionListener(@Nonnull final EditorMouseMotionListener listener)
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

	@Nonnull
	public EditorGutter getGutter()
	{
		return null;
	}

	public EditorMouseEventArea getMouseEventArea(@Nonnull final MouseEvent e)
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

	@Nonnull
	@Override
	public InlayModel getInlayModel()
	{
		return null;
	}

	@Nonnull
	@Override
	public EditorKind getEditorKind()
	{
		return null;
	}

	public <T> T getUserData(@Nonnull final Key<T> key)
	{
		return null;
	}

	public <T> void putUserData(@Nonnull final Key<T> key, @Nullable final T value)
	{

	}
}
