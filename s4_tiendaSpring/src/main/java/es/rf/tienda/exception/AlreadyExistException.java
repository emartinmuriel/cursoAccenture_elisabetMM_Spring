package es.rf.tienda.exception;

public class AlreadyExistException extends DAOException{
	private static final String DESCRIPCION = "Error de Validacion ";
	

	public AlreadyExistException() {
		super(DESCRIPCION);
	}

	public AlreadyExistException(String message) {
		super(DESCRIPCION + ". " + message);
		
	}
}
