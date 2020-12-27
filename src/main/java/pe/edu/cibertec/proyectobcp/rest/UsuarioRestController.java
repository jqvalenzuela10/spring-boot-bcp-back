package pe.edu.cibertec.proyectobcp.rest;

import java.util.List;

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

import pe.edu.cibertec.proyectobcp.model.Usuario;
import pe.edu.cibertec.proyectobcp.services.UsuarioService;

@RestController
@RequestMapping(value = "/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> findAll() {
		
		return usuarioService.obtenerUsuarios();
	}

	@PostMapping(value = "/registrar")
	public Usuario registrar(@RequestBody Usuario usuario) {
		
		return usuarioService.registrar(usuario);
	}

	@PutMapping(value = "/actualizar")
	public Usuario actualizar(@RequestBody Usuario usuario) {
		
		Usuario usuarioActualizar = usuarioService.actualizar(usuario);
		return usuarioActualizar;
	}

	@DeleteMapping(value = "/eliminar/{id}")
	public void eliminar(@PathVariable long id) {
		
		usuarioService.eliminar(id);
	}

}
