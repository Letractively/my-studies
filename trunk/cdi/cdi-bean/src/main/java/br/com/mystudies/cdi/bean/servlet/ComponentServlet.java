package br.com.mystudies.cdi.bean.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mystudies.cdi.bean.Component;


@WebServlet("/component")
public class ComponentServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       

	
	@Inject
	private Component component;
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		printWriter.print(component.upperCase(request.getParameter("name")));
	}


}
