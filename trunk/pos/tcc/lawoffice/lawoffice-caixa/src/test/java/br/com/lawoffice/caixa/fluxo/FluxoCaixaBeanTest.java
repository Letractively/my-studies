package br.com.lawoffice.caixa.fluxo;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FluxoCaixaBeanTest {

	private FluxoCaixaBean fluxoBeanTest;
	
	@Before
	public void setUp() throws Exception {
		fluxoBeanTest = new FluxoCaixaBean();
	}

	@After
	public void tearDown() throws Exception {
		fluxoBeanTest = null;
	}

	@Test(expected=IllegalArgumentException.class)
	public void deveLancarExcecaoQuandoDataInicialNula(){
		fluxoBeanTest.consultarFluxoDeCaixa(null, new Date(), 1L);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveLancarExcecaoQuandoDataFinalNula(){
		fluxoBeanTest.consultarFluxoDeCaixa(new Date(), null, 1L);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveLancarExcecaoQuandoNumeroContaNula(){
		fluxoBeanTest.consultarFluxoDeCaixa(new Date(), new Date(), null);
	}	

}
