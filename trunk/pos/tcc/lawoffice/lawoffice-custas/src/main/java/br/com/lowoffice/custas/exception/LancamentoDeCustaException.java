/**
 * 
 */
package br.com.lowoffice.custas.exception;

/**
 * 
 * Exceção para os serviços de lacamento de custas
 * 
 * @author robson
 * 
 * @see  {@link Exception} {@link CustasException}
 *
 */
public class LancamentoDeCustaException extends CustasException {
	
	private static final long serialVersionUID = 8075648092307954164L;
	

	public LancamentoDeCustaException() {
	}


	public LancamentoDeCustaException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public LancamentoDeCustaException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public LancamentoDeCustaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
