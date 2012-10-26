package br.com.mystudies.cdi.bean.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mystudies.cdi.hash.Hash;
import br.com.mystudies.cdi.qualifier.MD5;
import br.com.mystudies.cdi.qualifier.SHA1;
import br.com.mystudies.cdi.qualifier.SHA256;


@WebServlet("/hash")
public class HashServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       

	
	@Inject @MD5
	private Hash md5;
	
	@Inject @SHA1
	private Hash sha1;
	
	@Inject @SHA256
	private Hash sha256;
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String algoritmo = request.getParameter("algoritmo");
		String nome = request.getParameter("nome");
		
		
		if(algoritmo == null)
			throw new ServletException("Algoritmo está nulo");
		
		String print = null;
		
		switch (algoritmo) {
		
			case "md5":
				print = md5.getHash(nome);
				break;
				
			case "sha1":
				print = sha1.getHash(nome);
				break;
				
			case "sha256":
				print = sha256.getHash(nome);
				break;
	
			default:
				throw new ServletException("não existe algoritmo de hash para o parametro passado..: " + algoritmo);
		}
		
		PrintWriter printWriter = response.getWriter();
		printWriter.print(print);
	}

}
