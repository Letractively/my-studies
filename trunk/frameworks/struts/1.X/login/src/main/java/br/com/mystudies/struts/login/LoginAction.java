/**
 * 
 */
package br.com.mystudies.struts.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author rduarte
 *
 */
public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginForm loginForm = (LoginForm) form;
		
		if(loginForm.getLogin().equals(loginForm.getPassword()))
			return mapping.findForward("success");
		
		return mapping.findForward("failure");
	}

	
}
