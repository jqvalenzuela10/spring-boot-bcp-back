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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.edu.cibertec.proyectobcp.model.Clientes;
import pe.edu.cibertec.proyectobcp.model.CuentasBancarias;
import pe.edu.cibertec.proyectobcp.services.CuentasBancariasService;

@RestController
@RequestMapping("/api/cuentas")
@CrossOrigin(origins = "http://localhost:4200")
public class CuentaBancariaRestController {

	@Autowired
	private CuentasBancariasService cuentasService;

	@GetMapping("/{codCli}")
	public List<CuentasBancarias> obtenerCuentasXCliente(@PathVariable String codCli) {

		Long id = Long.decode(codCli);
		Clientes cliente = new Clientes();
		cliente.setCodCli(id);

		return cuentasService.obtenerCuentasXCliente(cliente);
	}
	
	@GetMapping("/codigo/{codCuenta}")
	public CuentasBancarias obtenerCuenta(@PathVariable Long codCuenta) {
		
		CuentasBancarias c =new CuentasBancarias();
		c=cuentasService.obtenerCuenta(codCuenta).get();
		System.out.println("gaa");
		System.out.println(c);
		return cuentasService.obtenerCuenta(codCuenta).get();
	}

	@GetMapping("/numero/{numCuenta}")
	public CuentasBancarias obtenerCuentasPorNumero(@PathVariable String numCuenta) {

		return cuentasService.obtenerPorNumero(numCuenta);
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody CuentasBancarias cuentas) {

		CuentasBancarias cuentaGuardada = cuentasService.registrar(cuentas);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cuentaGuardada.getCodCuenta()).toUri();

//		return ResponseEntity.ok(empleadoGuardado);
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("{id}")
	public void eliminar(@PathVariable Long id) {
		cuentasService.eliminar(id);
	}

}
