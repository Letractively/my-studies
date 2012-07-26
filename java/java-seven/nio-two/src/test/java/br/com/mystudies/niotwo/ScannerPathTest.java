package br.com.mystudies.niotwo;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ScannerPathTest {

	private ScannerPath scannerPath;

	@Before
	public void setUp() throws Exception {
		scannerPath = new ScannerPath();
	}

	@After
	public void tearDown() throws Exception {
		scannerPath = null;
	}

	@Test
	public void shouldReturnNewFile() {

		Path path =
				Paths.get("src/test/resources/files/");

		scannerPath.start(path);



		Files.createDirectories(path, )

		Path p = scannerPath.getNewFile();

		assertNotNull(p);

		/*assertEquals("src", p.getFileName());*/

		scannerPath.stop();

	}

}
