/**
 * 
 */
package br.com.fiapfuncionarios.gerenciamento;

import java.util.List;

import br.com.fiapfuncionarios.dominio.Funcionario;

/**
 * @author robson
 *
 */
public interface GerenciadorDeFuncionario {
	
	public void cadastrar(Funcionario funcionario) throws EntidadeInvalidaException;
	
	public void Remover(Funcionario funcionario);
	
	public void promover(Funcionario funcionario);
	
	public List<Funcionario> getFuncionarioPromocao();
	
	public List<Funcionario> getFuncionarios();
}
