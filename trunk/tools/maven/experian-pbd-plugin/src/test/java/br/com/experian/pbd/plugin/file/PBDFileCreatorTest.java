package br.com.experian.pbd.plugin.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class PBDFileCreatorTest {

	private static String OUTPUT_DIRECTORY =  System.getProperty("user.dir") + "\\src\\test\\resources\\file";


	private FileCreator fileCreator;


	@Before
	public void setUp(){

		fileCreator =
				PBDFileCreator.builder("experian-pbd-plugin", OUTPUT_DIRECTORY);

		new File(OUTPUT_DIRECTORY + "\\experian-pbd-plugin.pbd").delete();
	}



	@Test
	public void shouldCreateFileWithLinesOfClass() throws Exception{

		List<String> namesOfClass = new ArrayList<String>();
		namesOfClass.add("br.com.experian.pbd.plugin.test.Class1");
		namesOfClass.add("br.com.experian.pbd.plugin.test.Class2");
		namesOfClass.add("br.com.experian.pbd.plugin.test.Class3");


		fileCreator.createFile(namesOfClass);


		// test file was really created.
		File file =
				new File(OUTPUT_DIRECTORY + "\\experian-pbd-plugin.pbd");


		LineNumberReader lineNumberReader =
				new LineNumberReader(new FileReader(file));


		String line = null;
		int count = 0;
		while ((line =lineNumberReader.readLine()) != null) {
			assertEquals("TraceAllMethodsOfClass: " +namesOfClass.get(count)+ " BlamePointTracer \"SERASA|experian-pbd-plugin|{classname}|{method}\"", line);
			count ++;
		}

	}



	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenProjecNameisNull() throws Exception{

		fileCreator =
				PBDFileCreator.builder(null, OUTPUT_DIRECTORY);

	}


	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenOutputDirectoryIsNull() throws Exception{

		fileCreator =
				PBDFileCreator.builder("name", null);

	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenOutputDirectoryIsInvalida() throws Exception{

		fileCreator =
				PBDFileCreator.builder("name", "slsls"); // invalid path

		List<String> namesOfClass = new ArrayList<String>();
		namesOfClass.add("br.com.experian.pbd.plugin.test.Class1");
		namesOfClass.add("br.com.experian.pbd.plugin.test.Class2");
		namesOfClass.add("br.com.experian.pbd.plugin.test.Class3");

		fileCreator.createFile(namesOfClass);

	}
}

