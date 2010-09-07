/**
 * 
 */
package br.com.fiapfuncionarios.gerenciamento;

/**
 * @author robson
 *
 */
public class EntidadeInvalidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8992040793794175703L;

	/**
	 * 
	 */
	public EntidadeInvalidaException() {
	}

	/**
	 * @param arg0
	 */
	public EntidadeInvalidaException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public EntidadeInvalidaException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public EntidadeInvalidaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
