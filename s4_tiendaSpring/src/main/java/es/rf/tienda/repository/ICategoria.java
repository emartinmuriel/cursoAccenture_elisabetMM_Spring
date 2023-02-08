package es.rf.tienda.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import es.rf.tienda.dominio.Categoria;

public interface ICategoria extends JpaRepository<Categoria, Integer> {

}
