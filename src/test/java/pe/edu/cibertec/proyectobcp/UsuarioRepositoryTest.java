package pe.edu.cibertec.proyectobcp;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.cibertec.proyectobcp.model.CuentasBancarias;
import pe.edu.cibertec.proyectobcp.repository.UsuarioRepository;
import pe.edu.cibertec.proyectobcp.services.CuentasBancariasService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CuentasBancariasService cuentasBancariasService;
	
	@Test
	public void insertarUsuario() {
		usuarioRepository.count();
	}
	
	@Test
	public void actualizarSaldoCuentas() {
		
		CuentasBancarias cb = cuentasBancariasService.obtenerCuenta(1L).get();
		BigDecimal saldo = cb.getSaldo();
		
		BigDecimal resultado = saldo.subtract(new BigDecimal(1000));
		
		CuentasBancarias cuentaActualizada = cuentasBancariasService.actualizar(1L, resultado);
		
		assertTrue(cuentaActualizada.getSaldo().compareTo(new BigDecimal(4000)) == 0);
	}
	
}
