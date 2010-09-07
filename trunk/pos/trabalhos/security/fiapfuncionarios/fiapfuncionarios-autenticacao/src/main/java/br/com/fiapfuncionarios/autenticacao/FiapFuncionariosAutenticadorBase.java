package br.com.fiapfuncionarios.autenticacao;

import java.security.acl.Group;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;

import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;

import br.com.fiapfuncionarios.dominio.Funcionario;

/**
 * @author robson
 *
 */
public class FiapFuncionariosAutenticadorBase {
	
	
	private CallbackHandler callbackHandler;
	
	private Subject subject;

	private Callback[] callbacks = { new NameCallback("login"), new PasswordCallback("senha", false)};
	
	
	public FiapFuncionariosAutenticadorBase(CallbackHandler callbackHandler , Subject subject){
		if (callbackHandler == null || subject == null)
			throw new IllegalArgumentException("CallbackHandler ou Subject esta null");
		this.callbackHandler = callbackHandler;
		this.subject = subject;
	}
	
	
	private void handle() throws Exception{
		callbackHandler.handle(callbacks);
	}


	protected String getLogin() throws Exception{
		handle();
		return ((NameCallback) callbacks[0]).getName() ;
	}
	
	
	protected String getPassword() throws Exception{ 
		handle();
		return new String(((PasswordCallback) callbacks[1]).getPassword());
	}
	
	
	protected Group[] adicionarUsuarioGrupo(Funcionario funcionario){
		if (funcionario == null) 
			throw new IllegalArgumentException("Usuario null");
		
		SimpleGroup sg = new SimpleGroup("Roles");		
		sg.addMember(new SimplePrincipal(funcionario.getCargo()));
	
		return new Group[]{sg};
	}	
}
