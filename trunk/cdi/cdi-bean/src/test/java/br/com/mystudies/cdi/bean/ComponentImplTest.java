package br.com.mystudies.cdi.bean;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ComponentImplTest {

	private Component component;
	

	@Before
	public void setUp(){
		component = new ComponentImpl();
	}
	

	@Test
	public void shouldReturnStringUpperCase() {
		String s = component.upperCase("lowercase");
		
		assertEquals("LOWERCASE", s);
	}

	
}
