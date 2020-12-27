package pe.edu.cibertec.proyectobcp.services.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.proyectobcp.model.Clientes;
import pe.edu.cibertec.proyectobcp.model.CuentasBancarias;
import pe.edu.cibertec.proyectobcp.repository.CuentasBancariasRepository;
import pe.edu.cibertec.proyectobcp.services.CuentasBancariasService;

@Service
public class CuentasBancariasServiceImpl implements CuentasBancariasService {

	@Autowired
	private CuentasBancariasRepository cuentasRepository;

	@Override
	public CuentasBancarias registrar(CuentasBancarias cuentas) {

		return cuentasRepository.save(cuentas);
	}

	@Override
	public Integer eliminar(Long id) {

		cuentasRepository.deleteById(id);
		Optional<CuentasBancarias> cta = cuentasRepository.findById(id);
		if (cta.isPresent()) {
			return -1;
		}
		return 1;
	}

	@Override
	public List<CuentasBancarias> obtenerCuentasXCliente(Clientes cliente) {


		return (List<CuentasBancarias>) cuentasRepository.findByCodCli(cliente);
	}

	@Override
	public CuentasBancarias actualizar(Long id, BigDecimal monto) {

		CuentasBancarias cuenta = cuentasRepository.findById(id).get();
		cuenta.setSaldo(monto);

		return cuentasRepository.save(cuenta);
	}

	@Override
	public Optional<CuentasBancarias> obtenerCuenta(Long id) {

		return cuentasRepository.findById(id);
	}

	@Override
	public CuentasBancarias obtenerPorNumero(String numCuenta) {

		return cuentasRepository.findByNumCuenta(numCuenta);
	}

}
