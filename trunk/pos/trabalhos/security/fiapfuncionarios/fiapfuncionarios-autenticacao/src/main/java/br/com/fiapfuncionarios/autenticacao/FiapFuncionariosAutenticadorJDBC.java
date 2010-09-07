package br.com.fiapfuncionarios.autenticacao;

import java.security.acl.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Date;
import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.sql.DataSource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.fiapfuncionarios.dominio.Funcionario;

/**
 * @author robson
 *
 */
public class FiapFuncionariosAutenticadorJDBC extends FiapFuncionariosAutenticadorBase implements FiapFuncionariosAutenticador{

	
	private static final Log LOG = LogFactory.getLog(FiapFuncionariosAutenticadorJDBC.class);

	
	private Funcionario funcionario;
	
	
	public FiapFuncionariosAutenticadorJDBC(CallbackHandler callbackHandler,Subject subject) {
		super(callbackHandler, subject);
	}

	
	@Override
	public boolean isUsuario() throws Exception{
		try {
			getFuncionario(getLogin(), getPassword()); 
			if (funcionario != null) 
				return true;
			return false;			
		} catch (Exception e) {
			throw e;
		}
	}
	
	private void adicionarHistoricoDeAcesso(Funcionario funcionario) throws Exception {
		
		Connection connection = null;
		
		try {
			
			LOG.info("Adicionando historico de acesso para o funcionario..: " + funcionario.getLogin());
			
			connection = getConnection(); 
			
			PreparedStatement preparedStatement = 
				connection.prepareStatement("INSERT INTO HISTORICO_DE_ACESSO  ( DATA_DE_ACESSO , HORA_DE_ACESSO , FUNCIONARIO_ID ) VALUES ( ? , ? , ? )");
			
			Date date = new Date();
			
			preparedStatement.setDate(1, new java.sql.Date(date.getTime()));
			preparedStatement.setTime(2, new Time(date.getTime()));
			preparedStatement.setInt(3, funcionario.getId());
			
			preparedStatement.executeUpdate();
			
			LOG.info("Historico adicionado com sucesso");
			
		} catch (Exception e) {
			throw e;
		}finally{
			connection.close();
		}
		
		
	}

	@Override
	public Group[] getGrupos() throws Exception {
		adicionarHistoricoDeAcesso(funcionario);
		return adicionarUsuarioGrupo(funcionario);
	}


	@Override
	public String getSenha() throws Exception {
		return getPassword();
	}
	
	
	private void getFuncionario(String login , String senha) throws Exception{
		
		Connection connection = null;
		
		try {
			connection = getConnection(); 
			
			PreparedStatement preparedStatement = 
				connection.prepareStatement("SELECT ID, LOGIN, CARGO FROM FUNCIONARIO WHERE LOGIN = ? AND SENHA = ?");
			
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, DigestUtils.md5Hex(senha));
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				funcionario = new Funcionario();
				funcionario.setId(resultSet.getInt(1));
				funcionario.setLogin(resultSet.getString(2));
				funcionario.setCargo(resultSet.getString(3));
			}
		} catch (Exception e) {
			throw e;
		}finally{
			connection.close();
		}		
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	private Connection getConnection() throws Exception{
		
		Hashtable ht = new Hashtable();
		ht.put(InitialContext.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		ht.put(InitialContext.PROVIDER_URL, "jnp://localhost:1099");
		ht.put(InitialContext.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
		                          
		InitialContext initialContext = new InitialContext(ht);    
		DataSource dataSource = (DataSource) initialContext.lookup("java:MySqlDS");
		return dataSource.getConnection();
	}

}
