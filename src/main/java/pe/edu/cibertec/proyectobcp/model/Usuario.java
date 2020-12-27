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
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codUsu;

	@Column(name = "nombre_usu", length = 45, nullable = false)
	private String nombreUsu;

	@Column(name = "apellido_usu", length = 45, nullable = false)
	private String apellidoUsu;

	@Column(name = "username", length = 45, nullable = false)
	private String username;

	@Column(name = "password", length = 45, nullable = false)
	private String password;

	public Long getCodUsu() {
		return codUsu;
	}

	public void setCodUsu(Long codUsu) {
		this.codUsu = codUsu;
	}

	public String getNombreUsu() {
		return nombreUsu;
	}

	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}

	public String getApellidoUsu() {
		return apellidoUsu;
	}

	public void setApellidoUsu(String apellidoUsu) {
		this.apellidoUsu = apellidoUsu;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
