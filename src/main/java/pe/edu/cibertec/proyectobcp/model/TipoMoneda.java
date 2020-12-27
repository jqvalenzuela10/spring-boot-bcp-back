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
@Table(name = "tb_tipo_moneda")
public class TipoMoneda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codTipoMoneda;

	@Column(name = "nombre", length = 20, nullable = false)
	private String nombre;

	

	public Long getCodTipoMoneda() {
		return codTipoMoneda;
	}

	public void setCodTipoMoneda(Long codTipoMoneda) {
		this.codTipoMoneda = codTipoMoneda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	
}
