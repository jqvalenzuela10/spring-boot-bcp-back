package pe.edu.cibertec.proyectobcp.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import pe.edu.cibertec.proyectobcp.model.Clientes;
import pe.edu.cibertec.proyectobcp.model.CuentasBancarias;

public interface CuentasBancariasService {

	CuentasBancarias registrar(CuentasBancarias cuenta);

	CuentasBancarias actualizar(Long id, BigDecimal monto);

	Integer eliminar(Long id);

	List<CuentasBancarias> obtenerCuentasXCliente(Clientes cliente);

	Optional<CuentasBancarias> obtenerCuenta(Long id);
	
	CuentasBancarias obtenerPorNumero(String numCuenta);
	
	
	
	

}
