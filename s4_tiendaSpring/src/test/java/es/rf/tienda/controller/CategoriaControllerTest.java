package es.rf.tienda.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc; 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import es.rf.tienda.beans.CategoriaResponse;
import es.rf.tienda.beans.MessageResponse;
import es.rf.tienda.constants.Constants;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.service.ServicioCategoria;

@WebMvcTest(CategoriaController.class)
class CategoriaControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ServicioCategoria categoriaService;;

	private CategoriaResponse catRes;
	private MessageResponse mensajeResOk;
	private MessageResponse mensajeResBadRequest;
	private MessageResponse mensajeResCreated;
	private MessageResponse mensajeResNotFound;
	private final int ID_VALIDA = 3;
	private final int ID_NOT_EXIST = 0;

	@BeforeEach

	public void init() {

		categoriaService = new ServicioCategoria();
		catRes = new CategoriaResponse();
		// OK
		mensajeResOk = new MessageResponse();
		mensajeResOk.setStatus(Constants.STATUSCODE_OK);

		// BAD_REQUEST
		mensajeResBadRequest = new MessageResponse();
		mensajeResBadRequest.setStatus(Constants.STATUSCODE_BAD_REQUEST);

		// CREATED
		mensajeResCreated = new MessageResponse();
		mensajeResCreated.setStatus(Constants.STATUSCODE_CREATED);

		// NOT FOUND
		mensajeResNotFound = new MessageResponse();
		mensajeResNotFound.setStatus(Constants.STATUSCODE_NOT_FOUND);
	}

	@Test
	void testLeerUno_OK() throws Exception{
		Categoria cat = new Categoria();
		cat.setCat_nombre("testCategoria");
		cat.setCat_descripcion("testCategoriatestCategoria");
		
		
		when(categoriaService.listaUno(ID_VALIDA)).thenReturn((catRes));
		
		mockMvc.perform(get("/categorias/3").contentType(MediaType.APPLICATION_JSON));
	
		verify(categoriaService.listaUno(ID_VALIDA));
	}

	@Disabled
	@Test
	void testListarTodos() {
		
	}

	@Disabled
	@Test
	void testAlta() {
		
	}

	@Disabled
	@Test
	void testActualizar() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testEliminar() {
		fail("Not yet implemented");
	}

}
