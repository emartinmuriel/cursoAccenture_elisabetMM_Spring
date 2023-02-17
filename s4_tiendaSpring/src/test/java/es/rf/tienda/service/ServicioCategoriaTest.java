package es.rf.tienda.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.Closeable;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

	@InjectMocks
	private ServicioCategoria categoriaService;
	@Mock
	ICategoriaRepo cDaoTest;

	private static AutoCloseable closeable;
	private CategoriaResponse catRes;
	private Categoria cat;
	private MessageResponse mensajeResOk;
	private MessageResponse mensajeResBadRequest;
	private MessageResponse mensajeResCreated;
	private MessageResponse mensajeResNotFound;
	private final Integer ID_VALIDA = 3;
	private final Integer ID_NOT_EXIST = 0;


	
    @BeforeAll public static void openMocks() {
 //     closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterAll public void releaseMocks() throws Exception {
       closeable.close();
    }
	
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
	void testLeerUno_OK() {
		
		Mockito.when(categoriaService.listaUno(Mockito.anyInt())).thenReturn(catRes);
		
	}

	@Test
	void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	void testListarTodos() {
		fail("Not yet implemented");
	}

	@Test
	void testListaUno() {
		fail("Not yet implemented");
	}

}
