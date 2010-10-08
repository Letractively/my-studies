/**
 * 
 */
package br.com.studies.struts.helloword;

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
public class HelloWordAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HelloWordActionForm helloActionForm = (HelloWordActionForm) form;
		
		helloActionForm.setMessage("Hello Word !");
		
		return mapping.findForward("sucess");
	}	
}
