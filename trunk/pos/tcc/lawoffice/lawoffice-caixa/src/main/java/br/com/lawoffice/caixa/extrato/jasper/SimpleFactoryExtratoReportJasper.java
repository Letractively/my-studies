package br.com.lawoffice.caixa.extrato.jasper;

import br.com.lawoffice.caixa.extrato.ExtratoReport;
import br.com.lawoffice.caixa.extrato.FactoryExtratoReport;
import br.com.lawoffice.caixa.extrato.TipoExtrato;

/**
 * Factory para criação de {@link ExtratoReport} através do seu {@link TipoExtrato} 
 * para implementações que utilizam o Jasper Report 4.0.1 para geração do arquivo de extrato.
 * 
 * @author robson
 *
 */
public class SimpleFactoryExtratoReportJasper implements FactoryExtratoReport{

	
	
	
	@Override
	public ExtratoReport createExtratoReport(TipoExtrato tipoExtrato) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
/*	public static ExtratoReport createExtratoReport(TipoExtrato tipoExtrato){
		
		switch (tipoExtrato){
			case PDF:
				return new ExtratoReportPDF();
		default:
			throw new IllegalArgumentException("Não existe Extrato para o tipo passado");
		}
	}*/
}
