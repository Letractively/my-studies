/**
 * 
 */
package br.com.lowoffice.custas;

import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.dominio.Lancamento;

/**
 * TODO: mock para para validação do serviço...
 * 
 * @author robson
 *
 */
public class LancamentoDeCustaMock implements LancamentoDeCusta {


	@Override
	public void salvarNovoLancamento() {
		System.out.println("salvando lançamentos ou lançamentos ???");
	}
	
	@Override
	public Custa addCusta(Custa custa, String nomeCliente, String nomeColaborador) {
		return custa.addLancamento(
			new Lancamento()
				.addCliente(new Cliente(nomeCliente))
				.addColaborador(new Colaborador(nomeColaborador))
		);
	}

}
