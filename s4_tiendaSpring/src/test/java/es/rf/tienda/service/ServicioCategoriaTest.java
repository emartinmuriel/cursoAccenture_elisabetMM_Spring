package es.rf.tienda.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import es.rf.tienda.exception.BadRequestException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.repository.ICategoriaRepo;

class ServicioCategoriaTest {

	private ICategoriaRepo cDaoTest = Mockito.mock(ICategoriaRepo.class);
	private ServicioCategoria categoriaService = Mockito.mock(ServicioCategoria.class);

	private List<Categoria> listaCategorias;
	private CategoriaResponse catRes;
	private Optional<Categoria> catOptional;
	private Categoria cat;
	private MessageResponse mensajeResOk;
	private MessageResponse mensajeResBadRequest;
	private MessageResponse mensajeResCreated;
	private MessageResponse mensajeResNotFound;
	private final Integer ID_VALIDA = 3;
	private final Integer ID_NOT_EXIST = 0;

	@BeforeEach
	public void init() {

		catRes = new CategoriaResponse();
		cat = new Categoria();
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
	    when(categoriaService.listarTodos()).thenReturn(catRes);
	}

	@Test
	void testListaUno_OK() {

		when(cDaoTest.findById(anyInt())).thenReturn(catOptional);
		when(categoriaService.listaUno(anyInt())).thenReturn(catRes);
	}
	
	@Disabled
	@Test
	void testInsert_BADREQUEST_ERR_NULL() throws NullPointerException{
		cat.setId_categoria(0);
		cat.setCat_nombre(null);
		cat.setCat_descripcion("El nombre no puede ser nulo");
		
		when(cDaoTest.save(cat)).thenThrow(new NullPointerException());
		when(categoriaService.insert(cat)).thenThrow(new NullPointerException());
	}
	
	@Disabled
	@Test
	void testInsert_BADREQUEST_ERR_LONG() throws RuntimeException{
		cat.setId_categoria(0);
		cat.setCat_nombre("Mal");
		cat.setCat_descripcion("El nombre no puede tener longitud inferior a 5 caracteres");
		
		when(cDaoTest.save(cat)).thenThrow(new RuntimeException());
		when(categoriaService.insert(cat)).thenThrow(new RuntimeException());
	}

	@Test
	void testInsert_CREATED() {
		cat.setId_categoria(0);
		cat.setCat_nombre("CAT-OK");
		cat.setCat_descripcion("");
	    when(cDaoTest.save(cat)).thenReturn(cat);
	    when(categoriaService.insert(cat)).thenReturn(mensajeResCreated);
	}

	@Test
	void testUpdate_OK() {
		cat.setId_categoria(4);
		cat.setCat_nombre("CAT-OK");
		cat.setCat_descripcion("Esta categoria se actualizará correctamente.");
		when(cDaoTest.save(cat)).thenReturn(cat);
		when(categoriaService.update(cat)).thenReturn(mensajeResOk);
	}
	@Disabled
	@Test
	void testUpdate_BADREQUEST_ERR_LONG () {
		cat.setId_categoria(3);
		cat.setCat_nombre("mal");
		cat.setCat_descripcion("Esta categoria no se actualizará");
		when(cDaoTest.save(cat)).thenReturn(cat);
		when(categoriaService.update(cat)).thenReturn(mensajeResOk);
	}
	@Disabled
	@Test
	void testUpdatet_BADREQUEST_ERR_NULL() {
		cat.setId_categoria(3);
		cat.setCat_nombre(null);
		cat.setCat_descripcion("Esta categoria no se actualizará");
		when(cDaoTest.save(cat)).thenReturn(cat);
		when(categoriaService.update(cat)).thenReturn(mensajeResOk);
	}

	@Test
	void testDeleteById() {
	    when(cDaoTest.existsById(anyInt())).thenReturn(true);
	    doNothing().when(cDaoTest).deleteById(anyInt());  
	    when(categoriaService.deleteById(anyInt())).thenReturn(mensajeResOk);
	}

	@Test
	void testDeleteById_NOOK() {
	    when(cDaoTest.existsById(anyInt())).thenReturn(false);
	    doNothing().when(cDaoTest).deleteById(anyInt());  
	    when(categoriaService.deleteById(anyInt())).thenReturn(mensajeResBadRequest);
	}

}
