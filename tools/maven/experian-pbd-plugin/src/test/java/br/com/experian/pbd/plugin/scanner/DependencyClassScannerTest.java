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

public class DependencyClassScannerTest {



	private ClassScanner classScanner;


	@Mock
	private ClassInformation classInformation;


	@Before
	public void setUp() throws Exception {

		initMocks(this);

		classScanner =
				DependencyClassScanner
					.builder(classInformation)
					.setClassPath(System.getProperty("user.dir") + "\\src\\test\\resources\\dependency\\dependency-1.0.0.jar");
	}

	@After
	public void tearDown() throws Exception {
		classScanner = null;
	}



	@Test
	public void shouldReturnListWithNamesOfClassInDependency() throws ClassNotFoundException {


		// filter the interfaces
		when(classInformation.isInterface("br.com.experian.dependency.InterfaceDependency1")).thenReturn(true);
		when(classInformation.isInterface("br.com.experian.dependency.InterfaceDependency2")).thenReturn(true);
		when(classInformation.isInterface("br.com.experian.dependency.InterfaceDependency3")).thenReturn(true);


		List<String> classNamesInDependency = new ArrayList<String>();

		// only class in .jar
		classNamesInDependency.add("br.com.experian.dependency.ClassDependency1");
		classNamesInDependency.add("br.com.experian.dependency.ClassDependency2");
		classNamesInDependency.add("br.com.experian.dependency.ClassDependency3");


		 List<String> classNames =
				 classScanner.getClassNames();


		 verify(classInformation, times(6)).isInterface(anyString());
		 verify(classInformation).setClassPath(anyString());


		 assertNotNull(classNames);
		 assertTrue(classNames.equals(classNamesInDependency));

	}

	@Test
	public void shouldDoNothingAboutClassNotFoundExeption() throws ClassNotFoundException {


		// filter interfaces.
		when(classInformation.isInterface("br.com.experian.dependency.InterfaceDependency1")).thenReturn(true);
		when(classInformation.isInterface("br.com.experian.dependency.InterfaceDependency2")).thenReturn(true);
		when(classInformation.isInterface("br.com.experian.dependency.InterfaceDependency3")).thenReturn(true);


		List<String> classNamesInDependency = new ArrayList<String>();

		when(classInformation.isInterface("br.com.experian.dependency.ClassDependency1")).thenThrow(new ClassNotFoundException());


		classNamesInDependency.add("br.com.experian.dependency.ClassDependency2");
		classNamesInDependency.add("br.com.experian.dependency.ClassDependency3");


		List<String> classNames =
				classScanner.getClassNames();


		verify(classInformation, times(6)).isInterface(anyString());
		verify(classInformation).setClassPath(anyString());


		assertNotNull(classNames);
		assertTrue(classNames.equals(classNamesInDependency));

	}



	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowsExceptionWhenClassPathIsNull() {

		classScanner =
				DependencyClassScanner
					.builder(classInformation)
					.setClassPath(null);

	}


	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowsExceptionWhenClassInformationIsNull() {

		classScanner =
				DependencyClassScanner
					.builder(null)
					.setClassPath("path");

	}



	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowsExceptionWhenClassPathIsinvalid() {

		classScanner =
				DependencyClassScanner
					.builder(classInformation)
					.setClassPath("invalid path");


		classScanner.getClassNames();
	}

}
