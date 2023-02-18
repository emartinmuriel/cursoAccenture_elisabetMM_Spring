package es.rf.tienda.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.Closeable;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import es.rf.tienda.beans.CategoriaResponse;
import es.rf.tienda.beans.MessageResponse;
import es.rf.tienda.constants.Constants;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.repository.ICategoriaRepo;

class ServicioCategoriaTest {

	@Mock
	private ICategoriaRepo cDaoTest;
	@InjectMocks
	private ServicioCategoria categoriaService;
	
	private List<Categoria> listaCategorias;
	private CategoriaResponse catRes;
	private Optional<Categoria> cat;
	private MessageResponse mensajeResOk;
	private MessageResponse mensajeResBadRequest;
	private MessageResponse mensajeResCreated;
	private MessageResponse mensajeResNotFound;
	private final Integer ID_VALIDA = 3;
	private final Integer ID_NOT_EXIST = 0;

	@BeforeEach
	public void init() {

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
	void testListarTodos() {
	    when(cDaoTest.findAll()).thenReturn(listaCategorias);
	    doNothing().when(cDaoTest).findAll(); 
	    categoriaService.listarTodos();

	}
	@Test
	void testListaUno_OK() {

	    when(cDaoTest.findById(anyInt())).thenReturn(cat);
	    doNothing().when(cDaoTest).findById(anyInt()); 
	    categoriaService.listaUno(anyInt());
	    verify(cDaoTest).existsById(anyInt());
	    verify(cDaoTest).findById(anyInt());
	}
	@Disabled
	@Test
	void testInsert() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testDeleteById() {

	    when(cDaoTest.existsById(anyInt())).thenReturn(true);
	    doNothing().when(cDaoTest).deleteById(anyInt()); 
	    categoriaService.deleteById(anyInt());
	    verify(cDaoTest).existsById(anyInt());
	    verify(cDaoTest).deleteById(anyInt());
	}

	@Test
	 void testDeleteById_novalida() throws Exception {

		    // si:
		    when(cDaoTest.existsById(ID_NOT_EXIST)).thenReturn(false);

		    // responde:
		    Exception thrown = assertThrows(
		            Exception.class,
		            () -> categoriaService.deleteById(0),
		            "El id de la categoria a eliminar no existe en la base de datos");
		    // y entonces:
		    assertNotNull(thrown);
		    assertTrue(thrown.getMessage().contains("La categoria no existe"));
		  }



}
