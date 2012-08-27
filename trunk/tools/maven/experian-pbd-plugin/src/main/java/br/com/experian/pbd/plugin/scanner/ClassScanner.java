package br.com.experian.pbd.plugin.scanner;

import java.util.List;

public interface ClassScanner {

	List<String> getClassNames();

	ClassScanner setClassPath(String path);

}
