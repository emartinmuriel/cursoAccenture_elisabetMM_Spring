package es.rf.tienda.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.rf.tienda.dominio.Categoria;

public interface ICategoriaRepo extends JpaRepository<Categoria, Integer> {

}
