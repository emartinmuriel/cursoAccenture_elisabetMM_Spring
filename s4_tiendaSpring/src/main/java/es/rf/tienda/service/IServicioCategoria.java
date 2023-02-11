package es.rf.tienda.service;

import java.util.List;

import es.rf.tienda.beans.CategoriaResponse;
import es.rf.tienda.beans.MessageResponse;
import es.rf.tienda.dominio.Categoria;

public interface IServicioCategoria<T, N>  {

	public MessageResponse insert(T t);

	public MessageResponse update(T t);

	public MessageResponse deleteById(N n);

	public CategoriaResponse listarTodos();

	public CategoriaResponse listaUno(N n);
}
