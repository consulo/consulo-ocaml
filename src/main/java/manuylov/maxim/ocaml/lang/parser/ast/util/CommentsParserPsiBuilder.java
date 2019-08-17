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

package manuylov.maxim.ocaml.lang.parser.ast.util;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.impl.PsiBuilderAdapter;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import manuylov.maxim.ocaml.lang.Strings;
import manuylov.maxim.ocaml.lang.lexer.token.OCamlTokenTypes;
import manuylov.maxim.ocaml.lang.parser.ast.element.OCamlElementTypes;

import javax.annotation.Nonnull;
import java.util.Stack;

/**
 * @author Maxim.Manuylov
 *         Date: 13.06.2009
 */
public class CommentsParserPsiBuilder extends PsiBuilderAdapter
{
	public CommentsParserPsiBuilder(@Nonnull final PsiBuilder builder)
	{
		super(builder);
		builder.enforceCommentTokens(TokenSet.create());
	}

	public void advanceLexer()
	{
		tryParseComments();
		super.advanceLexer();
	}

	public IElementType getTokenType()
	{
		tryParseComments();
		return super.getTokenType();
	}

	public String getTokenText()
	{
		tryParseComments();
		return super.getTokenText();
	}

	public int getCurrentOffset()
	{
		tryParseComments();
		return super.getCurrentOffset();
	}

	public Marker mark()
	{
		return super.mark();
	}

	public void error(final String messageText)
	{
		tryParseComments();
		super.error(messageText);
	}

	public boolean eof()
	{
		tryParseComments();
		return super.eof();
	}

	private void tryParseComments()
	{
		while(super.getTokenType() == OCamlTokenTypes.COMMENT_BEGIN)
		{
			parseComment();
		}
	}

	private void parseComment()
	{
		final Stack<Marker> markers = new Stack<>();

		do
		{
			if(super.getTokenType() == null)
			{
				while(markers.size() > 0)
				{
					markers.pop().done(OCamlElementTypes.UNCLOSED_COMMENT);
				}
				super.error(Strings.UNCLOSED_COMMENT);
			}
			else if(super.getTokenType() == OCamlTokenTypes.COMMENT_BEGIN)
			{
				markers.push(super.mark());
				super.advanceLexer();
			}
			else if(super.getTokenType() == OCamlTokenTypes.COMMENT_END)
			{
				super.advanceLexer();
				markers.pop().done(OCamlElementTypes.COMMENT_BLOCK);
			}
			else if(super.getTokenType() == OCamlTokenTypes.COMMENT)
			{
				super.advanceLexer();
			}
		}
		while(markers.size() > 0);
	}
}
