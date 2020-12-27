package pe.edu.cibertec.proyectobcp.services;

import java.util.List;
import java.util.Optional;

import pe.edu.cibertec.proyectobcp.model.Usuario;


public interface UsuarioService {

	Usuario registrar(Usuario usuario);
	
	Usuario actualizar(Usuario usuario);
	
	void eliminar(Long id);
	
	Optional<Usuario> obtenerPorId(Long id);
	
	List<Usuario> obtenerUsuarios();
	
}
