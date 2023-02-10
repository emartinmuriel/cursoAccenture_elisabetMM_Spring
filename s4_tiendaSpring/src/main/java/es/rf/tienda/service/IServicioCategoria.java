package es.rf.tienda.service;

import java.util.List;

import es.rf.tienda.dominio.Categoria;


public interface IServicioCategoria<T,N> {

	public boolean insert(T t);
	public boolean update(T t);
	public boolean deleteById(N n);
	public List<Categoria> listarTodos();
	public Categoria listaUno(N n);
}
