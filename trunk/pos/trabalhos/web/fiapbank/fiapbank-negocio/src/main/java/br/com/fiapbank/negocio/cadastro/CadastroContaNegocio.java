package br.com.fiapbank.negocio.cadastro;

import br.com.fiapbank.dominio.Conta;
import br.com.fiapbank.negocio.NegocioException;

/**
 * @author robson
 *
 */
public interface CadastroContaNegocio {

	public void cadastrar( Conta conta)throws NegocioException;
}
