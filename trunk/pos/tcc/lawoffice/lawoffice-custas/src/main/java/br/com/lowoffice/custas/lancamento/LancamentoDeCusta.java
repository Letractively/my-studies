package br.com.lowoffice.custas.lancamento;

import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;
import br.com.lowoffice.custas.exception.LancamentoDeCustaException;



/**
 * //TODO: melhorar o java doc
 * 
 * interface para os serviço de laçamentos de custa
 * 
 * @author robson
 *
 */
public interface LancamentoDeCusta{

	Custa adicionarCusta(Custa custa, Cliente cliente, Colaborador colaborador);
	
	void removerCusta(Custa custa) throws LancamentoDeCustaException;
	
	Custa atualizarCusta(Custa custa)throws LancamentoDeCustaException;
	
	void fecharLacamento() throws LancamentoDeCustaException;
	
}
