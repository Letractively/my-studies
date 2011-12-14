package br.com.mystudies.javasete.projectcoin;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		assertTrue(tryWithResources.copy(new File("file.txt")));
	}

}
