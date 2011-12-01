package br.com.mystudies.javasete.projectcoin;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.mystudies.javasete.projectcoin.MultiCatch;
import br.com.mystudies.javasete.projectcoin.exception.ExceptionCheckedOne;
import br.com.mystudies.javasete.projectcoin.exception.ExceptionCheckedTwo;

public class MultiCatchTest {

	
	MultiCatch multiCatch;
	
	@Before
	public void setUp() throws Exception {
		multiCatch = new MultiCatch();
	}

	@After
	public void tearDown() throws Exception {
		multiCatch = null;
	}

	@Test(expected=ExceptionCheckedOne.class)
	public void shouldThrowExceptionWhenObjectNull() throws ExceptionCheckedOne, ExceptionCheckedTwo { 
		multiCatch.execute(null,new Object());
	}
	
	
	@Test(expected=ExceptionCheckedTwo.class)
	public void shouldThrowExceptionWhenObjec2tNull() throws ExceptionCheckedOne, ExceptionCheckedTwo  {
		multiCatch.execute(new Object(),null);
	}

}
