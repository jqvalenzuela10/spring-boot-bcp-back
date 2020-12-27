package pe.edu.cibertec.proyectobcp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estado_transaccion")
public class EstadoTransaccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codEstadoTransaccion;
	private String descripcion;

	public int getCodEstadoTransaccion() {
		return codEstadoTransaccion;
	}

	public void setCodEstadoTransaccion(int codEstadoTransaccion) {
		this.codEstadoTransaccion = codEstadoTransaccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
