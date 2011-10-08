package br.com.mystudies.jsf.composite.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.com.mystudies.jsf.composite.transacao.Transacao;

/**
 * Servlet Filter implementation class TransacoesFilter
 */
public class TransacoesFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TransacoesFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		List<Transacao> transacoes = new ArrayList<Transacao>();
		transacoes.add( new Transacao("B100"));
		transacoes.add( new Transacao("B101"));
		transacoes.add( new Transacao("B102"));
		transacoes.add( new Transacao("B103"));
		transacoes.add( new Transacao("B104"));
		
		
		// features 
		Map<String, Boolean> features  = new HashMap<String, Boolean>(); 
		
		features.put("B100", true);
		features.put("B101", false);
		
		request.setAttribute("transacoes", transacoes);
		request.setAttribute("features", features);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
