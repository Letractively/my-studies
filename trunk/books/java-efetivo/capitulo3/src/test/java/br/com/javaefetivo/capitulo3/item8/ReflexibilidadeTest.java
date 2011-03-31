package br.com.javaefetivo.capitulo3.item8;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReflexibilidadeTest{

	@Test
	public void testEqualsObject() {
		Reflexibilidade reflexibilidade = new Reflexibilidade();
		assertTrue(reflexibilidade.equals(reflexibilidade));
	}

}
