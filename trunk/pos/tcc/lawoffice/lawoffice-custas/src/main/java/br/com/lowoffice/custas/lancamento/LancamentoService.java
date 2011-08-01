package br.com.lowoffice.custas.lancamento;

import java.util.Date;

import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;



/**
 * //TODO: melhorar o java doc
 * 
 * interface para os serviço de laçamentos de custa
 * 
 * @author robson
 *
 */
public interface LancamentoService{

	Custa adicionarCusta(Custa custa, Cliente cliente, Colaborador colaborador, Date data);

	void removerCusta(Custa custa);
	
	void fecharLacamento();
	
	
	/*Custa atualizarCusta(Custa custa, Pessoa cliente, Colaborador colaborador)throws LancamentoDeCustaException;*/

	
}
