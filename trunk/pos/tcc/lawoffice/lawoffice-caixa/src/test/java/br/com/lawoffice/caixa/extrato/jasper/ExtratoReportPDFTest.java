package br.com.lawoffice.caixa.extrato.jasper;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lawoffice.caixa.extrato.ExtratoDTO;

/**
 * 
 * Teste de unidade para {@link ExtratoReportJasperPDF}.
 * 
 * @author rduarte
 *
 */
public class ExtratoReportPDFTest {

	
	private ExtratoReportJasperPDF extratoReportPDF;
	
	@Before
	public void setUp() throws Exception {
		extratoReportPDF = new ExtratoReportJasperPDF();
	}

	@After
	public void tearDown() throws Exception {
		extratoReportPDF = null;
	}

	@Test(expected=IllegalArgumentException.class)
	public void deveDisparaUmaExcecaoQuandoExtratoDTONulo() {
		extratoReportPDF.gerarExtrato(null);
	}
	
	
	
/*	<parameter name="NOME_CLIENTE" class="java.lang.String"/>*/
	
	
	@Test()
	public void deveRetornaUmMapComParmentros() {
		
		Map<String, String> parametros = 
				extratoReportPDF.getMapParametros(
					new ExtratoDTO(
						"Robson", 
							new BigDecimal(111222.22), 
							new BigDecimal(222300.22), 
							new Date(), 
							new Date()
						)
				);
		
		
		assertNotNull(parametros);
		assertEquals("R$ 111.222,22", parametros.get("SALDO_ANTERIOR"));
		assertEquals("R$ 222.300,22", parametros.get("SALDO_ATUAL"));		
		assertEquals(DateFormatUtils.format(new Date(), "dd/MM/yyy"), parametros.get("DATA_INICIAL"));
		assertEquals(DateFormatUtils.format(new Date(), "dd/MM/yyy"), parametros.get("DATA_FINAL"));
		assertEquals("Robson", 	parametros.get("NOME_PESSOA"));
		
	}
	
	
	
	
	@Test()
	public void deveRetornaByteArray() {
		byte[] extrato = 
				extratoReportPDF.gerarExtrato(
					new ExtratoDTO(
							"Robson", 
								new BigDecimal(111222.22), 
								new BigDecimal(222300.22), 
								new Date(), 
								new Date()
							)
					);
		
		assertNotNull(extrato);
	}

}
