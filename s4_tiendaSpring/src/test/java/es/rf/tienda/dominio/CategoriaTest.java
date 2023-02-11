package es.rf.tienda.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import es.rf.tienda.exception.DomainException;

class CategoriaTest {
	static final String ERROR_LONG_DESCRIPCION_MAX = "Esta cadena va a ser una ejemplo de descripción que sobrepasa el rango de caracteres permitidos para la descripción. Este texto tiene más de 200 caracteres. Este texto tiene más de 200 caracteres.Este texto tiene más de 200 caracteres";
	static final String ERROR_LONG_DESCRIPCION_MIN = "";
	static final String ERROR_NULL = null;
	static final String OK_LONG_DESCRIPCION = "Esta descripcion es valida";
	static final String ERROR_LONG_NOMBRE_MAX = "Error: maxima longitud excedida. 50 caracteres hay";
	static final String ERROR_LONG_NOMBRE_MIN = "Cinco";
	static final String OK_LONG_NOMBRE = "";
	Categoria categoria = new Categoria();

	@Disabled
	@Test
	void testGetId_categoria_ok() {
//		categoria.setCat_descripcion(OK_LONG_DESCRIPCION));
//		assertNotNull(categoria.getCat_descripcion());

	}

	@Test
	void testSetCat_nombre() {
		
	}

	@Test
	void testSetCat_nombre_error_1() {
		Exception exception = assertThrows(DomainException.class, () -> {
			categoria.setCat_nombre(ERROR_LONG_NOMBRE_MAX);
		});
	}

	@Test
	void testSetCat_nombre_error_2() {
		Exception exception = assertThrows(DomainException.class, () -> {
			categoria.setCat_nombre(ERROR_LONG_NOMBRE_MIN);
		});
	}
	@Test
	void testSetCat_nombre_NOok() {
		Exception exception = assertThrows(DomainException.class, () -> {
			categoria.setCat_nombre("correcto");
		});
	}

	@Test
	void testIsValidInsert() throws DomainException{
		categoria.setCat_nombre("correcto");
		assertTrue(categoria.isValidInsert());
	}


	@Test
	void testSetCat_descripcion_ok_NULL() {
		categoria.setCat_descripcion(ERROR_NULL);
		assertNull(categoria.getCat_descripcion());
	}



}
