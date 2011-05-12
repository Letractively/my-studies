package br.com.mystudies.struts.htmltags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class HTMLTagsAction extends DispatchAction{


	public  ActionForward radio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		response.getWriter().print(
				" Seu sexo é: " 
				+ ( ((HTMLTagsForm) form).getSexo().equals("M") ? "Masculino" : "Feminino") 
			);

		return null;
	}	
	
}
