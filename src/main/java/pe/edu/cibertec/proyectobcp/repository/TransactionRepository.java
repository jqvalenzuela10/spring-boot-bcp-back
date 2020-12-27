package pe.edu.cibertec.proyectobcp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyectobcp.model.Clientes;
import pe.edu.cibertec.proyectobcp.model.CuentasBancarias;
import pe.edu.cibertec.proyectobcp.model.Transaccion;
import pe.edu.cibertec.proyectobcp.model.TransaccionClienteDTO;

@Repository
public interface TransactionRepository extends JpaRepository<Transaccion, Long> {

	public List<Transaccion> findByCodCuenta(CuentasBancarias id);
	
	public List<Transaccion> findByCodDestinoCuenta(Long id);
	
	public List<Transaccion> findByCodCuentaOrCodDestinoCuenta(CuentasBancarias id,Long cod_destino_cuenta);
	
	
	@Query("select t from Transaccion t where t.codCuenta.codCuenta=?1 or t.codCuenta.codCuenta=?2  or t.codDestinoCuenta= ?1 or t.codDestinoCuenta=?2")
	public List<Transaccion> findAllGa(long cod, long cod2);
	
	
}
