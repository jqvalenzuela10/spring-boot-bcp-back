package pe.edu.cibertec.proyectobcp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_tipo_cuenta_bancario")
@Entity
public class TipoCuentaBancario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codTipoCuentaBancario;

	private String descripcion;

	public int getCodTipoCuentaBancario() {
		return codTipoCuentaBancario;
	}

	public void setCodTipoCuentaBancario(int codTipoCuentaBancario) {
		this.codTipoCuentaBancario = codTipoCuentaBancario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
