package pe.edu.cibertec.proyectobcp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import pe.edu.cibertec.proyectobcp.model.Clientes;
import pe.edu.cibertec.proyectobcp.model.CuentasBancarias;
import pe.edu.cibertec.proyectobcp.model.Transaccion;
import pe.edu.cibertec.proyectobcp.model.TransaccionClienteDTO;


public interface TransactionService {

	Transaccion registrar(Transaccion transac);
	
	Optional<Transaccion> obtenerTransaccion(Long codTran);
	
	List<Transaccion> obtenerTransaccionesPorCuenta(CuentasBancarias codCuenta);
	
	List<TransaccionClienteDTO> obtenerHistorial(Long i);
	
	List<Transaccion> findByCodDestinoCuenta(Long id);
	
}
