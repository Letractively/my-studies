/**
 * 
 */
package br.com.fiapbank.negocio.cadastro;

import org.apache.commons.lang.StringUtils;

import br.com.fiapbank.dominio.Conta;
import br.com.fiapbank.negocio.NegocioBase;
import br.com.fiapbank.negocio.NegocioException;
import br.com.fiapbank.persistencia.dao.ContaDao;

/**
 * @author robson
 *
 */
public class CadastroContaNegocioFiapBank extends NegocioBase implements CadastroContaNegocio {

	
	public CadastroContaNegocioFiapBank(){
		super();
	}
	
	
	public CadastroContaNegocioFiapBank(ContaDao contaDao){
		super();
	}
	
	
	@Override
	public void cadastrar(Conta conta) throws NegocioException {
		validarConta(conta);
		validarDadosConta(conta);
		try {
			if(getConta(conta) != null)
				throw new NegocioException("Conta ja existente");
		} catch (Exception e){
			try {
				conta.setSaldo(0.0);
				contaDao.insert(conta);
			} catch (Exception ex) {
				throw new NegocioException(ex);
			}
		}

	}


	private void validarDadosConta(Conta conta) throws NegocioException {
		if (StringUtils.isBlank(conta.getNumero()))
			throw new NegocioException("Numero obrigatorio");
		if (StringUtils.isBlank(conta.getNumeroAgencia()))
			throw new NegocioException("Agencia obrigatoria");
		if (StringUtils.isBlank(conta.getSenha()))
			throw new NegocioException("Senha obrigatoria");
		if (StringUtils.isBlank(conta.getFraseSecreta()))
			throw new NegocioException("Frase secreta obrigatoria");		
	}

}
