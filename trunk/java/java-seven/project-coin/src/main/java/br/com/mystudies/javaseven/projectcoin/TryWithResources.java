package br.com.mystudies.javaseven.projectcoin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TryWithResources {

	public boolean copy(File file) {
		
		try {
			
			
			
			FileInputStream fileInputStream = new FileInputStream(file);
			
			/*if(fileInputStream.)
			*/
			
			/*
			
			return fileInputStream.close()*/ 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
