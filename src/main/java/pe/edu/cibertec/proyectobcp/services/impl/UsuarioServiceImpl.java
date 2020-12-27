package pe.edu.cibertec.proyectobcp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.proyectobcp.model.Usuario;
import pe.edu.cibertec.proyectobcp.repository.UsuarioRepository;
import pe.edu.cibertec.proyectobcp.services.UsuarioService;

@Service
public class UsuarioServiceImpl  implements UsuarioService{

	@Autowired
	private UsuarioRepository clienteRepository;
	
	
	@Override
	public Usuario registrar(Usuario usuario) {

		
		return clienteRepository.save(usuario);
	}

	@Override
	public Usuario actualizar(Usuario usuario) {

		
		return clienteRepository.save(usuario);
	}

	@Override
	public void eliminar(Long id) {

		 clienteRepository.deleteById(id);;
	}

	@Override
	public Optional<Usuario> obtenerPorId(Long id) {

		return clienteRepository.findById(id);
	}

	@Override
	public List<Usuario> obtenerUsuarios() {

		return (List<Usuario>) clienteRepository.findAll();
	}

}
