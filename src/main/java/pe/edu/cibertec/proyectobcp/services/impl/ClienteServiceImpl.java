package pe.edu.cibertec.proyectobcp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.proyectobcp.model.Auth;
import pe.edu.cibertec.proyectobcp.model.Clientes;
import pe.edu.cibertec.proyectobcp.repository.ClienteRepository;
import pe.edu.cibertec.proyectobcp.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Clientes registrar(Clientes clientes) {

		return clienteRepository.save(clientes);
	}

	@Override
	public Clientes actualizar(Clientes clientes) {

		return clienteRepository.save(clientes);
	}

	@Override
	public List<Clientes> obtenerClientes() {

		return (List<Clientes>) clienteRepository.findAll();
	}

	@Override
	public Integer eliminar(Long id) {

		clienteRepository.deleteById(id);
		Optional<Clientes> cli = clienteRepository.findById(id);
		if (cli.isPresent()) {
			return -1;
		}
		return 1;
	}

	@Override
	public Optional<Clientes> obtenerPorId(Long id) {

		return clienteRepository.findById(id);
	}

	@Override
	public Clientes authentication(Auth claves) {
		
		
		return clienteRepository.autenticarCliente(claves.getDni(), claves.getPassword());
	}

}
