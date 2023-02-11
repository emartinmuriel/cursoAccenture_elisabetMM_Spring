package es.rf.tienda.beans;

import java.util.ArrayList;
import java.util.List;

import es.rf.tienda.dominio.Categoria;

public class CategoriaResponse {
	
	private List<Categoria> datos = new ArrayList<>();
	private MessageResponse response;
	
	
	public List<Categoria> getDatos() {
		return datos;
	}
	public void setDatos(List<Categoria> datos) {
		this.datos = datos;
	}
	public MessageResponse getResponse() {
		return response;
	}
	public void setResponse(MessageResponse response) {
		this.response = response;
	}
	
	public void addDatos(Categoria categoria) {
		this.datos.add(categoria);
		
	}
	
}
