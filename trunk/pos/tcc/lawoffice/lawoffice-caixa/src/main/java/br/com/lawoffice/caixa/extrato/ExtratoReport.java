/**
 * 
 */
package br.com.lawoffice.caixa.extrato;


/**
 * 
 * Interface de serviço para a criação de arquivo de extrato.
 * 
 * @author robson
 *
 */
public interface ExtratoReport{

	/**
	 * 
	 * Gera o Extrato utilizando um {@link ExtratoDTO} passada como resource.
	 * 
	 * @param listaCustas
	 * @return
	 */
	public byte[] gerarExtrato(ExtratoDTO extratoDTO);
}
