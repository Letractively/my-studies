/**
 * 
 */
package br.com.lowoffice.custas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.lawoffice.caixa.Caixa;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.dominio.Lancamento;
import br.com.lowoffice.custas.exception.LacamentoDeCustaException;

/**
 * TODO: mock para para validação do serviço...
 * 
 * @author robson
 *
 */
public class LancamentoDeCustaBean implements LancamentoDeCusta {
	
	
	/**
	 * Caixa para fechamento do lançamento , debito para o cliente , credito para o colaborador
	 */
	private Caixa caixa;
	
	
	
	public LancamentoDeCustaBean() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *	Mapa com os laçamento  
	 */
	private Map<Map<Cliente, Colaborador>, Lancamento> mapsLacamentos;
	
	
	
	
	// TODO: em termos da validação da custa e outros cara temos um debito técnico com beans validation
	// então vamos fechar a camada de persitência e realizar as validações 
	// falo isso pq o método abaixo está aceitando qualquer custa ou cliente ou colaborador
	// e não á testes de unidade para isso
	@Override
	public Custa adicionarCusta(Custa custa, Cliente cliente, Colaborador colaborador){
		return custa.addLancamento(
				getLacamento(
						cliente,
						colaborador
					).addCusta(custa)
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
	public void fecharLacamento()throws LacamentoDeCustaException{
		
		if(mapsLacamentos == null)
			throw new LacamentoDeCustaException("Não há lançamento(s) para fechar");
		
	
		List<Lancamento> lancamentos =  new ArrayList<Lancamento>(mapsLacamentos.values());
		
		
		for (Lancamento lancamento : lancamentos) {
			
			caixa.creditar(
				lancamento.getColaborador().getConta(), 
				lancamento.getTotal()
			);
			
			caixa.debitar(
				lancamento.getCliente().getConta(), 
				lancamento.getTotal()
			);
			
			// entityManager.persist(lancamentos)
						
		}
		
		
		
		
		// TODO Auto-generated method stub		
	}



	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	
	
	
}
