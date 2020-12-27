package pe.edu.cibertec.proyectobcp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyectobcp.model.DestinoNotificaciones;

@Repository
public interface DestinoNotificacionesRepository extends CrudRepository<DestinoNotificaciones, Long> {

//	List<Notificaciones> findByCodNotif();
	
}
