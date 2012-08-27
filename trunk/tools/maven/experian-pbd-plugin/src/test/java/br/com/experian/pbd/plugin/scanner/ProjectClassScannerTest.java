package br.com.experian.pbd.plugin.scanner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import br.com.experian.pbd.plugin.information.ClassInformation;

public class ProjectClassScannerTest {


	private ClassScanner classScanner;


	@Mock
	ClassInformation classInformation;

	@Before
	public void setUp() throws Exception {
		initMocks(this);
	}


	@After
	public void tearDown() throws Exception {
		classScanner  = null;
	}


	@Test
	public void shouldReturnTheAllNameOfClassInOfProject() throws ClassNotFoundException {


		classScanner =
				ProjectClassScanner
					.builder(classInformation)
					.setClassPath(System.getProperty("user.dir") + "\\src\\test\\resources");


		// filter interfaces
		when(classInformation.isInterface("br.com.experian.pbd.plugin.resources.ResourceInterfaceTest1")).thenReturn(true);
		when(classInformation.isInterface("br.com.experian.pbd.plugin.resources.ResourceInterfaceTest2")).thenReturn(true);
		when(classInformation.isInterface("br.com.experian.pbd.plugin.resources.ResourceInterfaceTest3")).thenReturn(true);


		List<String> classInProject = new ArrayList<String>();


		// only class ( filter the interfaces ) in package src/test/resources/br.com.experian.pbd.plugin.resources
		classInProject.add("br.com.experian.pbd.plugin.resources.ResourceClassTest1");
		classInProject.add("br.com.experian.pbd.plugin.resources.ResourceClassTest2");
		classInProject.add("br.com.experian.pbd.plugin.resources.ResourceClassTest3");


		List<String> classNames = classScanner.getClassNames();


		verify(classInformation, times(6)).isInterface(anyString());
		verify(classInformation).setClassPath(anyString());


		assertNotNull(classNames);
		assertTrue(classInProject.equals(classNames));

	}


	@Test
	public void shouldDoNothingAboutClassNotFoundExeption() throws ClassNotFoundException {

		classScanner =
				ProjectClassScanner
					.builder(classInformation)
					.setClassPath(System.getProperty("user.dir") + "\\src\\test\\resources");


		// filter interfaces
		when(classInformation.isInterface("br.com.experian.pbd.plugin.resources.ResourceInterfaceTest1")).thenReturn(true);
		when(classInformation.isInterface("br.com.experian.pbd.plugin.resources.ResourceInterfaceTest2")).thenReturn(true);
		when(classInformation.isInterface("br.com.experian.pbd.plugin.resources.ResourceInterfaceTest3")).thenReturn(true);

		// simulet class not found
		when(classInformation.isInterface("br.com.experian.pbd.plugin.resources.ResourceClassTest1")).thenThrow(new ClassNotFoundException());


		List<String> classInProject = new ArrayList<String>();


		// only class ( filter the interfaces ) in package src/test/resources/br.com.experian.pbd.plugin.resources
		// only 2 class
		classInProject.add("br.com.experian.pbd.plugin.resources.ResourceClassTest2");
		classInProject.add("br.com.experian.pbd.plugin.resources.ResourceClassTest3");


		List<String> classNames = classScanner.getClassNames();


		verify(classInformation, times(6)).isInterface(anyString());
		verify(classInformation).setClassPath(anyString());


		assertNotNull(classNames);
		assertTrue(classInProject.equals(classNames));


	}


	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowsExceptionWhenClassPathIsNull() {

		classScanner =
				ProjectClassScanner
					.builder(classInformation)
					.setClassPath(null);

	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowsExceptionWhenClassInformationIsNull() {

		classScanner =
				ProjectClassScanner
				.builder(null)
				.setClassPath("path");


	}


	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowsExceptionWhenClassPathIsinvalid() {

		classScanner =
				ProjectClassScanner
				.builder(classInformation)
				.setClassPath("invalid path");


		verify(classInformation).setClassPath(anyString());

		classScanner.getClassNames();
	}
}
