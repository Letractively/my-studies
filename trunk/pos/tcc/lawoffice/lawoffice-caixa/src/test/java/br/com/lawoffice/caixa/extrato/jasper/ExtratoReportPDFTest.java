package br.com.lawoffice.caixa.extrato.jasper;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

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
	
	
	
	@Test()
	public void deveRetornaUmMapComParmentros() {
		
		Map<String, String> parametros = 
				extratoReportPDF.getMapParametros(
					new ExtratoDTO(
						"Robson", 
							new BigDecimal(222.22), 
							new BigDecimal(300.22), 
							new Date(), 
							new Date()
						)
				);
		
		
		assertNotNull(parametros);
	}
	
	
	@Test()
	public void deveRetornaByteArray() {
		byte[] extrato = 
				extratoReportPDF.gerarExtrato(
						new ExtratoDTO(
								null, 
								null, 
								null, 
								null, 
								null
							)
					);
		
		assertNotNull(extrato);
	}

}
