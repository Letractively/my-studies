/**
 * 
 */
package br.com.fiapbank.contas;

/**
 * 
 * @author robson.oliveira
 *
 */
public class GerenciadorDeContasException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3244821723778032956L;

	/**
	 * 
	 */
	public GerenciadorDeContasException() {
	}

	/**
	 * @param message
	 */
	public GerenciadorDeContasException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public GerenciadorDeContasException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public GerenciadorDeContasException(String message, Throwable cause) {
		super(message, cause);
	}

}
