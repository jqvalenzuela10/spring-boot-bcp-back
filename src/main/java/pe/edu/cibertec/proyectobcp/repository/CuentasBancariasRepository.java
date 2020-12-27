package pe.edu.cibertec.proyectobcp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyectobcp.model.Clientes;
import pe.edu.cibertec.proyectobcp.model.CuentasBancarias;

@Repository
public interface CuentasBancariasRepository extends CrudRepository<CuentasBancarias, Long> {

	public List<CuentasBancarias> findByCodCli(Clientes cod_cli);

	public CuentasBancarias findByNumCuenta(String numCuenta);
	
	public CuentasBancarias findByCodCuenta(Long codCuenta);
	
	
}
