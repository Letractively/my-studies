/**
 * 
 */
package br.com.lowoffice.custas;

import java.util.HashMap;
import java.util.Map;

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
public class LancamentoDeCustaBean implements LancamentoDeCusta {
	
	/**
	 *	Mapa com os laçamento  
	 */
	private Map<Map<Cliente, Colaborador>, Lancamento> mapsLacamentos;
	
	
	
	@Override
	public Custa adicionarCusta(Custa custa, Cliente cliente, Colaborador colaborador){
		return custa.addLancamento(
				getLacamento(cliente,colaborador)
			);
	}
	
	

	private Lancamento getLacamento(Cliente cliente, Colaborador colaborador) {
		if(mapsLacamentos == null)
			mapsLacamentos = new HashMap<Map<Cliente,Colaborador>, Lancamento>(); // TODO: relembrar a diferença desse cara
		
		// todo: guava ??
		Map<Cliente, Colaborador> chave = new HashMap<Cliente, Colaborador>();
		chave.put(cliente, colaborador);
		

		if( !mapsLacamentos.containsKey(chave))
			mapsLacamentos.put(
					chave, 
					new Lancamento()
						.adicionarCliente(cliente)
						.adicionarColaborador(colaborador)
						.adicionarDataLancamento()
				);
		
		return mapsLacamentos.get(chave);
	}



	@Override
	public void fecharLacamento() {
		// TODO Auto-generated method stub		
	}
	
}
