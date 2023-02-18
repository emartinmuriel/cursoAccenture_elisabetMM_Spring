package es.rf.tienda.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import es.rf.tienda.dominio.Categoria;
@Service
public interface ICategoriaRepo extends JpaRepository<Categoria, Integer> {

}
