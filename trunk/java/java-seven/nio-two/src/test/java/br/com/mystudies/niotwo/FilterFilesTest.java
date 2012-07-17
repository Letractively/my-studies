package br.com.mystudies.niotwo;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilterFilesTest {

	private FilesFilter filesFilter;


	@Before
	public void setUp() throws Exception {
		filesFilter = new FilesFilter();
	}

	@After
	public void tearDown() throws Exception {
		filesFilter = null;
	}


	@Test
	public void shouldReturnFileWithExtensionTXT() {

		List<Path> paths =
				filesFilter.getFiles(
						ClassLoader.getSystemResource("files").getPath(),
						FileExtension.TXT
					);

		assertTrue(!paths.isEmpty());

		for (Path path : paths) {
			assertTrue(path.toFile().getName().endsWith(".txt"));
		}



	}

}
