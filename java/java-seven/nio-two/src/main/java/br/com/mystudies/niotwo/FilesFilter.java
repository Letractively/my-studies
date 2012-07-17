package br.com.mystudies.niotwo;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FilesFilter {

	public List<Path> getFiles(String path, FileExtension fileExtension) {

		FileSystem fileSystem = FileSystems.getDefault();

		List<Path> files = new ArrayList<>() ;

		try(DirectoryStream<Path> directoryStream =
				Files.newDirectoryStream( fileSystem.getPath(path), "*" + fileExtension.getExtension())) {

			for (Path file : directoryStream) {
				files.add(file);
			}

		} catch (IOException exception) {
			return null;
		}

		return files;

	}

}
