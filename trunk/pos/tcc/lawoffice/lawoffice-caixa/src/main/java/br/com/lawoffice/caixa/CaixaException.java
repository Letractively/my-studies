/**
 * 
 */
package br.com.lawoffice.caixa;

/**
 * Exceção para para os serviços de caixa
 * 
 * @author robson
 *
 */
public class CaixaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2512949150425120609L;

	/**
	 * 
	 */
	public CaixaException() {
	}

	/**
	 * @param arg0
	 */
	public CaixaException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public CaixaException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public CaixaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
