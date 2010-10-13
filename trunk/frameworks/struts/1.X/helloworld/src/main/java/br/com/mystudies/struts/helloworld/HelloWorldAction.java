/**
 * 
 */
package br.com.mystudies.struts.helloworld;

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
public class HelloWorldAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HelloWorldActionForm helloActionForm = (HelloWorldActionForm) form;
		
		helloActionForm.setMessage("Hello World !");
		
		return mapping.findForward("success");
	}	
}
