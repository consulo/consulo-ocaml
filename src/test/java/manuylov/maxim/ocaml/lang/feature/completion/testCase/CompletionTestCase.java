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

package manuylov.maxim.ocaml.lang.feature.completion.testCase;

import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.junit.Before;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionSorter;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.completion.PrefixMatcher;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.ParserDefinition;
import com.intellij.mock.MockPsiManager;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.patterns.ElementPattern;
import com.intellij.psi.DummyHolderViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.PsiFileImpl;
import manuylov.maxim.ocaml.fileType.OCamlFileTypeLanguage;
import manuylov.maxim.ocaml.fileType.ml.MLFileTypeLanguage;
import manuylov.maxim.ocaml.lang.BaseOCamlTestCase;
import manuylov.maxim.ocaml.lang.feature.completion.OCamlCompletionContributor;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlElement;
import manuylov.maxim.ocaml.lang.parser.psi.OCamlElementFactory;
import manuylov.maxim.ocaml.lang.parser.util.ParserTestUtil;
import manuylov.maxim.ocaml.util.OCamlStringUtil;

/**
 * @author Maxim.Manuylov
 *         Date: 20.05.2010
 */
public abstract class CompletionTestCase extends BaseOCamlTestCase
{
	@Nonnull
	private static final String COMPLETION_POSITION = "}{";

	@Nonnull
	private static final OCamlFileTypeLanguage ourLanguage = MLFileTypeLanguage.INSTANCE;
	@Nonnull
	private static final CompletionContributor ourContributor = new OCamlCompletionContributor();

	private static int testNumber;

	private String[] myVariants;

	@Before
	public void setUp()
	{
		super.setUp();
		testNumber = 0;
	}

	@Nonnull
	protected abstract CompletionType getCompletionType();

	protected abstract int getInvocationCount();

	protected void setVariants(@Nonnull final String... variants)
	{
		myVariants = variants;
	}

	protected void doTest(final int n, @Nonnull final String text, final boolean shouldContain) throws Exception
	{
		if(n <= testNumber)
		{
			throw new IllegalArgumentException("n = " + n + ", testNumber = " + testNumber);
		}
		testNumber = n;

		final String errorText = "Test " + n;

		int completionPosition = text.indexOf(COMPLETION_POSITION);
		assertTrue(errorText, completionPosition != -1);
		final String actualText = remove(text, completionPosition, COMPLETION_POSITION.length());
		assertEquals(errorText, actualText.indexOf(COMPLETION_POSITION), -1);

		doTest(actualText, completionPosition, shouldContain, errorText);
	}

	@Nonnull
	private String remove(@Nonnull final String text, final int start, final int length)
	{
		return text.substring(0, start) + text.substring(start + length);
	}

	private void doTest(@Nonnull final String text, final int completionPosition, final boolean shouldContain, @Nonnull final String errorText) throws Exception
	{
		final ParserDefinition parserDefinition = LanguageParserDefinitions.INSTANCE.findSingle(ourLanguage);

		final ASTNode originalRoot = ParserTestUtil.buildTree(text, parserDefinition);
		final OCamlElement originalPsiRoot = OCamlElementFactory.INSTANCE.createElement(originalRoot);

		final String dummyText = insert(text, completionPosition, OCamlCompletionContributor.LOWER_CASE_DUMMY_IDENTIFIER);
		final ASTNode dummyRoot = ParserTestUtil.buildTree(dummyText, parserDefinition);
		final OCamlElement dummyPsiRoot = OCamlElementFactory.INSTANCE.createElement(dummyRoot);

		final Set<String> result = new TreeSet<String>();
		ourContributor.fillCompletionVariants(createCompletionParameters(originalPsiRoot, dummyPsiRoot, completionPosition), createResultSet(result));

		for(final String variant : myVariants)
		{
			assertEquals(errorText + "\nvariant: " + variant + "\nshould contain: " + shouldContain + "\nresult: " + result.toString(), result.contains(variant), shouldContain);
		}
	}

	@Nonnull
	private CompletionParameters createCompletionParameters(@Nonnull final OCamlElement originalPsiRoot, @Nonnull final OCamlElement dummyPsiRoot, final int completionPosition)
	{
		//noinspection ConstantConditions
		throw new UnsupportedOperationException("CompletionParameters is package local");
		//return new CompletionParameters(dummyPsiRoot.findElementAt(completionPosition), createFakeFile(originalPsiRoot), getCompletionType(), completionPosition, getInvocationCount());
	}

	@Nonnull
	private CompletionResultSet createResultSet(@Nonnull final Set<String> result)
	{
		return new CompletionResultSet(null, null, ourContributor)
		{
			@Override
			public void addElement(@Nonnull final LookupElement element)
			{
				result.add(element.getLookupString());
			}

			@Nonnull
			@Override
			public CompletionResultSet withPrefixMatcher(@Nonnull final PrefixMatcher matcher)
			{
				return this;
			}

			@Nonnull
			@Override
			public CompletionResultSet withPrefixMatcher(@Nonnull final String prefix)
			{
				return this;
			}

			@Nonnull
			@Override
			public CompletionResultSet withRelevanceSorter(@Nonnull CompletionSorter completionSorter)
			{
				return null;
			}

			@Override
			public void addLookupAdvertisement(@Nonnull String s)
			{

			}

			@Nonnull
			@Override
			public CompletionResultSet caseInsensitive()
			{
				return this;
			}

			@Override
			public void restartCompletionOnPrefixChange(ElementPattern<String> elementPattern)
			{

			}

			@Override
			public void restartCompletionWhenNothingMatches()
			{

			}
		};
	}

	@Nonnull
	public PsiFile createFakeFile(@Nonnull final OCamlElement originalPsiRoot)
	{
		return new PsiFileImpl(new DummyHolderViewProvider(new MockPsiManager(originalPsiRoot.getProject())))
		{
			@Nonnull
			public FileType getFileType()
			{
				//noinspection ConstantConditions
				return null;
			}

			@Override
			public PsiReference findReferenceAt(final int offset)
			{
				return null;
			}

			@Override
			public com.intellij.lang.FileASTNode getNode()
			{
				return (com.intellij.lang.FileASTNode) originalPsiRoot.getNode();
			}

			@Nonnull
			@Override
			public Language getLanguage()
			{
				return ourLanguage;
			}

			@Override
			@Nullable
			public PsiElement getLastChild()
			{
				return originalPsiRoot.getLastChild();
			}

			public void accept(@Nonnull final PsiElementVisitor visitor)
			{
			}
		};
	}

	@Nonnull
	public static String insert(@Nonnull final String text, final int position, @Nonnull final String textToInsert)
	{
		final StringBuilder sb = new StringBuilder(text);
		OCamlStringUtil.insert(sb, position, textToInsert);
		return sb.toString();
	}
}
