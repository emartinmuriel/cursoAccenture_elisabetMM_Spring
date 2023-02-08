package es.rf.tienda.exception;

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
