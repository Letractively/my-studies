package br.com.experian.pbd.plugin.information;

public interface ClassInformation {

	void setClassPath(String path);

	boolean isInterface(String className)throws ClassNotFoundException;

}
