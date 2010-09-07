package br.com.fiapbank.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.fiapbank.dominio.Conta;

/**
 * Servlet Filter implementation class ClienteFilter
 */
public class ClienteFilter extends FilterAdapter implements Filter {
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = ((HttpServletRequest) request);
 		
		HttpSession session = 
			( (HttpServletRequest) request ).getSession();
		
		RequestDispatcher dispatcher = null;
						
		Conta conta= 
			(Conta) session.getAttribute("conta");
				
		if( conta == null  ){			
			dispatcher = request.getRequestDispatcher("/login.jsf");			
		}
		
		else{			
			dispatcher = request.getRequestDispatcher(servletRequest.getServletPath());			
		}
		
		 dispatcher.forward(request, response); 
	}
}
