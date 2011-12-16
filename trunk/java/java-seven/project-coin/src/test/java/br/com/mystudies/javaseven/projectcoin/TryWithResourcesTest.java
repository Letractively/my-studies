package br.com.mystudies.javaseven.projectcoin;

import static org.junit.Assert.*;

import java.io.File;

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
		assertTrue(
			tryWithResources.copy(
				new File(
					ClassLoader.getSystemResource("file.txt").getPath()
					)
				)
			);
	}

}
