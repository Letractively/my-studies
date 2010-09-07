/**
 * 
 */
package br.com.fiapbank.persistencia.dao.db;

/**
 * @author robson.oliveira
 *
 */
public class DBManagerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5223330406471014511L;

	/**
	 * 
	 */
	public DBManagerException() {
	}

	/**
	 * @param message
	 */
	public DBManagerException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DBManagerException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DBManagerException(String message, Throwable cause) {
		super(message, cause);
	}

}
