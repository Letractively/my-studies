package br.com.experian.pbd.plugin.scanner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;

import br.com.experian.pbd.plugin.information.ClassInformation;

public class DependencyClassScanner extends AbstractClassScanner {


	private String classPath;


	private DependencyClassScanner(ClassInformation classInformation){
		this.classInformation = classInformation;
	}


	public static ClassScanner builder(ClassInformation classInformation) {
		if(classInformation == null)
			throw new IllegalArgumentException("classInformation can't is null");

		return new DependencyClassScanner(classInformation);
	}


	public ClassScanner setClassPath(String path) {
		if(path == null)
			throw new IllegalArgumentException("path can't is null");
		classInformation.setClassPath(path);
		classPath = path;
		return this;
	}


	public List<String> getClassNames() {

		List<String> namesOfClassInDependency = new ArrayList<String>();

		try {

			JarInputStream jarInputStream =
					new JarInputStream(new FileInputStream(classPath));

			ZipEntry zipEntry;

			while (( zipEntry = jarInputStream.getNextEntry()) != null) {
				if(isClass(zipEntry.getName())){
					namesOfClassInDependency.add(getClassName(zipEntry.getName()));
				}
			}

		} catch (IOException e) {
			throw new IllegalArgumentException("path is invalid");
		}

		return namesOfClassInDependency;
	}
}
