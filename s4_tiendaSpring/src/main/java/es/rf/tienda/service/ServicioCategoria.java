package es.rf.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.repository.ICategoriaRepo;

/**
 * La clase Servicio Categoria
 * 
 * @author e.a.martin.muriel
 *
 */
@Service
public class ServicioCategoria implements IServicioCategoria<Categoria, Integer> {

	@Autowired
	private ICategoriaRepo cDao;

	@Override
	public boolean insert(Categoria t) {
		boolean ok = false;

		if (t.isValidInsert()) {
			t.setId_categoria(0);
			cDao.save(t);
			ok = true;
		}
		return ok;
	}

	@Override
	public boolean update(Categoria t) {
		boolean ok = false;
		if (t.isValidUpdate()) {
			if (cDao.existsById(t.getId_categoria())) {
				cDao.save(t);
				ok = true;
			}
		}
		
		return ok;
	}

	@Override
	public boolean deleteById(Integer id) {

		cDao.deleteById(id);
		return !cDao.existsById(id);

	}

	@Override
	public List<Categoria> listarTodos() {

		return cDao.findAll();
	}

	@Override
	public Categoria listaUno(Integer id) {

		return cDao.findById(id).get();
	}

}
