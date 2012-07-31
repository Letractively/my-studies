package br.com.mystudies.niotwo;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
	public void shouldReturnNewFile() throws IOException, InterruptedException {

		if(Files.exists(Paths.get("src/test/resources/scanner/dir1"))){

			Files.delete(Paths.get("src/test/resources/scanner/dir1"));
			Files.delete(Paths.get("src/test/resources/scanner/dir2"));
			Files.delete(Paths.get("src/test/resources/scanner/dir3"));
		}


		Path path =
				Paths.get("src/test/resources/scanner/");


		scannerPath.scan(path);

		Files.createDirectory(Paths.get("src/test/resources/scanner/dir1"));
		Files.createDirectory(Paths.get("src/test/resources/scanner/dir2"));
		Files.createDirectory(Paths.get("src/test/resources/scanner/dir3"));


		List<Path> paths = scannerPath.getNewFiles();

		assertNotNull(paths);
		assertEquals(3, paths.size());


		scannerPath.stopScan();

	}

}
