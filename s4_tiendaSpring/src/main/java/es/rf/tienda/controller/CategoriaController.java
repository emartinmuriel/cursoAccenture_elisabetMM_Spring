package es.rf.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.service.IServicioCategoria;

/**
 * Clase Categoria Controler
 * 
 * @author e.a.martin.muriel
 *
 */
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private IServicioCategoria categoriaService;

	@GetMapping("/{id}")
	public Categoria leerUno(@PathVariable("id") int id) {
		return categoriaService.listaUno(id);
	}

	@GetMapping("/hola")
	public String[] saludaServer() {
		return new String[] { "200", "Hola caracola!!" };
	}

	@GetMapping()
	public List<Categoria> listarTodos() {
		return categoriaService.listarTodos();
	}

	@PostMapping()
	public String[] alta(@RequestBody Categoria c) {

		if (categoriaService.insert(c)) {
			return new String[] { "200", "Registro guardado" };
		} else {
			return new String[] { "400", "Error: Registro no guardado. Registro inválido" };
		}
	}

	@PutMapping()
	public String[] actualizar(@RequestBody Categoria c) {
		if (categoriaService.update(c)) {
			return new String[] {"200", "Registro actualizado"};
		}else {
			return new String[] {"400", "ERROR: No se ha podido actualizar"};
		}
	}
	
	@DeleteMapping("/{id}")
	public String[] eliminar(@PathVariable("id") int id) {
		if (categoriaService.deleteById(id)) {
			return new String[] {"200", "Registro eliminado"};
		}else {
			return new String[] {"400", "ERROR: No se ha podido eliminar"};
		}
	} 

}
