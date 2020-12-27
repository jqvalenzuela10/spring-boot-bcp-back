package pe.edu.cibertec.proyectobcp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyectobcp.model.Clientes;

@Repository
public interface ClienteRepository extends CrudRepository<Clientes, Long> {

	@Query("select tc from Clientes tc where tc.dni = :dni and tc.password = :password")
	Clientes autenticarCliente(@Param("dni") int dni, @Param("password") String password);  
	
}
