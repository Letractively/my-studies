/**
 * 
 */
package br.com.mystudies.struts.dispatchaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * @author rduarte
 *
 */
public class UserAction extends DispatchAction {

	public  ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {	
		return getUserForm(form, "Inside add user method.").forwarSucess(mapping);
	}
	
		
	public  ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {	
		return getUserForm(form, "Inside update user method.").forwarSucess(mapping);
	}
	
		
	public  ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {	
		return getUserForm(form, "Inside delete user method.").forwarSucess(mapping);
	}
		
	
	private UserAction getUserForm(ActionForm form, String msg){
		((UserForm) form).setMessage(msg);
		return this;
	}
	
	private ActionForward forwarSucess(ActionMapping mapping){
		return mapping.findForward("SUCESS");
	}
	
}

