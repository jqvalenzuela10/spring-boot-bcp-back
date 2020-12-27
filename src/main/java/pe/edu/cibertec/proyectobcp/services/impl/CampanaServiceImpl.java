package pe.edu.cibertec.proyectobcp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.proyectobcp.model.Campanas;
import pe.edu.cibertec.proyectobcp.repository.CampanasRepository;
import pe.edu.cibertec.proyectobcp.services.CampanasService;

@Service
public class CampanaServiceImpl implements CampanasService {

	@Autowired
	private CampanasRepository campanaRepository;

	@Override
	public Campanas registrar(Campanas campanas) {

		return campanaRepository.save(campanas);
	}

	@Override
	public Campanas actualizar(Campanas campanas) {

		return campanaRepository.save(campanas);
	}

	@Override
	public void eliminar(Long id) {

		campanaRepository.deleteById(id);
	}

	@Override
	public List<Campanas> obtenerCampanas() {

		return (List<Campanas>) campanaRepository.findAll();
	}

	@Override
	public Optional<Campanas> obtenerPorId(Long id) {

		return campanaRepository.findById(id);
	}

}
