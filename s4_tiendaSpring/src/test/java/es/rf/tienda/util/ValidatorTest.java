package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class ValidatorTest {

	final String ALFANUMERICO_TRUE = "dfkdfkj2323232323";
	final String ALFANUMERICO_FALSE = "\"dfkdfkj2232323-$\"";
	final String STRING_VACIO_TRUE = "";
	final String STRING_VACIO_TRUE_NULL = null;
	final String STRING_VACIO_FALSE = "Esta cadena no está vacia";
	final String TELEFONO_VALIDO1 = "616 11 11 170";
	final String TELEFONO_VALIDO2 = "6161111170";
	final String TELEFONO_VALIDO3 = "616 11 11 17345";
	final String TELEFONO_ERR_NODIGITOS = "1234467ejm8910";
	final String TELEFONO_ERR_CORTO = "123446789";
	final String TELEFONO_ERR_CORTO2 = "1 2 3 4 5 6 7 8   ";
	final String TELEFONO_ERR_LARGO = "1234467891012345678901234567890";
	final String EMAIL_VALIDO1 = "foo@goo.com";
	final String EMAIL_VALIDO2 = "foo.es@foo.es";
	final String EMAIL_ERR1 = "foo.esfoo.es";
	final String EMAIL_ERR2 = "@foo.es";
	final String EMAIL_ERR3 = "foo.es@";
	final String EMAIL_ERR4 = "@";
	final String EMAIL_ERR5_NOPUNTO = "foo@goo";
	final String EMAIL_ERR6_PUNTO = "foo@goo.";
	final int INT_1 = 1;
	final int INT_3 = 3;
	final int INT_9 = 9;
	final double DOUBLE_1 = 1.0;
	final double DOUBLE_3 = 3.0;
	final double DOUBLE_9 = 9.0;

	final String DNI_VALIDO = "28.793.108-Y";
	final String DNI_ERROR_PATRON = "28793108-Y";
	final String DNI_ERROR_LETRA = "28.793.108-J";
	final String CAD_5 = "Cinco";
	final String CAD_1 = "Uno";
	final String CAD_ERROR_LONGITUD = "Pero esta cadena de excede";
	final String CAD_VACIA = "";
	final String FECHA_VALIDA = "25/04/2005";
	final String FECHA_ERROR1 = "25/04/05";
	final String FECHA_ERROR2 = "25/4/05";
	final String FECHA_ERROR3 = "25-04-2005";
	final String FECHA_ERROR4 = "2005/05/04";

	final String PWD_VALIDA = "Contra@VA123";
	final String PWD_ERROR1_NO_CHAR_ESP = "ContraVA123";
	final String PWD_ERROR2_NO_CAP = "contra_va123";
	final String PWD_ERROR3_NO_DIG = "Contra_VAddsj";

	final String CODPROD_VALIDO = "AA000";
	final String CODPROD_ERROR1 = "Aa000";
	final String CODPROD_ERROR2 = "A1239";
	final String CODPROD_ERROR3 = "$A1239";
	final String CODPROD_ERROR5_LARGO = "AA0000";
	final String CODPROD_ERROR4_CORTO = "AA00";

	LocalDate fecha1 = LocalDate.now();
	LocalDate fecha2 = LocalDate.now().plusMonths(INT_3);
	LocalDate fecha3 = LocalDate.now().plusMonths(INT_9);

	@Test
	void testIsAlfanumeric1() {

		assertTrue(Validator.isAlfanumeric(ALFANUMERICO_TRUE));
	}

	@Test
	void testIsAlfanumeric2() {
		assertFalse(Validator.isAlfanumeric(ALFANUMERICO_FALSE));
	}

	@Test
	void testIsVacio() {
		assertTrue(Validator.isVacio(STRING_VACIO_TRUE));
	}

	@Test
	void testIsVacio2() {
		assertTrue(Validator.isVacio(STRING_VACIO_TRUE_NULL));
	}

	@Test
	void testIsVacio3() {
		assertFalse(Validator.isVacio(STRING_VACIO_FALSE));
	}

	@Test
	void testCumplePhoneNumber1() {
		assertTrue(Validator.cumplePhoneNumber(TELEFONO_VALIDO1));
	}

	@Test
	void testCumplePhoneNumber2() {
		assertTrue(Validator.cumplePhoneNumber(TELEFONO_VALIDO2));
	}

	@Test
	void testCumplePhoneNumber3() {
		assertTrue(Validator.cumplePhoneNumber(TELEFONO_VALIDO3));
	}

	@Test
	void testCumplePhoneNumber4() {

		assertFalse(Validator.cumplePhoneNumber(TELEFONO_ERR_NODIGITOS));
	}

	@Test
	void testCumplePhoneNumber5() {

		assertFalse(Validator.cumplePhoneNumber(TELEFONO_ERR_CORTO));
	}

	@Test
	void testCumplePhoneNumber6() {

		assertFalse(Validator.cumplePhoneNumber(TELEFONO_ERR_CORTO2));
	}

	@Test
	void testIsEmailValido_1() {
		assertTrue(Validator.isEmailValido(EMAIL_VALIDO1));
	}

	@Test
	void testIsEmailValido_2() {
		assertTrue(Validator.isEmailValido(EMAIL_VALIDO2));
	}

	@Test
	void testIsEmailValido_3() {
		assertFalse(Validator.isEmailValido(EMAIL_ERR1));
	}

	@Test
	void testIsEmailValido_4() {
		assertFalse(Validator.isEmailValido(EMAIL_ERR2));
	}

	@Test
	void testIsEmailValido_5() {
		assertFalse(Validator.isEmailValido(EMAIL_ERR3));
	}

	@Test
	void testIsEmailValido_6() {
		assertFalse(Validator.isEmailValido(EMAIL_ERR4));
	}

	@Test
	void testIsEmailValido_7() {
		assertFalse(Validator.isEmailValido(EMAIL_ERR5_NOPUNTO));
	}

	@Test
	void testIsEmailValido_8() {
		assertFalse(Validator.isEmailValido(EMAIL_ERR6_PUNTO));
	}

	@Test
	void testCumpleDNI_True() {

		assertTrue(Validator.cumpleDNI(DNI_VALIDO));
		assertFalse(Validator.cumpleDNI(DNI_ERROR_LETRA));
		assertFalse(Validator.cumpleDNI(DNI_ERROR_PATRON));
	}

	@Test
	void testCumpleDNI_False() {

		assertFalse(Validator.cumpleDNI(DNI_ERROR_LETRA));
	}

	@Test
	void testCumpleDNI_False2() {

		assertFalse(Validator.cumpleDNI(DNI_ERROR_PATRON));
	}

	@Test
	void testCumpleRangoIntIntInt_1() {
		assertTrue(Validator.cumpleRango(INT_3, INT_1, INT_9));
	}

	@Test
	void testCumpleRangoIntIntInt_2() {
		assertTrue(Validator.cumpleRango(INT_3, INT_3, INT_3));
	}

	@Test
	void testCumpleRangoIntIntInt_3() {
		assertFalse(Validator.cumpleRango(INT_1, INT_3, INT_9));
	}

	@Test
	void testCumpleRangoIntIntInt_4() {
		assertFalse(Validator.cumpleRango(INT_9, INT_1, INT_3));
	}

	@Test
	void testCumpleRangoDoubleIntInt_1() {
		assertTrue(Validator.cumpleRango(DOUBLE_3, INT_1, INT_9));
	}

	@Test
	void testCumpleRangoDoubleIntInt_2() {
		assertTrue(Validator.cumpleRango(DOUBLE_3, INT_3, INT_3));
	}

	@Test
	void testCumpleRangoDoubleIntInt_3() {
		assertFalse(Validator.cumpleRango(DOUBLE_1, INT_3, INT_9));
	}

	@Test
	void testCumpleRangoDoubleIntInt_4() {
		assertFalse(Validator.cumpleRango(DOUBLE_9, INT_1, INT_3));
	}

	@Test
	void testCumpleLongitudMin_true1() {

		assertTrue(Validator.cumpleLongitudMin(CAD_5, INT_3));

	}

	@Test
	void testCumpleLongitudMin_true2() {

		assertTrue(Validator.cumpleLongitudMin(CAD_1, INT_3));

	}

	@Test
	void testCumpleLongitudMin_false() {

		assertFalse(Validator.cumpleLongitudMin(CAD_1, INT_9));
	}

	@Test
	void testCumpleLongitudMax() {

		assertTrue(Validator.cumpleLongitudMax(CAD_5, INT_9));

	}

	@Test
	void testCumpleLongitudMax_true2() {

		assertTrue(Validator.cumpleLongitudMax(CAD_1, INT_3));

	}

	@Test
	void testCumpleLongitudMax_false() {

		assertFalse(Validator.cumpleLongitudMax(CAD_ERROR_LONGITUD, INT_9));
	}

	@Test
	void testCumpleLongitud_true1() {

		assertTrue(Validator.cumpleLongitud(CAD_5, INT_1, INT_9));

	}

	@Test
	void testCumpleLongitud_true2() {

		assertTrue(Validator.cumpleLongitud(CAD_1, INT_3, INT_3));

	}

	@Test
	void testCumpleLongitud_false1() {

		assertFalse(Validator.cumpleLongitud(CAD_ERROR_LONGITUD, INT_1, INT_9));

	}

	@Test
	void testCumpleLongitud_false2() {

		assertFalse(Validator.cumpleLongitud(CAD_VACIA, INT_1, INT_9));
	}

	@Test
	void testValDateMin() {

		assertTrue(Validator.valDateMin(fecha2, fecha1));
	}

	@Test
	void testValDateMin_2() {
		assertTrue(Validator.valDateMin(fecha2, fecha2));
	}

	@Test
	void testValDateMin_3() {
		assertFalse(Validator.valDateMin(fecha1, fecha2));
	}

	@Test
	void testValDateMax() {
		assertTrue(Validator.valDateMax(fecha1, fecha3));
	}

	@Test
	void testValDateMax2() {
		assertTrue(Validator.valDateMax(fecha2, fecha2));
	}

	@Test
	void testValDateMax3() {
		assertFalse(Validator.valDateMax(fecha2, fecha1));
	}

	@Test
	void testEsFechaValida() {
		assertTrue(Validator.esFechaValida(FECHA_VALIDA));
	}

	@Test
	void testEsFechaValida2() {
		assertTrue(Validator.esFechaValida(FECHA_VALIDA));
	}

	@Test
	void testEsFechaValida3() {
		assertFalse(Validator.esFechaValida(FECHA_ERROR1));
	}

	@Test
	void testEsFechaValida4() {
		assertFalse(Validator.esFechaValida(FECHA_ERROR2));
	}

	@Test
	void testEsFechaValida5() {
		assertFalse(Validator.esFechaValida(FECHA_ERROR3));
	}

	@Test
	void testEsPasswordValida() {
		assertTrue(Validator.esPasswordValida(PWD_VALIDA));
	}

	@Test
	void testEsPasswordValida2() {
		assertFalse(Validator.esFechaValida(PWD_ERROR1_NO_CHAR_ESP));
	}

	@Test
	void testEsPasswordValida3() {
		assertFalse(Validator.esFechaValida(PWD_ERROR2_NO_CAP));
	}

	@Test
	void testEsPasswordValida4() {
		assertFalse(Validator.esFechaValida(PWD_ERROR3_NO_DIG));
	}

	@Test
	void testEsCodigoProductoValido1() {
		assertTrue(Validator.esCodigoProductoValido(CODPROD_VALIDO));
	}

	@Test
	void testEsCodigoProductoValido2() {
		assertFalse(Validator.esCodigoProductoValido(CODPROD_ERROR1));
		assertFalse(Validator.esCodigoProductoValido(CODPROD_ERROR2));
		assertFalse(Validator.esCodigoProductoValido(CODPROD_ERROR3));
		assertFalse(Validator.esCodigoProductoValido(CODPROD_ERROR4_CORTO));
		assertFalse(Validator.esCodigoProductoValido(CODPROD_ERROR5_LARGO));

	}

}
