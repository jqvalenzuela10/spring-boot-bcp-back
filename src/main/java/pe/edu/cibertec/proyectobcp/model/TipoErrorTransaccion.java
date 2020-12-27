package pe.edu.cibertec.proyectobcp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipo_error_transaccion")
public class TipoErrorTransaccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codTipoErrorTransaccion;
	
	private String descripcion;

	public int getCodTipoErrorTransaccion() {
		return codTipoErrorTransaccion;
	}

	public void setCodTipoErrorTransaccion(int codTipoErrorTransaccion) {
		this.codTipoErrorTransaccion = codTipoErrorTransaccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
