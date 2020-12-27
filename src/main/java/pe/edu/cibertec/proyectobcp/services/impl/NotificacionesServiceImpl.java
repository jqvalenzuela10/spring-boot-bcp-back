package pe.edu.cibertec.proyectobcp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.proyectobcp.model.DestinoNotificaciones;
import pe.edu.cibertec.proyectobcp.model.Notificaciones;
import pe.edu.cibertec.proyectobcp.repository.DestinoNotificacionesRepository;
import pe.edu.cibertec.proyectobcp.repository.NotificacionesRepository;
import pe.edu.cibertec.proyectobcp.services.NotificacionesService;

@Service
public class NotificacionesServiceImpl implements NotificacionesService {

	@Autowired
	private NotificacionesRepository notificacionesRepository;

	@Autowired
	private DestinoNotificacionesRepository destinoNotificacionRepository;

	@Override
	public Notificaciones registrar(Notificaciones notificaciones) {

		return notificacionesRepository.save(notificaciones);
	}

	@Override
	public List<Notificaciones> obtenerNotificaciones() {

		return (List<Notificaciones>) notificacionesRepository.findAll();
	}

	@Override
	public Optional<Notificaciones> obtenerNotificacion(Long codNotifi) {

		return notificacionesRepository.findById(codNotifi);
	}

	@Override
	public DestinoNotificaciones registrar(DestinoNotificaciones desNotificacion) {

		return destinoNotificacionRepository.save(desNotificacion);
	}

	@Override
	public Optional<DestinoNotificaciones> obtenerDestinoNotificacion(Long codDestino) {

		return destinoNotificacionRepository.findById(codDestino);
	}

	@Override
	public List<DestinoNotificaciones> listaDestinos() {

		return (List<DestinoNotificaciones>) destinoNotificacionRepository.findAll();
	}

	@Override
	public Notificaciones actualizar(Notificaciones notificaciones) {

		return notificacionesRepository.save(notificaciones);
	}

}
