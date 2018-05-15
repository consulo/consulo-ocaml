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

package manuylov.maxim.ocaml.lang;

import javax.annotation.Nonnull;
import org.junit.Assert;
import org.junit.Before;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.openapi.application.ex.ApplicationManagerEx;
import manuylov.maxim.ocaml.fileType.OCamlFileTypeLanguage;
import manuylov.maxim.ocaml.fileType.ml.MLFileTypeLanguage;
import manuylov.maxim.ocaml.fileType.ml.parser.MLParserDefinition;
import manuylov.maxim.ocaml.fileType.mli.MLIFileTypeLanguage;

/**
 * @author Maxim.Manuylov
 *         Date: 17.05.2010
 */
public class BaseOCamlTestCase extends Assert
{
	@Before
	public void setUp()
	{
		if(ApplicationManagerEx.getApplication() == null)
		{
			//new ApplicationImpl(true, Ref.create());
			register(MLFileTypeLanguage.INSTANCE);
			register(MLIFileTypeLanguage.INSTANCE);
		}
	}

	private void register(@Nonnull final OCamlFileTypeLanguage language)
	{
		LanguageParserDefinitions.INSTANCE.addExplicitExtension(language, new MLParserDefinition());
		//LanguageASTFactory.INSTANCE.addExplicitExtension(language, ASTFactory.DEFAULT);
	}
}
