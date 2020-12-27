package pe.edu.cibertec.proyectobcp.services;

import java.util.List;
import java.util.Optional;

import pe.edu.cibertec.proyectobcp.model.Auth;
import pe.edu.cibertec.proyectobcp.model.Clientes;

public interface ClienteService {

	Clientes registrar(Clientes clientes);

	Clientes actualizar(Clientes clientes);

	Integer eliminar(Long id);

	Optional<Clientes> obtenerPorId(Long id);

	List<Clientes> obtenerClientes();
	
	Clientes authentication(Auth claves);

}
