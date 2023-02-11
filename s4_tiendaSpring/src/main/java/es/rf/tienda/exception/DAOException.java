package es.rf.tienda.exception;

/**
 * Clase DAOException. Excepciones de tipo DAO
 * 
 * @author e.a.martin.muriel
 *
 */
@SuppressWarnings("serial")
public class DAOException extends Exception {

	private String message;

	public DAOException() {

	}

	public DAOException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
