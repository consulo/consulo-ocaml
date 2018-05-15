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

package manuylov.maxim.ocaml.util;

import java.io.File;
import java.util.ArrayList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import consulo.compiler.ModuleCompilerPathsManager;
import consulo.roots.impl.ProductionContentFolderTypeProvider;
import manuylov.maxim.ocaml.fileType.OCamlFileType;
import manuylov.maxim.ocaml.fileType.ml.MLFileType;
import manuylov.maxim.ocaml.fileType.mli.MLIFileType;

/**
 * @author Maxim.Manuylov
 *         Date: 07.04.2010
 */
public class OCamlFileUtil
{
	public static boolean isOCamlSourceFile(@Nonnull final FileType fileType)
	{
		return fileType == MLFileType.INSTANCE || fileType == MLIFileType.INSTANCE;
	}

	public static boolean isOCamlSourceFile(@Nonnull final VirtualFile file)
	{
		return isOCamlSourceFile(file.getFileType());
	}

	public static boolean isOCamlFile(@Nonnull final VirtualFile file)
	{
		final String extension = file.getExtension();
		return isOCamlSourceFile(file) || "cmi".equals(extension) || "cmo".equals(extension); //todo create CMI and CMO fileTypes
	}

	@Nonnull
	public static File getCompiledDir(@Nonnull final ProjectFileIndex fileIndex, @Nonnull final VirtualFile sourcesDir)
	{
		final VirtualFile sourceRoot = fileIndex.getSourceRootForFile(sourcesDir);
		assert sourceRoot != null && sourceRoot.isDirectory();
		final String sourceRootPath = sourceRoot.getPath();

		final ArrayList<String> relativeDirs = new ArrayList<String>();
		VirtualFile parent = sourcesDir;
		while(parent != null && !parent.getPath().equals(sourceRootPath))
		{
			relativeDirs.add(0, parent.getName());
			parent = parent.getParent();
		}
		assert parent != null;

		final Module module = fileIndex.getModuleForFile(sourcesDir);
		assert module != null;
		final ModuleCompilerPathsManager compilerModuleExtension = ModuleCompilerPathsManager.getInstance(module);

		final VirtualFile outputRoot = compilerModuleExtension.getCompilerOutput(ProductionContentFolderTypeProvider.getInstance());
		assert outputRoot != null && outputRoot.isDirectory();

		File destDir = new File(outputRoot.getPath());
		for(final String dirName : relativeDirs)
		{
			destDir = new File(destDir, dirName);
		}

		return destDir;
	}

	@Nonnull
	public static String getAnotherFileName(@Nonnull final VirtualFile file)
	{
		final FileType type = file.getFileType();
		assert type instanceof OCamlFileType;
		return getFileName(file.getNameWithoutExtension(), ((OCamlFileType) type).getAnotherFileType());
	}

	@Nonnull
	public static String getFileName(@Nonnull final String nameWithoutExtension, @Nonnull final FileType type)
	{
		return nameWithoutExtension + "." + type.getDefaultExtension();
	}

	@Nullable
	public static VirtualFile getAnotherFile(@Nullable final VirtualFile file)
	{
		if(file == null)
		{
			return null;
		}
		final VirtualFile parent = file.getParent();
		if(parent == null)
		{
			return null;
		}
		return parent.findChild(getAnotherFileName(file));
	}

	public static boolean isImplementationFile(@Nonnull final VirtualFile file)
	{
		return file.getFileType() == MLFileType.INSTANCE;
	}

	public static boolean isImplementationFile(@Nonnull final PsiFile file)
	{
		return file.getFileType() == MLFileType.INSTANCE;
	}

	@Nonnull
	public static String getPathToDisplay(@Nonnull final VirtualFile file)
	{
		return FileUtil.toSystemDependentName(file.getPath());
	}
}
