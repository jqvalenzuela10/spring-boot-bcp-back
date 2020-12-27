package pe.edu.cibertec.proyectobcp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_tipo_notificaciones")
public class TipoNotificaciones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codTipoNotificaciones;

	@Column(name = "nombre", length = 20, nullable = false)
	private String nombre;

	public Long getCodTipoNotificaciones() {
		return codTipoNotificaciones;
	}

	public void setCodTipoNotificaciones(Long codTipoNotificaciones) {
		this.codTipoNotificaciones = codTipoNotificaciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
