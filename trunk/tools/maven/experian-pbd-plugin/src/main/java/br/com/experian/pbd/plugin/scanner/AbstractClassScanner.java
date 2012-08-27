package br.com.experian.pbd.plugin.scanner;

import br.com.experian.pbd.plugin.information.ClassInformation;


public abstract class AbstractClassScanner implements ClassScanner {


	protected ClassInformation classInformation;


	protected boolean isClass(String includeFile){

		if(!isClassFile(includeFile)){
			return false;
		}

		try {
			return !classInformation.isInterface(getClassName(includeFile));
		} catch (ClassNotFoundException e) {
			return false ;
		}

	}

	protected boolean isClassFile(String includeFile) {
		return includeFile.endsWith(".class");
	}


	protected String getClassName(String includeFile) {
		return includeFile.replace("\\", ".").replace("/", ".").replace(".class","");
	}
}
