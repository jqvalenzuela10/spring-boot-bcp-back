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
@Table(name = "tb_tipo_transaccion")
public class TipoTransaccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codTipoTransaccion;

	@Column(name = "nombre", length = 20, nullable = false)
	private String nombre;

	public Long getCodTipoTransaccion() {
		return codTipoTransaccion;
	}

	public void setCodTipoTransaccion(Long codTipoTransaccion) {
		this.codTipoTransaccion = codTipoTransaccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
