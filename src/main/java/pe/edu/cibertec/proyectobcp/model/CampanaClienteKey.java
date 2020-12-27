package pe.edu.cibertec.proyectobcp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CampanaClienteKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "cod_camp")
	Long codCamp;

	@Column(name = "cod_cli")
	Long codCli;

	@Override
	public String toString() {
		return "CampanaClienteKey [codCamp=" + codCamp + ", codCli=" + codCli + "]";
	}

	public Long getCodCamp() {
		return codCamp;
	}

	public void setCodCamp(Long codCamp) {
		this.codCamp = codCamp;
	}

	public Long getCodCli() {
		return codCli;
	}

	public void setCodCli(Long codCli) {
		this.codCli = codCli;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampanaClienteKey other = (CampanaClienteKey) obj;
		if (codCamp != other.codCamp)
			return false;
		if (codCli != other.codCli)
			return false;
		return true;
	}

}
