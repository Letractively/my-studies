package br.com.lawoffice.custas.lancamento;

import java.util.Date;

import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.dominio.Lancamento;



/**
 * //TODO: melhorar o java doc
 * 
 * interface para os serviço de laçamentos de custa
 * 
 * @author robson
 *
 */
public interface LancamentoService{

	/**
	 * Adiciona uma {@link Custa} para o {@link Cliente} e a para o {@link Colaborador} em um {@link Lancamento}.
	 * 
	 * <br>
	 * 
	 * TODO: java doc explicando o funicionamento do criteirio de criação da chave do lançamento 
	 * 
	 * 
	 * @param custa
	 * @param cliente
	 * @param colaborador
	 * @param data
	 * @return
	 * @throws IllegalArgumentException
	 */
	Custa adicionarCusta(Custa custa, Cliente cliente, Colaborador colaborador, Date data);
	
	/**
	 * @throws IllegalStateException
	 */
	void fecharLacamento();	

	
	void removerCusta(Custa custa);
	


	
}
