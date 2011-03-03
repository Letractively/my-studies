/**
 * 
 */
package br.com.lawoffice.web.mb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 * 
 * Classe base para os Manager Beans do projeto
 * 
 * 
 * @author robson
 *
 */
public class BaseMB {

	/**
	 * TODO: javadoc
	 * 
	 * @param sumario
	 * @param detalhe
	 */
	protected void adicionarMensagemInformacao(String clienteID, String sumario, String detalhe) {
		adicionarMensagem(clienteID, new FacesMessage(FacesMessage.SEVERITY_INFO, sumario, detalhe));
	}
	
	
	/**
	 * TODO: javadoc
	 * 
	 * @param sumario
	 * @param detalhe
	 */
	protected void adicionarMensagemAlerta(String clienteID, String sumario, String detalhe) {
		adicionarMensagem(clienteID, new FacesMessage(FacesMessage.SEVERITY_WARN, sumario, detalhe));
	}
	
	
	/**
	 * TODO: javadoc
	 * 
	 * @param sumario
	 * @param detalhe
	 */
	protected void adicionarMensagemErro(String clienteID, String sumario, String detalhe) {
		adicionarMensagem(clienteID, new FacesMessage(FacesMessage.SEVERITY_ERROR, sumario, detalhe));
	}
	
	/**
	 * TODO: javadoc
	 * 
	 * @param sumario
	 * @param detalhe
	 */
	protected void adicionarMensagemErroValidacao(String clienteID, String detalhe) {
		adicionarMensagem(clienteID, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existem campos obrigatórios sem preenchimento..: ", detalhe)); // TODO: internacionalizacao
	}	
	
	
	/**
	 * TODO: javadoc
	 * 
	 * @param clienteID
	 * @param facesMessage
	 */
	private void adicionarMensagem(String clienteID, FacesMessage facesMessage){
		FacesContext.getCurrentInstance().addMessage(clienteID,facesMessage);
	}
	
}
