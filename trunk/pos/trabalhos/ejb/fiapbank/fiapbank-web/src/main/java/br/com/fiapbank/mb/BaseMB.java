package br.com.fiapbank.mb;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



/**
 * @author robson.oliveira
 *
 */
public class BaseMB { 	
		
	protected String msg;

	
	public String getLoginSessao() {
		return ((HttpServletRequest) getExternalContext().getRequest()).getUserPrincipal().getName();
	}

	
	public void logout() throws IOException{
		HttpSession session =
			(HttpSession) getExternalContext().getSession(true);		
		session.removeAttribute("username");
		session.removeAttribute("passwd");
		session.invalidate();
		redirectLogin();
	}

	
	
	protected void redirectLogin() throws IOException{
		getExternalContext().redirect("/fiapbank");
	}	
	
	/**
	 * @return
	 */
	private ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	
	
	
	protected void adicionarMsg(String msg) {
		setMsg(msg);
	}

	protected void removeMsg() {
		setMsg(null);
	}
	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}	
}
