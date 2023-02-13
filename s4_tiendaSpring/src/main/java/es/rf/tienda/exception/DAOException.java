package es.rf.tienda.exception;

/**
 * Clase DAOException. Excepciones de tipo DAO
 * 
 * @author e.a.martin.muriel
 *
 */
@SuppressWarnings("serial")
public class DAOException extends RuntimeException {

	private static final String DESCRIPCION = "Error DAO ";
	
	public DAOException(String message) {
		super(DESCRIPCION + ". " + message);
		
	}
}
