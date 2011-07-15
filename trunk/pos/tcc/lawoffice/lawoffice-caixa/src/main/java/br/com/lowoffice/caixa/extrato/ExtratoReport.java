/**
 * 
 */
package br.com.lowoffice.caixa.extrato;

import java.util.List;

import br.com.lawoffice.dominio.Custa;

/**
 * 
 * Interface de serviço para a criação do extrato de custa
 * 
 * @author robson
 *
 */
public interface ExtratoReport{

	/**
	 * 
	 * Gera o Extrato utilizando a {@link List} de {@link Custa} passada como resource.
	 * 
	 * @param listaCustas
	 * @return
	 */
	public byte[] gerarExtrato(ExtratoDTO extratoDTO);
}
