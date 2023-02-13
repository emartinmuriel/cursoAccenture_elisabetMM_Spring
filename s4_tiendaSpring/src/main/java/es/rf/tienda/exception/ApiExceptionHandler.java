package es.rf.tienda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;

/**
 * La clase ApiExceptionHandler. Centraliza y maneja el tratamiento de
 * excepciones Java disparadas por una petición http, convirtiendolas en
 * excepciones Http que seran enviadas en el response de dicha peticion.
 * 
 * @author e.a.martin.muriel
 *
 */
@ControllerAdvice
public class ApiExceptionHandler {
	/**
	 * Metodo badRequest. Responde con un mesaje de error ante el desencadenamiento
	 * de alguna de las excepciones manejadas por el método.
	 * 
	 * @param request
	 * @param excepcion
	 * @return ErrorMessage
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ BadRequestException.class, DAOException.class, // Lista de Exception.class que dispararán la
																		// respuesta Http con la clase ErrorMessage
			org.springframework.dao.DuplicateKeyException.class,
			org.springframework.web.HttpRequestMethodNotSupportedException.class,
			org.springframework.web.bind.MethodArgumentNotValidException.class,
			org.springframework.web.bind.MissingRequestHeaderException.class,
			org.springframework.web.bind.MissingServletRequestParameterException.class,
			org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class,   //Exception por tipo de parametro no esperado en Request
			org.springframework.http.converter.HttpMessageNotReadableException.class })

	@ResponseBody
	public ErrorMessage badRequest(HttpServletRequest request, Exception excepcion) {
		return new ErrorMessage(excepcion, request.getRequestURI());
	}

	/**
	 * Metodo NotFoundRequest. Devuelve un mensaje de error producido por una
	 * excepción de tipo NotFound
	 * 
	 * @param request
	 * @param excepcion
	 * @return ErrorMessage
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ NotFoundException.class })
	@ResponseBody
	public ErrorMessage notFoundRequest(HttpServletRequest request, Exception excepcion) {
		return new ErrorMessage(excepcion, request.getRequestURI());
	}

	/**
	 * Metodo alreadyExists. Devuelve un mensaje de error producido por una
	 * excepción de tipo NotFound
	 * 
	 * @param request
	 * @param excepcion
	 * @return ErrorMessage
	 */
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler({ AlreadyExistException.class })
	@ResponseBody
	public ErrorMessage alreadyExists(HttpServletRequest request, Exception excepcion) {
		return new ErrorMessage(excepcion, request.getRequestURI());
	}
	/**
	 * Metodo unexpectedServerErr. Devuelve un mensaje de error producido por una
	 * excepción no controlada anteriormente.
	 * @param request
	 * @param excepcion
	 * @return
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public ErrorMessage unexpectedServerErr(HttpServletRequest request, Exception excepcion) {
		return new ErrorMessage(excepcion, request.getRequestURI());
	}
	
}
