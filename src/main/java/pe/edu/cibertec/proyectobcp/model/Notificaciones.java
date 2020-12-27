package pe.edu.cibertec.proyectobcp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_notificaciones")
public class Notificaciones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codNotif;

	@Column(name = "titulo", length = 45, nullable = false)
	private String titulo;

	@Column(name = "estado", nullable = false)
	private int estado;

	@Column(name = "descripcion", length = 55, nullable = false)
	private String descripcion;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;

	@Column(name = "hora", nullable = false)
	private String hora;

	@ManyToOne
	@JoinColumn(name = "cod_tipo_notificaciones")
	private TipoNotificaciones codTipoNotificaciones;

	public Long getCodNotif() {
		return codNotif;
	}

	public void setCodNotif(Long codNotif) {
		this.codNotif = codNotif;
	}

	public TipoNotificaciones getCodTipoNotificaciones() {
		return codTipoNotificaciones;
	}

	public void setCodTipoNotificaciones(TipoNotificaciones codTipoNotificaciones) {
		this.codTipoNotificaciones = codTipoNotificaciones;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}
