package pe.edu.cibertec.proyectobcp.rest;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.proyectobcp.model.CuentasBancarias;
import pe.edu.cibertec.proyectobcp.model.Transaccion;
import pe.edu.cibertec.proyectobcp.model.TransaccionClienteDTO;
import pe.edu.cibertec.proyectobcp.services.ClienteService;
import pe.edu.cibertec.proyectobcp.services.CuentasBancariasService;
import pe.edu.cibertec.proyectobcp.services.TransactionService;

@RestController
@RequestMapping("/api/transacciones")
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionRestController {

	@Autowired
	private TransactionService transactionService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private CuentasBancariasService cuentasBancariasService;

	@GetMapping("/clientes/{codCuenta}")
	public List<Transaccion> obtenerTransacPorCuenta(@PathVariable String codCuenta) {

		Long codigo = Long.decode(codCuenta);
		CuentasBancarias cb = new CuentasBancarias();
		cb.setCodCuenta(codigo);
		return transactionService.obtenerTransaccionesPorCuenta(cb);
	}
	
	
	@GetMapping("/historial/{codCuenta}")
	public List<TransaccionClienteDTO> obtenerTransacccionesPorCasdasdasduenta(@PathVariable Long codCuenta) {

		System.out.println("entro");
		return transactionService.obtenerHistorial(codCuenta);
	}
	
	

	@GetMapping("{codTran}")
	public Optional<Transaccion> obtenerTransaccion(@PathVariable Long codTran) {

		return transactionService.obtenerTransaccion(codTran);
	}

	@PostMapping
	public ResponseEntity<Transaccion> crearTransaccion(@RequestBody Transaccion transaccion) {

		CuentasBancarias cuenta = cuentasBancariasService.obtenerCuenta(transaccion.getCodCuenta().getCodCuenta())
				.get();
		CuentasBancarias cuentaRecibe = cuentasBancariasService.obtenerCuenta(transaccion.getCodDestinoCuenta())
				.get();

		if (!clienteService.obtenerPorId(transaccion.getCodCuenta().getCodCuenta()).isPresent()
				&& !clienteService.obtenerPorId(transaccion.getCodDestinoCuenta()).isPresent()) {
			return ResponseEntity.notFound().build();
		} else {

			if (transaccion.getMonto().compareTo(cuenta.getSaldo()) == -1) {
				Transaccion transCreada = transactionService.registrar(transaccion);

				BigDecimal resultado = cuenta.getSaldo().subtract(transaccion.getMonto());

				cuentasBancariasService.actualizar(transaccion.getCodCuenta().getCodCuenta(), resultado);

				resultado = cuentaRecibe.getSaldo().add(transaccion.getMonto());

				cuentasBancariasService.actualizar(transaccion.getCodDestinoCuenta(), resultado);

				return ResponseEntity.created(URI.create("/api/transacciones/" + transCreada.getCodTransaccion())).build();

			} else {

				return ResponseEntity.badRequest().build();
			}

		}

	}

}
