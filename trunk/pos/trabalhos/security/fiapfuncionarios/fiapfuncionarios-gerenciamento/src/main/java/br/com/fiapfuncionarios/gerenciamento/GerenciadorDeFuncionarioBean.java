/**
 * 
 */
package br.com.fiapfuncionarios.gerenciamento;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.fiapfuncionarios.dominio.Funcionario;

/**
 * @author robson
 *
 */
@Stateless
@Local(value = GerenciadorDeFuncionarioLocal.class)
@Remote(value = GerenciadorDeFuncionarioRemote.class)
public class GerenciadorDeFuncionarioBean implements GerenciadorDeFuncionarioLocal , GerenciadorDeFuncionarioRemote{

	private static final Log LOG = LogFactory.getLog(GerenciadorDeFuncionarioBean.class);
	
	
	@PersistenceContext(unitName="fiapfuncionarios")
	private EntityManager entityManager;	
	
	
	@Override
	public void Remover(Funcionario funcionario) {
		if (funcionario == null || funcionario.getId() == null)  
			throw new IllegalArgumentException("Funcionario esta null ou id esta null");
		LOG.info("Inciando o processo de remover de funcionario");
		entityManager.remove(entityManager.find(Funcionario.class, funcionario.getId()));
		LOG.info("Processo Realizado com Sucesso");
	}


	@Override
	public void cadastrar(Funcionario funcionario) throws EntidadeInvalidaException {
		if (funcionario == null) 
			throw new IllegalArgumentException("Funcionario esta null");
		
		LOG.info("Inciando o processo de cadastro de funcionario");
		
		funcionario = validar(funcionario)
						.verificarLogin(funcionario)
						.criptografarSenha(funcionario);
		
		entityManager.persist(funcionario);		
		
		LOG.info("Processo Realizado com Sucesso");
	}


	@Override
	public void promover(Funcionario funcionario) {
		if (funcionario == null || funcionario.getId() == null)  
			throw new IllegalArgumentException("Funcionario esta null ou id esta null");
		LOG.info("Inciando o processo de promover de funcionario para gerente");
		funcionario.setCargo("GERENTE");
		entityManager.merge(funcionario);
		LOG.info("Processo Realizado com Sucesso");
	}	
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Funcionario> getFuncionarioPromocao(){
		return entityManager.createQuery("select f from Funcionario f where f.cargo <> :cargo")
			.setParameter("cargo", new String("GERENTE"))
			.getResultList();
	}


	
	@Override
	@SuppressWarnings("unchecked")
	public List<Funcionario> getFuncionarios() {
		return entityManager.createQuery("select f from Funcionario f)")
		.getResultList();
	}


	/**
	 * validacao simples da entidade
	 * 
	 * @param funcionario
	 * @throws EntidadeInvalidaException
	 */
	private GerenciadorDeFuncionarioBean validar(Funcionario funcionario) throws EntidadeInvalidaException {
		if (StringUtils.isBlank(funcionario.getNome()))
			throw new EntidadeInvalidaException("O nome e obrigatorio");
		if (StringUtils.isBlank(funcionario.getEmail()))
			throw new EntidadeInvalidaException("O e-mail e obrigatorio");
		if (StringUtils.isBlank(funcionario.getLogin()))
			throw new EntidadeInvalidaException("O login e obrigatorio");
		if (StringUtils.isBlank(funcionario.getSenha()))
			throw new EntidadeInvalidaException("A senha e obrigatoria");
		return this;		
	}
	

	
	private GerenciadorDeFuncionarioBean verificarLogin(Funcionario funcionario) throws EntidadeInvalidaException{		 
			try {
				entityManager.createQuery("select f from Funcionario f where f.login = :login")
				.setParameter("login", funcionario.getLogin()).getSingleResult();
			} catch (NoResultException e) {
				return this;
			}		
			throw new EntidadeInvalidaException("Login ja existente");						
	}
	
	
	private Funcionario criptografarSenha(Funcionario funcionario){
		funcionario.setSenha( DigestUtils.md5Hex(funcionario.getSenha()));
		return funcionario;
	}
}
