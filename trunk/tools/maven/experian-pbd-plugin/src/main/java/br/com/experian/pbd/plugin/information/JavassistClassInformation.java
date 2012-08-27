package br.com.experian.pbd.plugin.information;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

public class JavassistClassInformation implements ClassInformation {


	private ClassPool classPool ;


	public JavassistClassInformation() {
		classPool = new ClassPool();
	}


	public void setClassPath(String path) {
		if(path == null)
			throw new IllegalArgumentException("path isn't null");
			try {
				classPool.appendClassPath(path);
			} catch (NotFoundException e) {
				throw new IllegalArgumentException("path not found");
			}
	}


	public boolean isInterface(String className) throws ClassNotFoundException {
		try {
			CtClass ctClass = classPool.get(className);
			return ctClass.isInterface();
		} catch (NotFoundException e) {
			throw new ClassNotFoundException( className + " not found");
		}
	}

}
