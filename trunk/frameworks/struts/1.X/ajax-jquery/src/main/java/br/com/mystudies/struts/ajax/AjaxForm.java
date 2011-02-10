/**
 * 
 */
package br.com.mystudies.struts.ajax;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * @author rduarte
 *
 */
public class AjaxForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2653814035654131779L;

	private String login;

	private String password;

/*	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (StringUtils.isEmpty(login))
			errors.add("login", new ActionMessage("error.login.required"));
		if (StringUtils.isEmpty(password))
			errors.add("password", new ActionMessage("error.password.required"));
		return errors;
	}*/

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
