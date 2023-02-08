package es.rf.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.repository.ICategoria;
/**
 * La Aplicación web Tienda Incienso. Proyecto TalentCampus Accenture
 * @author e.a.martin.muriel
 *
 */
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private ICategoria cDao;
	
	@GetMapping("/{id}")
	public Categoria leerUno (@PathVariable("id") int id) {
		return cDao.findById(id).get();
	}
	@GetMapping("/hola")
	public String[] saluda() {
		return new String[] {"200", "Hola caracola!!"};
	}
	@GetMapping()
	public List<Categoria> leerTodos(){
		return cDao.findAll();
	}
	@PostMapping()
	public String[] alta(@RequestBody Categoria c) {
		c.setId_categoria(1);
//		if (c.isValid()) {
			cDao.save(c);
			return new String[] {"200", "Registro guardado"};
//		}else {
//			return new String[] {"400", "Registro no guardado. Registro inválido"};
//		}
	}
	
	@PutMapping()
	public String[] actualizar(@RequestBody Categoria c) {
		c.setId_categoria(0);
		if (c.isValid()) {
			cDao.findById(c.getId_categoria()).get();
			return new String[] {"200", "Registro guardado"};
		}else {
			return new String[] {"400", "Registro no guardado. Registro inválido"};
		}	
	}

}
