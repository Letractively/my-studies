/**
 * 
 */
package br.com.fiapbank.negocio;

/**
 * @author robson
 *
 */
public class NegocioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 66147209177943831L;

	/**
	 * 
	 */
	public NegocioException() {
	}

	/**
	 * @param arg0
	 */
	public NegocioException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public NegocioException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public NegocioException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
