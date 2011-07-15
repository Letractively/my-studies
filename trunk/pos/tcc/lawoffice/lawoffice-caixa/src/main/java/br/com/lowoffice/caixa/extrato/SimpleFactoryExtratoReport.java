package br.com.lowoffice.caixa.extrato;

/**
 * Factory para criação de {@link ExtratoReport} através do seu {@link TipoExtrato}
 * 
 * @author robson
 *
 */
public class SimpleFactoryExtratoReport{

	public static ExtratoReport createExtratoReport(TipoExtrato tipoExtrato){
		
		switch (tipoExtrato){
			case PDF:
				return new ExtratoReportPDF();
		default:
			throw new IllegalArgumentException("Não existe Extrato para o tipo passado");
		}
	}
}
