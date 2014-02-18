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

package manuylov.maxim.ocaml.lang.feature.refactoring.surround.surrounder;

import org.jetbrains.annotations.NotNull;

/**
 * @author Maxim.Manuylov
 *         Date: 08.05.2010
 */
public class OCamlWithLetExpressionSurrounder extends BaseOCamlSurrounderWithNavigation {
    private static final String START = "let ";

    public OCamlWithLetExpressionSurrounder() {
        super("let / in");
    }

    @NotNull
    @Override
    protected String doSurround(@NotNull final CharSequence text) {
        return START + " =  in (" + text + ")";
    }

    @Override
    protected int getOffset(@NotNull final String surroundedText) {
        return START.length();
    }
}