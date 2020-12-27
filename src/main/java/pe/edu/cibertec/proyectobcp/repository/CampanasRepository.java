package pe.edu.cibertec.proyectobcp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyectobcp.model.Campanas;

@Repository
public interface CampanasRepository extends CrudRepository<Campanas, Long> {

}
