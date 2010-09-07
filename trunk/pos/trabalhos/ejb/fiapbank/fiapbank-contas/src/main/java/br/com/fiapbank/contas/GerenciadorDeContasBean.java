/**
 * 
 */
package br.com.fiapbank.contas;

import java.util.Date;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.security.annotation.SecurityDomain;

import br.com.fiapbank.dominio.entidade.Cliente;
import br.com.fiapbank.dominio.entidade.Conta;
import br.com.fiapbank.dominio.entidade.Perfil;
import br.com.fiapbank.dominio.entidade.Renda;

/**
 * Implementacao stateful do gerenciador de contas local e remoto
 * 
 * @author robson.oliveira
 *
 */
@Stateful
@Local(GerenciadorDeContasLocal.class)
@Remote(GerenciadorDeContasRemote.class)
@SecurityDomain(value="fiapbank-security")
public class GerenciadorDeContasBean implements GerenciadorDeContasLocal,GerenciadorDeContasRemote {

	
	/**
	 * Log da classe
	 */
	private Log LOG = LogFactory.getLog(GerenciadorDeContasBean.class);

	
	@PersistenceContext(unitName="fiapbank_contas")
	private EntityManager entityManager;
		
	
	
	/**
	 * cliente aprovado para abertura da conta 
	 */
	private Cliente clienteAvaliado;
	
	
	/**
	 * renda aprovada para a abertura da conta 
	 */
	private Renda rendaAvaliada;
	
	
	@RolesAllowed(value={"GERENTE"})
	public Conta abriConta(Conta conta) throws GerenciadorDeContasException, ContaInvalidaExcetpion {
		if (conta == null) 
			throw new ContaInvalidaExcetpion("Conta nula");
		if ( clienteAvaliado == null || rendaAvaliada == null ) 
			throw new ContaInvalidaExcetpion("Cliente ou Renda nao foram avaliados");
	
		try {
			LOG.info("Inciando a criacao da conta simples");
			entityManager.persist(preAbriConta(conta));
			setLogin(conta);
			LOG.info("Conta Simples criada com sucesso com o numero.: " + conta.getId());
		}catch (Exception e) {
			throw new GerenciadorDeContasException(e);
		}
		
		return conta;

	}


	@RolesAllowed(value={"GERENTE"})
	public void avaliarRenda(Renda renda) throws RendaInvalidaExcetpion{
		if ( renda == null) {			
			invalidarRenda();
			throw new RendaInvalidaExcetpion("Renda nula");
		}
		
		// regrinha bem simples somente para simulacao de avaliacao de renda		
		if( renda.getRendaMensal().subtract(renda.getGastoMensal()).doubleValue() < 10){
			invalidarRenda();
			throw new RendaInvalidaExcetpion("Renda insuficiente");
		}
		
		rendaAvaliada = renda;
	}


	@RolesAllowed(value={"GERENTE"})
	public void avaliarCliente(Cliente cliente) throws ClienteInvalidoException{
		if (cliente == null ){
			invalidarCliente();
			throw new ClienteInvalidoException("Cliente nulo");
		}
	
		consultarCPF(cliente.getCpf());
	
		clienteAvaliado = cliente;
	}

	/**
	 * prepara a conta para ser aberta
	 * 
	 * @param conta
	 * @return
	 * @throws EntidadeInvalidaException quando a entidade nao passa na validacao
	 */
	private Conta preAbriConta(Conta conta){
		
		conta.setDataDeAbertura(new Date());
				
		conta.setId(null);
		conta.getSeguranca().setPerfil(Perfil.CLIENTE);
		conta.setCliente(clienteAvaliado);
		conta.getCliente().setRenda(rendaAvaliada);

		return conta;
	}


	/**
	 * ajusta o login para conta com o seu numero
	 * 
	 * @param conta
	 */
	private void setLogin(Conta conta) {
		conta.getSeguranca().setLogin(conta.getId().toString());
		entityManager.flush();
		entityManager.merge(conta.getSeguranca());
	}
	
	
	
	/**
	 * Uma regra simples para simular um possivel consulta no serasa ...
	 * 
	 * @param cpf
	 * @throws ClienteInvalidoException
	 */
	private void consultarCPF(String cpf) throws ClienteInvalidoException{
		if (cpf.startsWith("2")){ 
			invalidarCliente();
			throw new ClienteInvalidoException("Cliente com o nome sujo ");
		}		
	}
	
	private void invalidarCliente() {
		clienteAvaliado = null;
	}
	
	private void invalidarRenda() {
		rendaAvaliada = null;
	}
	
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
