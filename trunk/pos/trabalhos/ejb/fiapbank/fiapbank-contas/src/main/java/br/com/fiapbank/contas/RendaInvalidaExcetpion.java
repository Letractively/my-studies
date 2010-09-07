/**
 * 
 */
package br.com.fiapbank.contas;

/**
 * Lancada quando o renda nao passa pela avalicao 
 * 
 * @author robson
 *
 */
public class RendaInvalidaExcetpion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public RendaInvalidaExcetpion() {
	}

	/**
	 * @param message
	 */
	public RendaInvalidaExcetpion(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public RendaInvalidaExcetpion(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RendaInvalidaExcetpion(String message, Throwable cause) {
		super(message, cause);
	}

}
