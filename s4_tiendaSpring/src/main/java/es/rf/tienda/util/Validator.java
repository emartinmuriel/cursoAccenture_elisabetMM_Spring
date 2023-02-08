package es.rf.tienda.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/********************************************************************************************
 * NOMBRE: Validator.java
 * 
 * DESCRIPCION: Clase auxiliar para validar los datos que sean introducidos en
 * la aplicaci�n.
 * 
 * @version 30/01/2023
 * @author Elisabet Martin
 * 
 ******************************************************************************************/
public class Validator {

	
	private static final String CODPRODUCTO_PATTERN = "^[A-Z]{2}[\\d]{3}+$";
	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z,.:'nÑ]+$";

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	/**
	 * Patr�n para validar el email, evitando puntos finales antes de la @ y que
	 * solo contenga car�cteres alfanum�ricos
	 */
	private final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Permite verificar que un DNI cumple con el patr�n XX.XXX.XXX-L
	 */
	private final static String DNI_PATTERN = "\\d{2}\\.\\d{3}\\.\\d{3}-[a-zA-Z]";

	/**
	 * Permite validar un tel�fono, el cual debe contener de 10 a 20 d�gitos y donde
	 * los espacios est�n permitidos
	 */
	private final static String PHONE_PATTERN = "[\\d ]{10,20}";

	/**
	 * Orden de las letras con las cuales se comprobar� la validez del DNI
	 */
	private final static String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

