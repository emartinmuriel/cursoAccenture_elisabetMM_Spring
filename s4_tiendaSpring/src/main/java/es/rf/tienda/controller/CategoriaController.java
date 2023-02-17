package es.rf.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rf.tienda.beans.CategoriaResponse;
import es.rf.tienda.beans.MessageResponse;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.service.IServicioCategoria;

/**
 * Clase Categoria Controler
 * 
 * @author e.a.martin.muriel
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private IServicioCategoria categoriaService;

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaResponse> leerUno(@PathVariable("id") int id) {
		ResponseEntity response;
		CategoriaResponse res = categoriaService.listaUno(id);

		response = new ResponseEntity<CategoriaResponse>(res, HttpStatus.valueOf(res.getResponse().getStatus()));
		return response;

	}

	@GetMapping()
	public ResponseEntity<CategoriaResponse> listarTodos() {

		CategoriaResponse res = categoriaService.listarTodos();
		ResponseEntity response = new ResponseEntity<CategoriaResponse>(res, HttpStatus.valueOf(res.getResponse().getStatus()));

		return response;

	}

	@PostMapping()
	public ResponseEntity<MessageResponse> alta(@RequestBody Categoria c) {
		System.out.println(c.getCat_nombre());
		MessageResponse res = categoriaService.insert(c);
		ResponseEntity response = new ResponseEntity<MessageResponse>(res, HttpStatus.valueOf(res.getStatus()));

		return response;
	}

	@PutMapping()
	public ResponseEntity<MessageResponse> actualizar(@RequestBody Categoria c) {

		MessageResponse res = categoriaService.update(c);
		ResponseEntity response = new ResponseEntity<MessageResponse>(res, HttpStatus.valueOf(res.getStatus()));

		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> eliminar(@PathVariable("id") int id) {

		MessageResponse res = categoriaService.deleteById(id);
		ResponseEntity response = new ResponseEntity<MessageResponse>(res, HttpStatus.valueOf(res.getStatus()));

		return response;
	}

}
