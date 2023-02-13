package es.rf.tienda.exception;

/**
 * Clase DomainExceprion. Excepciones de validacion de datos en el dominio
 * 
 * @author e.a.martin.muriel
 *
 */
@SuppressWarnings("serial")
public class DomainException extends BadRequestException {
	private static final String DESCRIPCION = "Error de Validacion ";
	

	public DomainException() {
		super(DESCRIPCION);
	}

	public DomainException(String message) {
		super(DESCRIPCION + ". " + message);
		
	}

}
