package br.com.mystudies.javaseven.projectcoin;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.mystudies.javaseven.projectcoin.TryWithResources;

public class TryWithResourcesTest {

	private TryWithResources tryWithResources; 
	
	@Before
	public void setUp() throws Exception {
		tryWithResources = new TryWithResources();
	}

	@After
	public void tearDown() throws Exception {
		tryWithResources = null;
	}

	@Test
	public void shouldClosedResource() {
		
		FileInputStream fileInputStream = 
				tryWithResources.copy(
							new File(
								ClassLoader.getSystemResource("file.txt").getPath()
							)
						);
		
		try {
			fileInputStream.available(); // should throw IOException because stream will closed.
		} catch (IOException e) {
			assertTrue(true);
		}
	}

}
