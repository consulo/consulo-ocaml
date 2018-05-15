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

import static org.junit.Assert.assertEquals;

import javax.annotation.Nonnull;
import org.junit.Test;
import com.intellij.codeInsight.completion.CompletionInitializationContext;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.completion.FileCopyPatcher;
import com.intellij.codeInsight.completion.OffsetMap;
import com.intellij.mock.MockDocument;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import manuylov.maxim.ocaml.lang.feature.completion.testCase.CompletionTestCase;
import manuylov.maxim.ocaml.lang.parser.ast.element.OCamlElementTypes;
import manuylov.maxim.ocaml.lang.parser.psi.MockASTNode;
import manuylov.maxim.ocaml.lang.parser.psi.element.impl.OCamlUnknownElementImpl;

/**
 * @author Maxim.Manuylov
 *         Date: 20.05.2010
 */
public class CaseSensitivityCompletionTest extends CompletionTestCase
{
	@Test
	public void testUpperCase() throws Exception
	{
		setVariants("One", "Two");

		doTest(1, "" + "type t = One | Two;; " + "let a = }{", true);
		doTest(2, "" + "let a = }{", false);
	}

	@Test
	public void testLowerCase() throws Exception
	{
		Editor dummyEditor = createDummyEditor();
		new OCamlCompletionContributor().beforeCompletion(new CompletionInitializationContext(dummyEditor, dummyEditor.getCaretModel().getCurrentCaret(), createFakeFile(), CompletionType.BASIC, 0)
		{
			public void setFileCopyPatcher(@Nonnull final FileCopyPatcher fileCopyPatcher)
			{
				final MockDocument document = new MyMockDocument()
				{
					@Override
					public void replaceString(final int startOffset, final int endOffset, @Nonnull final CharSequence s)
					{
						assertEquals(OCamlCompletionContributor.LOWER_CASE_DUMMY_IDENTIFIER, s);
					}
				};
				final OffsetMap offsetMap = new OffsetMap(document);
				offsetMap.addOffset(CompletionInitializationContext.START_OFFSET, 0);
				offsetMap.addOffset(CompletionInitializationContext.SELECTION_END_OFFSET, 0);
				fileCopyPatcher.patchFileCopy(createFakeFile(), document, offsetMap);
			}
		});
	}

	private Editor createDummyEditor()
	{
		return new MockEditor();
	}

	private PsiFile createFakeFile()
	{
		return createFakeFile(new OCamlUnknownElementImpl(new MockASTNode(OCamlElementTypes.ML_FILE)));
	}

	@Nonnull
	@Override
	protected CompletionType getCompletionType()
	{
		return CompletionType.BASIC;
	}

	@Override
	protected int getInvocationCount()
	{
		return 1;
	}
}