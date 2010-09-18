package br.com.lowoffice.custas;

import br.com.lawoffice.dominio.Custa;

/**
 * @author robson
 *
 */
public interface LancamentoDeCusta {

	public void salvarNovoLancamento();
	
	// TODO: esse cara ainda não está defindo como vai ser realmente.
	// preciso saber ser na hora do lancamento podemos add somente um cliente e um colaborador..
	// hoje definições de regras

	public Custa addCusta(Custa custa, String nomeCliente, String nomeColaborador);
	
}
