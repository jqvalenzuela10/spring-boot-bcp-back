package pe.edu.cibertec.proyectobcp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_destino_notificaciones")
public class DestinoNotificaciones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_destino_notificaciones;

	@ManyToMany
	private List<Clientes> clientes;

	@ManyToOne
	@JoinColumn(name = "cod_notif")
	private Notificaciones codNotif;

	public Long getCod_destino_notificaciones() {
		return cod_destino_notificaciones;
	}

	public void setCod_destino_notificaciones(Long cod_destino_notificaciones) {
		this.cod_destino_notificaciones = cod_destino_notificaciones;
	}

	public List<Clientes> getClientes() {
		return clientes;
	}

	public void setClientes(List<Clientes> clientes) {
		this.clientes = clientes;
	}

	public Notificaciones getCodNotif() {
		return codNotif;
	}

	public void setCodNotif(Notificaciones codNotif) {
		this.codNotif = codNotif;
	}

}