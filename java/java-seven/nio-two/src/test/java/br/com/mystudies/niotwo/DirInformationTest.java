package br.com.mystudies.niotwo;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DirInformationTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shoudeReturnNumerOfDirs() {
		int numberOfDir = dirInformation.getNumberOfDirs(Paths.get(""));
		assertEquals(4, numberOfDir);
	}

}
