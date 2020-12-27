package pe.edu.cibertec.proyectobcp.socket;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import pe.edu.cibertec.proyectobcp.model.CuentasBancarias;
import pe.edu.cibertec.proyectobcp.model.TransaccionClienteDTO;
import pe.edu.cibertec.proyectobcp.services.TransactionService;

@Controller
public class NotifcacionController {

	@Autowired
	private SimpMessagingTemplate webSocket;

	
	@Autowired
	private TransactionService transaccionService;
	
	@MessageMapping("/prueba/{id}/{receptor}")
	public void prueba(@DestinationVariable int id, @DestinationVariable int receptor) {
		List<TransaccionClienteDTO> lista=transaccionService.obtenerHistorial(new Long(id));
		System.out.println("----------");
		webSocket.convertAndSend("/notificacion/"+lista.get(0).getCodCli(),lista);
		webSocket.convertAndSend("/notificacion/"+receptor,transaccionService.obtenerHistorial(new Long(receptor)));
		webSocket.convertAndSend("/notificacion/receptor/"+id,transaccionService.findByCodDestinoCuenta(new Long(id)));
	}
	
	@MessageMapping("/prueba/{id}")
	public void prueba2(@DestinationVariable int id) {
		
	
	
		
		List<TransaccionClienteDTO> lista=transaccionService.obtenerHistorial(new Long(id));
		webSocket.convertAndSend("/notificacion/receptor/"+id,transaccionService.findByCodDestinoCuenta(new Long(id)));
		webSocket.convertAndSend("/notificacion/"+id,lista);
		
		
	}
	

}
