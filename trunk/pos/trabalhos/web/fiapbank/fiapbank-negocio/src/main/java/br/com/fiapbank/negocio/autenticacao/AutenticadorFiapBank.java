/**
 * 
 */
package br.com.fiapbank.negocio.autenticacao;

import br.com.fiapbank.dominio.Conta;
import br.com.fiapbank.dominio.Funcionario;
import br.com.fiapbank.negocio.NegocioException;
import br.com.fiapbank.persistencia.dao.ContaDao;
import br.com.fiapbank.persistencia.dao.FuncionarioDao;
import br.com.fiapbank.persistencia.dao.hibernate.jpa.ContaDaoJPAHibernate;
import br.com.fiapbank.persistencia.dao.hibernate.jpa.FuncionarioDaoJPAHibernate;

/**
 * @author robson.oliveira
 *
 */
public class AutenticadorFiapBank implements Autenticador{

	/**
	 * 
	 */
	private ContaDao contaDao;
	
	/**
	 * 
	 */
	private FuncionarioDao funcionarioDao;


	public AutenticadorFiapBank() {
		funcionarioDao = new FuncionarioDaoJPAHibernate();
		contaDao = new ContaDaoJPAHibernate();
	}
	
	
	@Override
	public Conta autenticarConta(Conta conta) throws NegocioException{
		if (conta == null || conta.getSenha() == null || conta.getFraseSecreta() == null)
			throw new IllegalArgumentException("conta nula ou senha nula ou frase secreta nula");
		
		try {			
			conta = contaDao.getContaAutenticada(conta);
		} catch (Exception e){
			throw new NegocioException(e);
		}

		
		return conta;
	}




	@Override
	public Funcionario autenticarFuncionario(Funcionario funcionario)throws NegocioException {
		if (funcionario == null || funcionario.getSenha() == null)
			throw new IllegalArgumentException("funcionario estão nulo ou senha nula");
		
		try {
			funcionario = funcionarioDao.getFuncionarioAutenticado(funcionario);
		} catch (Exception e) {
			throw new NegocioException(e);
		}	
		
		return funcionario;		
	}

	

	/**
	 * @param contaDao
	 */
	public void setContaDao(ContaDao contaDao) {
		this.contaDao = contaDao;
	}


	

	/**
	 * @param funcionarioDao
	 */
	public void setFuncionarioDao(FuncionarioDao funcionarioDao) {
		this.funcionarioDao = funcionarioDao;
	}


}
