package pe.edu.cibertec.proyectobcp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_clientes")
public class Clientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codCli;

	@Column(name = "nom_cli", length = 45, nullable = false)
	private String nomCli;

	@Column(name = "ape_pat_cli", length = 45, nullable = false)
	private String apePatCli;

	@Column(name = "ape_mat_cli", length = 45, nullable = false)
	private String apeMatCli;

	@Column(name = "dni", length = 8, nullable = false)
	private int dni;

	@Column(name = "correo", length = 45, nullable = false)
	private String correo;

	@Column(name = "password", length = 20, nullable = false)
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	List<CampanaCliente> campanaCliente;

	public Long getCodCli() {
		return codCli;
	}

	public void setCodCli(Long codCli) {
		this.codCli = codCli;
	}

	public List<CampanaCliente> getCampanaCliente() {
		return campanaCliente;
	}

	public void setCampanaCliente(List<CampanaCliente> campanaCliente) {
		this.campanaCliente = campanaCliente;
	}

	public String getNomCli() {
		return nomCli;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}

	public String getApePatCli() {
		return apePatCli;
	}

	public void setApePatCli(String apePatCli) {
		this.apePatCli = apePatCli;
	}

	public String getApeMatCli() {
		return apeMatCli;
	}

	public void setApeMatCli(String apeMatCli) {
		this.apeMatCli = apeMatCli;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
