package br.com.mystudies.javaseven.projectcoin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResources {

	public FileInputStream copy(File file) {		
		try (FileInputStream fileInputStream = new FileInputStream(file)){
			return fileInputStream;
		} catch (IOException e) {
			return null;
		}
	}
}
