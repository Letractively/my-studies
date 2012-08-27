package br.com.experian.pbd.plugin.information;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JavassistClassInformationTest {

	private ClassInformation classInformation;



	@Before
	public void setUp() throws Exception {
		classInformation = new JavassistClassInformation();
		classInformation.setClassPath(System.getProperty("user.dir") + "\\src\\test\\resources");
	}

	@After
	public void tearDown() throws Exception {
		classInformation = null;
	}


	@Test
	public void shouldReturnTrueWhenIsInterface() throws ClassNotFoundException {
		assertTrue(classInformation.isInterface("br.com.experian.pbd.plugin.resources.ResourceInterfaceTest1"));
	}


	@Test
	public void shouldReturnFalseWhenIsClass() throws ClassNotFoundException {
		assertFalse(classInformation.isInterface("br.com.experian.pbd.plugin.resources.ResourceClassTest1"));
	}

	@Test(expected=ClassNotFoundException.class)
	public void shouldThrowClassNotFoundException() throws ClassNotFoundException{
		classInformation.isInterface("br.com.experian.pbd.plugin.resources.ResourceClassTest1www"); // class not found
	}


	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenPathIsNull(){
		classInformation.setClassPath(null);
	}


/*	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenPathIsInvalid(){
		classInformation.setClassPath(System.getProperty("user.dir") + "\\src\\testss\\resources"); // path invalid
	}*/


}
