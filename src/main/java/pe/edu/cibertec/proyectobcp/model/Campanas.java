package pe.edu.cibertec.proyectobcp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_campanas")
public class Campanas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codCamp;

	@Column(name = "titulo", length = 45, nullable = false)
	private String titulo;

	@Column(name = "descripcion", length = 100, nullable = false)
	private String descripcion;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;

	@Column(name = "hora", nullable = false)
	private String hora;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechIni;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechFin;

	@ManyToOne
	@JoinColumn(name = "cod_usu")
	private Usuario codUsu;

	@OneToMany(mappedBy = "campana")
	List<CampanaCliente> campanaCliente;
	
	
	
	public List<CampanaCliente> getCampanaCliente() {
		return campanaCliente;
	}

	public void setCampanaCliente(List<CampanaCliente> campanaCliente) {
		this.campanaCliente = campanaCliente;
	}

	public Long getCodCamp() {
		return codCamp;
	}

	public void setCodCamp(Long codCamp) {
		this.codCamp = codCamp;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public LocalDate getFechIni() {
		return fechIni;
	}

	public void setFechIni(LocalDate fechIni) {
		this.fechIni = fechIni;
	}

	public LocalDate getFechFin() {
		return fechFin;
	}

	public void setFechFin(LocalDate fechFin) {
		this.fechFin = fechFin;
	}

	public Usuario getCodUsu() {
		return codUsu;
	}

	public void setCodUsu(Usuario codUsu) {
		this.codUsu = codUsu;
	}

}
