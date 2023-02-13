package es.rf.tienda.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rf.tienda.beans.CategoriaResponse;
import es.rf.tienda.beans.MessageResponse;
import es.rf.tienda.constants.Constants;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.exception.NotFoundException;
import es.rf.tienda.repository.ICategoriaRepo;

/**
 * La clase Servicio Categoria.
 * 
 * @author e.a.martin.muriel
 *
 */
@Service
public class ServicioCategoria implements IServicioCategoria<Categoria, Integer> {

	@Autowired
	private ICategoriaRepo cDao;

	/**
	 * Metodo insert. Inserta un dato de tipo categoria en la BBDD.
	 * 
	 * @param Categoria
	 * @return MessageResponse
	 */
	@Override
	public MessageResponse insert(Categoria t) {

		MessageResponse mensaje = new MessageResponse();
		try {
			if (t.isValidInsert()) {
				t.setId_categoria(0);
				cDao.save(t);
				mensaje.setStatus(Constants.STATUSCODE_CREATED);
				mensaje.setMessage("Registro guardado");
			}
		} catch (Exception e) {
			mensaje.setStatus(Constants.STATUSCODE_BAD_REQUEST);
			mensaje.setMessage("Registro no valido, " + e.getMessage());
		}
		return mensaje;
	}

	/**
	 * Metodo update. Actualiza un dato de tipo categoria en la BBDD.
	 * 
	 * @param Categoria
	 * @return MessageResponse
	 */
	@Override
	public MessageResponse update(Categoria t) {

		MessageResponse mensaje = new MessageResponse();
		try {
			if (t.isValidUpdate()) {

				if (cDao.existsById(t.getId_categoria())) {
					cDao.save(t);
					mensaje.setStatus(Constants.STATUSCODE_CREATED);
					mensaje.setMessage("Registro guardado");
				}
			}
		} catch (Exception e) {
			mensaje.setStatus(Constants.STATUSCODE_BAD_REQUEST);
			mensaje.setMessage("Registro no valido, " + e.getMessage());
		}
		return mensaje;

	}

	/**
	 * Metodo update. Elimina un dato Categoria de la BBDD por su id.
	 * 
	 * @param Integer id
	 * @return MessageResponse
	 */
	@Override
	public MessageResponse deleteById(Integer id) {
		MessageResponse mensaje = new MessageResponse();
		try {
			cDao.deleteById(id);
			mensaje.setStatus(Constants.STATUSCODE_OK);
			mensaje.setMessage("Registro Eliminado");
		} catch (Exception e) {
			mensaje.setStatus(Constants.STATUSCODE_BAD_REQUEST);
			mensaje.setMessage("Error: El registro con el id indicado no existe");
		}
		return mensaje;
	}

	/**
	 * Metodo listraTodos. Lista todos los registros de Categoria en la BBDD
	 * 
	 * @return CategoriaResponse
	 */
	@Override
	public CategoriaResponse listarTodos() {

		CategoriaResponse res = new CategoriaResponse();
		MessageResponse mensaje = new MessageResponse();
		try {
			res.setDatos(cDao.findAll());

			mensaje.setStatus(Constants.STATUSCODE_OK);
			mensaje.setMessage("OK");

		} catch (Exception e) {
			mensaje.setStatus(Constants.STATUSCODE_BAD_REQUEST);
			mensaje.setMessage("Error: " + e.getMessage());
		} finally {
			res.setResponse(mensaje);
		}
		return res;
	}

	/**
	 * Metodo listraUno. Busca un registro en la BBDD por el id, y duelve los datos
	 * 
	 * @param Integer id
	 * @return CategoriaResponse
	 */
	@Override
	public CategoriaResponse listaUno(Integer id) {

		CategoriaResponse res = new CategoriaResponse();
		MessageResponse mensaje = new MessageResponse();
		
		if (id==0) {
			throw new NotFoundException("El id " + id + " no existe.");
		}
		
		try {
			res.addDatos(cDao.findById(id).get());

			mensaje.setStatus(Constants.STATUSCODE_OK);
			mensaje.setMessage("OK");

		} catch (Exception e) {
			mensaje.setStatus(Constants.STATUSCODE_NOT_FOUND);
			mensaje.setMessage("Error: " + e.getMessage());
		} finally {
			res.setResponse(mensaje);
		}
		return res;
	}

}
