package pe.edu.cibertec.proyectobcp.services;

import java.util.List;
import java.util.Optional;

import pe.edu.cibertec.proyectobcp.model.DestinoNotificaciones;
import pe.edu.cibertec.proyectobcp.model.Notificaciones;

public interface NotificacionesService {

	Notificaciones registrar(Notificaciones notificaciones);
	
	Notificaciones actualizar(Notificaciones notificaciones);

	List<Notificaciones> obtenerNotificaciones();
	
	Optional<Notificaciones> obtenerNotificacion(Long codNotifi);
	
	Optional<DestinoNotificaciones> obtenerDestinoNotificacion(Long codDestino);
	
	DestinoNotificaciones registrar(DestinoNotificaciones desNotificacion);
	
	List<DestinoNotificaciones> listaDestinos();

}
