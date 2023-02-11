package es.rf.tienda.exception;

/**
 * Clase DomainExceprion. Excepciones de validacion de datos en el dominio
 * 
 * @author e.a.martin.muriel
 *
 */
@SuppressWarnings("serial")
public class DomainException extends Exception {
	private String message;

	public DomainException() {

	}

	public DomainException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
