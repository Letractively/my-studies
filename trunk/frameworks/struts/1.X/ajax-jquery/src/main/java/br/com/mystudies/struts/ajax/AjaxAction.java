/**
 * 
 */
package br.com.mystudies.struts.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * @author rduarte
 *
 */
public class AjaxAction extends DispatchAction {

	public ActionForward ajax(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AjaxForm loginForm = (AjaxForm) form;
		
		if(loginForm.getLogin().equals(loginForm.getPassword()))
			response.getWriter().print("ola !");
		else
			response.getWriter().print("login falhou !!");
		
		return null;
	}

	
}
