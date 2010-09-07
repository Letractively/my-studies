/**
 * 
 */
package br.com.fiapfuncionarios.autenticacao;

import java.security.acl.Group;

/**
 * @author robson
 *
 */
public interface FiapFuncionariosAutenticador {

	public boolean isUsuario() throws Exception;

	public String getSenha() throws Exception;
	
	public Group[] getGrupos() throws Exception;
}
