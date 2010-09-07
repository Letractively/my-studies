/**
 * 
 */
package br.com.fiapfuncionarios.autenticacao;

import java.security.acl.Group;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;

/**
 * @author robson
 *
 */
public class FiapFuncionariosLogin extends UsernamePasswordLoginModule  {

	
	private static final Log LOG = LogFactory.getLog(FiapFuncionariosLogin.class);
	
	
	private FiapFuncionariosAutenticador fiapFuncionariosAutenticador;

	
	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String, ?> sharedState, Map<String, ?> options) {			
			super.initialize(subject, callbackHandler, sharedState, options);
			fiapFuncionariosAutenticador = new FiapFuncionariosAutenticadorJDBC(callbackHandler, subject);
		}

	@Override
	protected String getUsersPassword() throws LoginException {
		try {
			return fiapFuncionariosAutenticador.getSenha();
		} catch (Exception e) {
			throw new LoginException(e.getMessage());
		}
	}

	
	@Override
	protected Group[] getRoleSets() throws LoginException {
		try {
			return fiapFuncionariosAutenticador.getGrupos();
		} catch (Exception e) {
			throw new LoginException(e.getMessage());
		}
	}

	
	@Override
	protected boolean validatePassword(String inputPassword,String expectedPassword) {			
			boolean isUsuario = false; 
			try {
				isUsuario = fiapFuncionariosAutenticador.isUsuario() ;
			} catch (Exception e) {
				LOG.error("Ocorreru um erro na autenticadao : ", e);
			}
			return isUsuario;
	}

}
