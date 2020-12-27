package pe.edu.cibertec.proyectobcp.services;

import java.util.List;
import java.util.Optional;

import pe.edu.cibertec.proyectobcp.model.Campanas;

public interface CampanasService {

	Campanas registrar(Campanas campanas);
	
	Campanas actualizar(Campanas campanas);
	
	void eliminar(Long id);
	
	Optional<Campanas> obtenerPorId(Long id);
	
	List<Campanas> obtenerCampanas();
	
}
