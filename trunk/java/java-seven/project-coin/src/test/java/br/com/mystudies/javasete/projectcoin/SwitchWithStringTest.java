package br.com.mystudies.javasete.projectcoin;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SwitchWithStringTest {

	private SwitchWithString switchWithString;
	
	@Before
	public void setUp() throws Exception {
		switchWithString = new SwitchWithString();
	}

	@After
	public void tearDown() throws Exception {
		switchWithString = null;
	}

	@Test
	public void shouldReturnStringAna() {
		assertEquals("Ana", switchWithString.getString("A"));
		assertEquals("Ana", switchWithString.getString("a"));
	}
	
	
	@Test
	public void shouldReturnStringRobson() {
		assertEquals("Robson", switchWithString.getString("R"));
		assertEquals("Robson", switchWithString.getString("r"));
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenStringNull() {
		switchWithString.getString(null);
	}
	
	
	@Test()
	public void shouldReturnAnotherString() {
		assertEquals("Don't have name with this letter C" , switchWithString.getString("C"));
	}

}
