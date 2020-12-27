package pe.edu.cibertec.proyectobcp.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.proyectobcp.model.Campanas;
import pe.edu.cibertec.proyectobcp.services.CampanasService;

@RestController
@RequestMapping(value = "/api/campanas")
@CrossOrigin(origins = "http://localhost:4200")
public class CampanaRestController {

	@Autowired
	private CampanasService campanasService;

	@GetMapping
	public List<Campanas> findAll() {

		return campanasService.obtenerCampanas();
	}

	@PostMapping(value = "/registrar")
	public Campanas registrar(@RequestBody Campanas campanas) {

		return campanasService.registrar(campanas);
	}

	@PutMapping(value = "/actualizar")
	public void actualizar(@RequestBody Campanas campanas) {

		campanasService.actualizar(campanas);
	}

	@DeleteMapping(value = "/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {

		campanasService.eliminar(id);
	}

	@GetMapping("/{id}")
	public Optional<Campanas> findCampanaUsuario(@PathVariable long id) {

		return campanasService.obtenerPorId(id);
	}

}