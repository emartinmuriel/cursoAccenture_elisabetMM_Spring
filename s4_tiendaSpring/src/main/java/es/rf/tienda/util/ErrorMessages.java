package es.rf.tienda.util;


/**
 * NOMBRE: ErrorMessages.java
 * 
 * DESCRIPCION:  
 * 			Clase con los String que contienen los mensajes de error 
 * 			especificados por las reglas de negocio.
 * 
 * @author e.a.martin.muriel
 *
 */
public class ErrorMessages {
	
	
		
	/**
	 * Codigo de producto
	 */
	public final static String PROERR_001 = "Formato codigo erroneo";
	public final static String PROERR_002 = "Longitud de codigo erroneo";
	
	/**
	 * Campo con longitud erronea
	 */
	public final static String PROERR_003 = "La longitud de ? ha de estar entre ? y ?";
	public static final String CATERR_LONG_NOMBRE =" Error: El nombre de categoria debe contener entre 5 y 50 caracteres.";
	
	public static final String USUERR_EMAIL = "Error: El email introducido no es válido.";
	public static final String USUERR_PASSWORD = "Error: La contraseña ha de tener minimo 8 caracteres, un numero,una mayuscula, una minuscula";
	public static final String USUERR_DNI = "Error: DNI no válido. El formato ha de ser XX.XXX.XXX-L";
	public static final String USUERR_FECHA_PASADA = "Error: Fecha no válida. La fecha no puede ser posterior";
	public static final String USUERR_FECHA_ANTERIOR = "Error: Fecha no válida. La fecha no puede ser anterior.";
	public static final String ERR_NULL = "Error: El campo no puede ser nulo";
	
	

}
