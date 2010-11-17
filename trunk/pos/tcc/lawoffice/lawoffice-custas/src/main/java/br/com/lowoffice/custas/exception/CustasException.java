/**
 * 
 */
package br.com.lowoffice.custas.exception;

/**
 * 
 * Classe base de exceções para o módulo de custas
 * 
 * @author robson
 * 
 * @see Exception
 *
 */
public class CustasException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1574116134496011763L;

	

	public CustasException() {
	}


	public CustasException(String message) {
		super(message);
	}


	public CustasException(Throwable cause) {
		super(cause);
	}


	public CustasException(String message, Throwable cause) {
		super(message, cause);
	}

}
