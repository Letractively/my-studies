package br.com.lowoffice.custas.lancamento;

import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;
import br.com.lowoffice.custas.exception.LacamentoDeCustaException;



/**
 * //TODO: melhorar o java doc
 * 
 * interface para os serviço de laçamentos de custa
 * 
 * @author robson
 *
 */
public interface LancamentoDeCusta{

	public Custa adicionarCusta(Custa custa, Cliente cliente, Colaborador colaborador);
	
	public void fecharLacamento() throws LacamentoDeCustaException;
	
}
