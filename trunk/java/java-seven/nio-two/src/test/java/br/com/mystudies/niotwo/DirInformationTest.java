package br.com.mystudies.niotwo;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DirInformationTest {

	private DirInformation dirInformation;

	@Before
	public void setUp() throws Exception {
		dirInformation = new DirInformation();
	}

	@After
	public void tearDown() throws Exception {
		dirInformation = null;
	}

	@Test
	public void shoudReturnNumerOfDirs() {
		int numberOfDir =
				dirInformation.getNumberOfDirs(Paths.get("src/test/resources/files/"));
		assertEquals(4, numberOfDir);
	}

	@Test
	public void shoudReturnNumberOfFiles() {
		int numberOfDir =
				dirInformation.getNumberOfFiles(Paths.get("src/test/resources/files/"));
		assertEquals(10, numberOfDir);
	}

}
