package pe.edu.cibertec.proyectobcp.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.proyectobcp.model.Clientes;
import pe.edu.cibertec.proyectobcp.model.CuentasBancarias;
import pe.edu.cibertec.proyectobcp.model.Transaccion;
import pe.edu.cibertec.proyectobcp.model.TransaccionClienteDTO;
import pe.edu.cibertec.proyectobcp.repository.CuentasBancariasRepository;
import pe.edu.cibertec.proyectobcp.repository.TransactionRepository;
import pe.edu.cibertec.proyectobcp.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CuentasBancariasRepository cuentaBancariaRepository;
	
	
	@Override
	public Transaccion registrar(Transaccion transac) {

		return transactionRepository.save(transac);
	}

	@Override
	public Optional<Transaccion> obtenerTransaccion(Long codTran) {

		return transactionRepository.findById(codTran);
	}

	@Override
	public List<Transaccion> obtenerTransaccionesPorCuenta(CuentasBancarias codCuenta) {

		return transactionRepository.findByCodCuenta(codCuenta);
	}

	@Override
	public List<TransaccionClienteDTO> obtenerHistorial(Long idCuenta) {
		/*obtengo el cliente que esta asociado a ese codigo de cuenta*/
		long codCli;
		CuentasBancarias cuentaBancaria=cuentaBancariaRepository.findByCodCuenta(idCuenta);
		Clientes cliente=cuentaBancaria.getCodCli();
		codCli=cliente.getCodCli();
		/**/
		/*ahora obtengo la cantidad de cuentas que tiene ese cliente*/
		Clientes c1=new Clientes();
		c1.setCodCli(codCli);
		List<CuentasBancarias> listadoCuentaBancarias= cuentaBancariaRepository.findByCodCli(c1);
		System.out.println("cantidaddaddadadadadqad");
		System.out.println(listadoCuentaBancarias.size());
		
		/**/
		/*ahora obtengo la informacion*/
		int cantidad=listadoCuentaBancarias.size();
		List<Transaccion> listaTranssacion=null;
		if(cantidad == 1) {
			CuentasBancarias c=new CuentasBancarias();
			c.setCodCuenta(listadoCuentaBancarias.get(0).getCodCuenta());
			
			listaTranssacion=transactionRepository.findByCodCuentaOrCodDestinoCuenta(c, idCuenta);
		}
		if(cantidad == 2) {
			listaTranssacion=transactionRepository.findAllGa(listadoCuentaBancarias.get(0).getCodCuenta(),listadoCuentaBancarias.get(1).getCodCuenta());
		}
	
		
		
	
		List<TransaccionClienteDTO> lista=new ArrayList<>();
		
		
		
		for (Transaccion t : listaTranssacion) {
			
			
			/*obtener datos del destinatario*/
			CuentasBancarias c2=cuentaBancariaRepository.findByCodCuenta(t.getCodDestinoCuenta());
			System.out.println(t.getCodTipoTransaccion().getNombre());
			/**/
			TransaccionClienteDTO model=new TransaccionClienteDTO();
			
			
			model.setCodTransaccion(t.getCodTransaccion());
			model.setCodCuenta(t.getCodCuenta().getCodCli().getNomCli());
			model.setCodDestinoCuenta(c2.getCodCli().getNomCli());
			model.setMonto(t.getMonto());
			model.setDescripcion(t.getDescripcion());
			model.setFecha(t.getFecha());
			model.setTipoTransaccion(t.getCodTipoTransaccion().getNombre());
			model.setHora(t.getHora());
			model.setCodCli(codCli);
			lista.add(model);
			
		}
		
		
		
		
		
		return lista;
	}

	@Override
	public List<Transaccion> findByCodDestinoCuenta(Long id) {
		// TODO Auto-generated method stub
		return transactionRepository.findByCodDestinoCuenta(new Long(id));
	}


}
