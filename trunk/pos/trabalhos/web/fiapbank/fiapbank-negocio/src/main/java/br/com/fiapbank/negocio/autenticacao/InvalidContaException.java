/**
 * 
 */
package br.com.fiapbank.negocio.autenticacao;

/**
 * @author robson.oliveira
 *
 */
public class InvalidContaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9114131549258275613L;

	/**
	 * 
	 */
	public InvalidContaException() {
	}

	/**
	 * @param message
	 */
	public InvalidContaException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidContaException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidContaException(String message, Throwable cause) {
		super(message, cause);
	}

}
