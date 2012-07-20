package br.com.mystudies.niotwo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirInformation {

	FileVisitor fileVisitor = new FileVisitor();

    public int getNumberOfDirs(Path path) {
        try {
            walkFileTree(path, fileVisitor);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return fileVisitor.numberOfdir;
    }

	private void walkFileTree(Path path, FileVisitor fileVisitor)
			throws IOException {
		Files.walkFileTree(path, fileVisitor);
	}


	public int getNumberOfFiles(Path path) {
		try {
			walkFileTree(path, fileVisitor);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return fileVisitor.numberOfFiles;
	}

}
