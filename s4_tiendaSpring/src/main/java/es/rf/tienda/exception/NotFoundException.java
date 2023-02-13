package es.rf.tienda.exception;

public class NotFoundException extends RuntimeException{

	private static final String DESCRIPCION = "Error no encontrado (404)";
	
	public NotFoundException(String message) {
		super(DESCRIPCION + ". " + message);
		
	}
}
