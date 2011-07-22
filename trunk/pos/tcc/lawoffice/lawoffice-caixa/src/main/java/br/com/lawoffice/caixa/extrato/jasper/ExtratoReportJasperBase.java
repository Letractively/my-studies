package br.com.lawoffice.caixa.extrato.jasper;

import java.util.HashMap;
import java.util.Map;

import br.com.lawoffice.caixa.extrato.ExtratoDTO;
import br.com.lawoffice.caixa.extrato.ExtratoReport;

/**
 * 
 * Classe Base para as implementacões do {@link ExtratoReport} utilizando Jasper Report 4.2.
 * 
 * @author rduarte
 *
 */
public abstract class ExtratoReportJasperBase implements ExtratoReport{


	/**
	 * Retoran um map populado com os paramentros do relatorio.
	 * 
	 * @param extratoDTO
	 * @return
	 */
	protected Map<String,String> getMapParametros(ExtratoDTO extratoDTO) {
		Map<String, String> paramentros =
				new HashMap<String, String>();
		return paramentros;
	}

}