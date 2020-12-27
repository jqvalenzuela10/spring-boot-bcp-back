package pe.edu.cibertec.proyectobcp.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "campana_cliente")
public class CampanaCliente {

	@EmbeddedId
	CampanaClienteKey id;
	
	
	@ManyToOne
	@MapsId("codCamp")
	@JoinColumn(name = "cod_camp")
	Campanas campana;
	
	@ManyToOne
	@MapsId("codCli")
	@JoinColumn(name = "cod_cli")
	Clientes cliente;
	
	boolean leido;

	
	
	public CampanaCliente() {
		super();
	}

	public CampanaClienteKey getId() {
		return id;
	}

	public void setId(CampanaClienteKey id) {
		this.id = id;
	}

	public Campanas getCampana() {
		return campana;
	}

	public void setCampana(Campanas campana) {
		this.campana = campana;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public boolean isLeido() {
		return leido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}

	public CampanaCliente(CampanaClienteKey id, Campanas campana, Clientes cliente, boolean leido) {
		super();
		this.id = id;
		this.campana = campana;
		this.cliente = cliente;
		this.leido = leido;
	}
	
	
	
	
	
}
