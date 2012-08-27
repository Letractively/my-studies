package br.com.experian.pbd.plugin.scanner;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.plexus.util.DirectoryScanner;

import br.com.experian.pbd.plugin.information.ClassInformation;

public class ProjectClassScanner extends AbstractClassScanner {

	private DirectoryScanner directoryScanner;


	private ProjectClassScanner(ClassInformation classInformation){
		this.directoryScanner = new DirectoryScanner();
		this.classInformation = classInformation;
	}


	public static ClassScanner builder(ClassInformation classInformation) {
		if(classInformation == null)
			throw new IllegalArgumentException("classInformation can't is null");

		return new ProjectClassScanner(classInformation);
	}


	public ClassScanner setClassPath(String path) {
		if(path == null)
			throw new IllegalArgumentException("path can't is null");
		directoryScanner.setBasedir(path);
		classInformation.setClassPath(path);
		return this;
	}


	public List<String> getClassNames() {

		try {
			directoryScanner.scan();
		} catch (IllegalStateException e) {
			throw new IllegalArgumentException("path is invalid or ins't a directory");
		}

		String[] includedFiles =
				directoryScanner.getIncludedFiles();


		List<String> namesOfClassesInProject = new ArrayList<String>();


		for (String includeFile : includedFiles) {
			if(isClass(includeFile)){
				namesOfClassesInProject.add(getClassName(includeFile));
			}
		}

		return namesOfClassesInProject;
	}
}
