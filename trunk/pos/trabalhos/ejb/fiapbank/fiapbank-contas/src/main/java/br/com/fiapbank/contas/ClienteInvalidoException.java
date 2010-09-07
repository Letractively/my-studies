/**
 * 
 */
package br.com.fiapbank.contas;

/**
 *
 * Lancada quando o cliente de uma conta simples nao passa na validacoes
 * 
 * @author robson
 *
 */
public class ClienteInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ClienteInvalidoException() {
	}

	/**
	 * @param message
	 */
	public ClienteInvalidoException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ClienteInvalidoException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ClienteInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

}