	/**
	 * Longitud que debe tener todo DNI pasado a la aplicaci�n.
	 */
	private final static int LONGITUD_DNI = 12;

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: isAlfanumeric *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Permite verificar que el texto pasado solo contiene caracters alfanum�ricos
		 * 
		 * @param texto String a verificar que solo tenga car�cteres alfanum�ricos
		 * 
		 * @return true, si cumple solo contiene caracters alfanum�ricos. <br>
		 *         false en caso contrario FECHA: Enero 2023
		 * 
		 *         AUTOR: Elisabet Martin
		 * 
		 **************************************************************************************/
	public static boolean isAlfanumeric(String texto) {

		Pattern pattern = Pattern.compile(ALFANUMERIC_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(texto);
		return matcher.find();

	}

	/**
	 * Metodo isVacio
	 * 
	 * @param prueba
	 * @return boolean
	 */

	public static boolean isVacio(String prueba) {
		return prueba == null || prueba.isEmpty();

	}

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: cumplePhoneNumber *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * El phone number debe tener un total de entre 10 y 20, contando d�gitos y
		 * espacios. M�nimo aceptable son 10 d�gitos.
		 * 
		 * @param phoneNumber String con el n�mero de telefono de entre 10 y 20 d�gitos.
		 *                    Puede tener espacios, pero siempre con 10 d�gitos como
		 *                    m�nimo.
		 * 
		 * @return true, si cumple todas las condiciones
		 *
		 *         FECHA: Enero 2023 AUTOR: Elisabet Martin
		 * 
		 **************************************************************************************/
	public static boolean cumplePhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile(PHONE_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(phoneNumber);
		boolean valido = false;

		if (matcher.find()) { // Cumple la expresión regular: blancos+digitos>10 && blancos+digitos<20

			String soloDig = phoneNumber.replace(" ", "");
			if (soloDig.length() >= 10) {
				valido = true;
			}
		}

		return valido;

	}

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: isEmailValido *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Comprueba si el email tiene un formato que pueda ser v�lido.
		 * 
		 * @param email String a comprobar
		 * 
		 * @return true, en caso que el formato sea v�lido FECHA: Enero 2023
		 * 
		 *         AUTOR: Elisabet Martin
		 * 
		 **************************************************************************************/
	public static boolean isEmailValido(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: cumpleDNI *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Esta funci�n verifica que el DNI cumple el siguiente formato: xx.xxx.xxx-L
		 * <br>
		 * El DNI ha de tener longitud 12
		 * 
		 * @param dni String con DNI a ser validado
		 * 
		 * @return true, si el DNI cumple el estandar nacional. FECHA: Enero 2023 AUTOR:
		 *         Elisabet Martin
		 * 
		 **************************************************************************************/
	public static boolean cumpleDNI(String dni) {
		boolean valido = false;
		int num;
		String sNum = "";

		if (dni.matches(DNI_PATTERN)) { // Primer filtro-> cumple patrón

			for (int i = 0; i < LONGITUD_DNI - 2; i++) {
				if (Character.isDigit(dni.charAt(i))) { // Estraer los numéricos
					sNum += dni.charAt(i);
				}
			}

			num = Integer.parseInt(sNum); // Cast a entero

			if (LETRA_DNI.charAt(num % 23) == dni.charAt(LONGITUD_DNI - 1)) { // Compara la letra
				valido = true;
			}
		}

		return valido;

	}

	/**
	 * ***************************************************************************************
	 * NOMBRE: cumpleRango *
	 * 
	 * DESCRIPCI�N:
	 */
	/**
	 * Comprueba que un N�mero se necuentra entre 2 valores
	 * 
	 * @param valor       (int)/(double) N�mero a comprobar
	 * @param valorMinimo (int) N�mero valor aceptable
	 * @param valorMaximo (int) M�N�mero valor aceptable
	 * 
	 * @return true si valorMinimo > valor > valorMaximo FECHA: Enero 2023 AUTOR:
	 *         Elisabet Martin
	 * 
	 **************************************************************************************/
	public static boolean cumpleRango(int valor, int valorMinimo, int valorMaximo) {

		return valor >= valorMinimo && valor <= valorMaximo;

	}

	public static boolean cumpleRango(double valor, int valorMinimo, int valorMaximo) {

		return cumpleRango((int) valor, valorMinimo, valorMaximo);

	}

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: cumpleLongitudMin *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Comprobar que el texto pasado tiene una longitud de al menos x caracteres,
		 * siendo x el entero pasado como par�metro
		 * 
		 * @param texto          String texto a comprobar
		 * @param longitudMinima int que indique longitud m�nima.
		 * 
		 * @return cierto, si la longitud del texto es mayor o igual que longitudMinima
		 *         FECHA: Enero 2023 AUTOR: Elisabet Martin
		 * 
		 **************************************************************************************/
	public static boolean cumpleLongitudMin(String texto, int longitudMinima) {

		boolean cumple = false;
		if (texto.length() >= longitudMinima)
			cumple = true;
		return cumple;

	}

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: cumpleLongitudMax *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Comprobar que el texto pasado tiene una longitud de, como mucho, x
		 * caracteres, siendo x el entero pasado como par�metro
		 * 
		 * @param texto          String con el texto a comprobar
		 * @param longitudMaxima int con la longitud m�xima del texto
		 * 
		 * @return true, si el texto es menor o igual que la longitud m�xima. FECHA:
		 *         Enero 2023 AUTOR: Elisabet Martin
		 * 
		 **************************************************************************************/
	public static boolean cumpleLongitudMax(String texto, int longitudMaxima) {
		boolean cumple = false;
		if (texto.length() <= longitudMaxima)
			cumple = true;
		return cumple;

	}

	/****************************************************************************************
	 * NOMBRE: cumpleLongitud *
	 * 
	 * DESCRIPCI�N:
	 */
	/**
	 * Comprobar que la longitud de un texto se encuentra entre unos valores m�ximos
	 * y m�nimos
	 * 
	 * @param texto          String con el texto que a validar
	 * @param longitudMinima (int) M�nima longitud del texto
	 * @param longitudMaxima (int) M�xima longitud v�lida para el texo
	 * 
	 * @return true, si la longitud del texto cumple: longitudMinima <=
	 *         longitudTexto <=longitudMaxima FECHA: Enero 2023 AUTOR: Elisabet
	 *         Martin
	 * 
	 **************************************************************************************/
	public static boolean cumpleLongitud(String texto, int longitudMinima, int longitudMaxima) {
		boolean cumple = false;
		if (cumpleLongitudMax(texto, longitudMaxima) && cumpleLongitudMin(texto, longitudMinima))
			cumple = true;
		return cumple;

	}

	/**
	 * Valida una fecha calendar con m�nimo min
	 * 
	 * @param fecha
	 * @param min
	 * @return
	 */

	public static boolean valDateMin(LocalDate fecha, LocalDate min) {
		boolean valido = false;
		if (fecha.isAfter(min) || fecha.isEqual(min)) {
			valido = true;
		}
		return valido;

	}

	/**
	 * Valida una fecha calendar con m�ximo max
	 * 
	 * @param fecha
	 * @param max
	 * @return
	 */
	public static boolean valDateMax(LocalDate fecha, LocalDate max) {
		boolean valido = false;
		if (fecha.isBefore(max) || fecha.isEqual(max)) {
			valido = true;
		}
		return valido;

	}

	/**
	 * esFechaValida Recibe una string con formato fecha dd/mm/aaaa y comprueba el
	 * formato
	 * 
	 * @param fecha
	 * @return
	 */
	public static boolean esFechaValida(String fecha) {
		boolean valido = true;
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			LocalDate fechaNueva = LocalDate.parse(fecha, formatoFecha);
		} catch (DateTimeParseException e) {
			valido = false;
		}

		return valido;

	}

	/**
	 * Nombre esPasswordValida Descripcion Comprueba que la cadena recibida cumpla
	 * con lasnormas de contrase�a
	 * 
	 * @param password string con la contrase�a introducida
	 * @return true si cumple con las especificaciones
	 * 
	 *         Especificacion: Autor: Elisabet Martin
	 */
	public static boolean esPasswordValida(String password) {
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(password);
		return matcher.find();

	}
	
	/**
	 * El método esCodigoProductoValido. Comprueba que el código cumpla con el patrón. 
	 * Patron: AA000 (5char: 2 Letras mayúsculas+3 digitos.
	 * 
	 * @param password string con el código de Producto
	 * @return true si cumple con las especificaciones
	 * 
	 *         Especificacion: Autor: Elisabet Martin
	 */
	public static boolean esCodigoProductoValido(String codProducto) {
		return codProducto.matches(CODPRODUCTO_PATTERN);

	}

}
