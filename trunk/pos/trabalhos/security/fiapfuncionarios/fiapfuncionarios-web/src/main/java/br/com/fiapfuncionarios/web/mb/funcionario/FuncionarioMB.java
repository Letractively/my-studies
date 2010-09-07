/**
 * 
 */
package br.com.fiapfuncionarios.web.mb.funcionario;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import br.com.fiapfuncionarios.dominio.Funcionario;
import br.com.fiapfuncionarios.gerenciamento.EntidadeInvalidaException;
import br.com.fiapfuncionarios.gerenciamento.GerenciadorDeFuncionarioLocal;
import br.com.fiapfuncionarios.web.mb.BaseMB;

/**
 * @author robson
 *
 */
public class FuncionarioMB extends BaseMB {

	
	@EJB
	private GerenciadorDeFuncionarioLocal gerenciadorDeFuncionarioLocal;
	
	
	/**
	 * funcionario para cadastro  
	 */
	private Funcionario funcionario;
	
	
	/**
	 * funcionarios para remover / promover
	 */
	private List<Funcionario> funcionarios;
	

	/**
	 *  id do funcionario para remover / promover
	 */
	private Integer idFuncionarioSelecionado;

	
	@PostConstruct
	public void init(){
		funcionario = new Funcionario();
	}
	
	
	public void cadastrar(){
		
		try {
			gerenciadorDeFuncionarioLocal.cadastrar(funcionario);
			init();
			setMsg("Funcionario Cadastrado com Sucesso !");			
		} catch (EntidadeInvalidaException e) {
			setMsg(e.getMessage());
		}
	}	

	
	public void remover(){
		getFuncionarioSelecionado();
		gerenciadorDeFuncionarioLocal.Remover(funcionario);
	}
	
	
	public void promover(){
		getFuncionarioSelecionado();
		gerenciadorDeFuncionarioLocal.promover(funcionario);
	}
	
	
	public String prepareFuncionariosPromover(){		
		funcionarios = gerenciadorDeFuncionarioLocal.getFuncionarioPromocao();
		return "promover-funcionario";
	}
	
	
	public String prepareFuncionariosRemover(){		
		funcionarios = gerenciadorDeFuncionarioLocal.getFuncionarios();
		return "excluir-funcionario";
	}
	
	
	public String home(){
		init();
		setMsg("");
		return "home";
	}

	
	
	/**
	 * 
	 * recupera o funcionario selecionado na lista para remover/provomer
	 * 
	 * e remove o mesmo da lista 
	 * 
	 */
	private void getFuncionarioSelecionado() {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getId().equals(idFuncionarioSelecionado)) {
				this.funcionario = funcionario;
				funcionarios.remove(funcionario);
				break;
			}
		}
	}	
	

	
	// GETS e SETS MB
	
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Integer getIdFuncionarioSelecionado() {
		return idFuncionarioSelecionado;
	}

	public void setIdFuncionarioSelecionado(Integer idFuncionarioSelecionado) {
		this.idFuncionarioSelecionado = idFuncionarioSelecionado;
	}


	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
}

