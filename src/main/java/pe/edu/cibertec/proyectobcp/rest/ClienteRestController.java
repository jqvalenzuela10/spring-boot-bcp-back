package pe.edu.cibertec.proyectobcp.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.edu.cibertec.proyectobcp.model.Auth;
import pe.edu.cibertec.proyectobcp.model.Clientes;
import pe.edu.cibertec.proyectobcp.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Clientes> listEmpleados() {
		return clienteService.obtenerClientes();
	}

	@GetMapping("{id}")
	public Clientes obtenerCliente(@PathVariable Long id) {
		return clienteService.obtenerPorId(id).get();
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Clientes clientes) {

		Clientes clienteGuardado = clienteService.registrar(clientes);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(clienteGuardado.getCodCli()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Object> actualizar(@RequestBody Clientes clientes, @PathVariable Long id) {
		clientes.setCodCli(id);
		clienteService.actualizar(clientes);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("{id}")
	public void eliminar(@PathVariable Long id) {
		clienteService.eliminar(id);
	}

	@PostMapping(value = "/autenticar")
	public Clientes autenticarCliente(@RequestBody Auth credenciales) {

		Clientes clienteAutenticado = clienteService.authentication(credenciales);
		if (clienteAutenticado != null) {
			return clienteAutenticado;
		}

		return new Clientes();
	}

}
