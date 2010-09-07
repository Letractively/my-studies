/**
 * 
 */
package br.com.fiapbank.negocio.autenticacao;

/**
 * @author robson.oliveira
 *
 */
public class InvalidFuncionarioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 970333106021521861L;

	/**
	 * 
	 */
	public InvalidFuncionarioException() {
	}

	/**
	 * @param message
	 */
	public InvalidFuncionarioException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidFuncionarioException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidFuncionarioException(String message, Throwable cause) {
		super(message, cause);
	}

}
