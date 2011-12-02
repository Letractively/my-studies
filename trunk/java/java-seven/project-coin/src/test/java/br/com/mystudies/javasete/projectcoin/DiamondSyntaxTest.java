package br.com.mystudies.javasete.projectcoin;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiamondSyntaxTest {

	DiamondSyntax diamondSyntax;
	
	@Before
	public void setUp() throws Exception {
		diamondSyntax = new DiamondSyntax();
	}

	@After
	public void tearDown() throws Exception {
		diamondSyntax = null;
	}

	@Test
	public void shouldReturnListOfString() {
		List<String> list = diamondSyntax.getList();
		assertNotNull(list);
	}

}
