package br.com.fiapbank.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.fiapbank.dominio.Cargo;
import br.com.fiapbank.dominio.Funcionario;

/**
 * Servlet Filter implementation class CaixaFilter
 */
public class CaixaFilter extends FilterAdapter implements Filter {
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = ((HttpServletRequest) request);
 		
		HttpSession session = 
			( (HttpServletRequest) request ).getSession();
		
		RequestDispatcher dispatcher = null;
						
		Funcionario funcionario= 
			(Funcionario) session.getAttribute("funcionario");
				
		if( funcionario == null || ( funcionario.getCargo() != Cargo.CAIXA ) ){			
			dispatcher = request.getRequestDispatcher("/login.jsf");			
		}
		
		else{			
			dispatcher = request.getRequestDispatcher(servletRequest.getServletPath());			
		}
		
		 dispatcher.forward(request, response); 
	}

}
