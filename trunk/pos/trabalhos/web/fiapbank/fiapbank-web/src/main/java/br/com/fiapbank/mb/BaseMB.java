package br.com.fiapbank.mb;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.fiapbank.dominio.Conta;

public class BaseMB {

	
	/**
	 * 
	 */
	protected HttpSession session;
	
	
	/**
	 * 
	 */
	private String msg;

	
	
	public BaseMB() {
		setSession();
	}
	
	
	/**
	 * 
	 */
	private void setSession() {
		session = ( HttpSession ) 
			getExternalContext().getSession( true );
	}



	/**
	 * @return
	 */
	private ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance()
			.getExternalContext();
	}

	
	protected Conta getContaSession(){
		return (Conta) session.getAttribute("conta");
	}
	
	/**
	 * @param name
	 * @param value
	 */
	protected void setAtributoInSession( String name , Object value){
		session.setAttribute(name, value);
	}
	
	
	
	/**
	 * @return
	 */
	public String logout(){
		session.invalidate();
		return "login";
	}
	
	
	public String getMsg() {
		return msg;
	}

	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
