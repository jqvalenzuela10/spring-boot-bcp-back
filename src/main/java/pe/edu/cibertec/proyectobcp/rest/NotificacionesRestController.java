package pe.edu.cibertec.proyectobcp.rest;

import java.net.URI;
import java.util.ArrayList;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.edu.cibertec.proyectobcp.model.DestinoNotificaciones;
import pe.edu.cibertec.proyectobcp.model.Notificaciones;
import pe.edu.cibertec.proyectobcp.services.NotificacionesService;

@RestController
@RequestMapping("/api/notificaciones")
@CrossOrigin(origins = "http://localhost:4200")
public class NotificacionesRestController {

	@Autowired
	private NotificacionesService notificacionesService;

	@GetMapping()
	public List<Notificaciones> obtenerNotificaciones() {

		return (List<Notificaciones>) notificacionesService.obtenerNotificaciones();
	}
	
	@GetMapping("{id}")
	public Optional<Notificaciones> obtenerNotificacion(@PathVariable Long id) {

		return notificacionesService.obtenerNotificacion(id);
	}
	
	@GetMapping("/cuenta/{codUsuario}")
	public List<Notificaciones> obtenerNotificacionesPorUsuario(@PathVariable Long codUsuario) {
		
		List<Notificaciones> hola = new ArrayList<Notificaciones>();
		
		return hola;
	}

	@GetMapping("/destino/{id}")
	public Optional<DestinoNotificaciones> obtenerDestinoNotificacion(@PathVariable Long id) {

		return notificacionesService.obtenerDestinoNotificacion(id);
	}
	
	@GetMapping("/destino")
	public List<DestinoNotificaciones> obtenerDestinos() {
		
		return notificacionesService.listaDestinos();
	}

	@PostMapping
	public ResponseEntity<Object> crearNotificacion(@RequestBody Notificaciones notificacion) {

		Notificaciones notifiCreada = notificacionesService.registrar(notificacion);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
				.buildAndExpand(notifiCreada.getCodNotif()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PostMapping(value = "/destino")
	public ResponseEntity<Object> crearDestinoNotificacion(@RequestBody DestinoNotificaciones desNotificacion) {

		if (!notificacionesService.obtenerNotificacion(desNotificacion.getCodNotif().getCodNotif()).isPresent()) {

			return ResponseEntity.notFound().build();
		}

		DestinoNotificaciones destinoCreado = notificacionesService.registrar(desNotificacion);
		Notificaciones notif = notificacionesService.obtenerNotificacion(desNotificacion.getCodNotif().getCodNotif()).get();
		notif.setEstado(1);
		notificacionesService.actualizar(notif);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/destino/id")
				.buildAndExpand(destinoCreado.getCodNotif()).toUri();

		return ResponseEntity.created(location).build();
	}

}
