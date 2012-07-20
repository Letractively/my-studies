package br.com.mystudies.niotwo;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

class FileVisitor implements java.nio.file.FileVisitor<Path> {

	int numberOfdir = -1;
	int numberOfFiles;

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
			throws IOException {
		if(!dir.toString().contains(".svn")){ // ignore svn dirs.
			numberOfdir++;
		}

		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {

		if(!file.toString().contains(".svn")){ // ignore svn dirs.
			numberOfFiles++;
		}

		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {

		return FileVisitResult.TERMINATE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
			throws IOException {
		return FileVisitResult.CONTINUE;
	}

}
