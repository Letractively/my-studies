/**
 * 
 */
package br.com.fiapbank.contas;

/**
 * 
 * Lancada quando ocorre algum problema na validacao da conta
 * 
 * @author robson.oliveira
 *
 */
public class ContaInvalidaExcetpion extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4218598933755234627L;


	/**
	 * 
	 */
	public ContaInvalidaExcetpion() {
	}

	/**
	 * @param message
	 */
	public ContaInvalidaExcetpion(String message) {
		super(message);
	}

	
	/**
	 * @param cause
	 */
	public ContaInvalidaExcetpion(Throwable cause) {
		super(cause);
	}

	
	/**
	 * @param message
	 * @param cause
	 */
	public ContaInvalidaExcetpion(String message, Throwable cause) {
		super(message, cause);
	}

}
