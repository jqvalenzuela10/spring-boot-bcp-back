package pe.edu.cibertec.proyectobcp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.Nullable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_transacciones")
public class Transaccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codTransaccion;

	@Column(name = "salario", precision = 10, scale = 2)
	private BigDecimal monto;

	@Column(name = "cod_destino_cuenta", nullable = false)
	private Long codDestinoCuenta;

	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;

	@Column(name = "hora", nullable = false, length = 200)
	private String hora;

	private boolean leido;

	@ManyToOne
	@JoinColumn(name = "codCuenta")
	private CuentasBancarias codCuenta;

	@ManyToOne
	@JoinColumn(name = "cod_tipo_transaccion")
	private TipoTransaccion codTipoTransaccion;

	@Nullable
	@ManyToOne
	@JoinColumn(name = "cod_tipo_error_transaccion")
	private TipoErrorTransaccion codTipoErrorTransaccion;

	@ManyToOne
	@JoinColumn(name = "cod_estado_transaccion")
	private EstadoTransaccion codEstadoTransaccion;

	public EstadoTransaccion getCodEstadoTransaccion() {
		return codEstadoTransaccion;
	}

	public boolean isLeido() {
		return leido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}

	public void setCodEstadoTransaccion(EstadoTransaccion codEstadoTransaccion) {
		this.codEstadoTransaccion = codEstadoTransaccion;
	}

	public Long getCodTransaccion() {
		return codTransaccion;
	}

	public void setCodTransaccion(Long codTransaccion) {
		this.codTransaccion = codTransaccion;
	}

	public TipoErrorTransaccion getCodTipoErrorTransaccion() {
		return codTipoErrorTransaccion;
	}

	public void setCodTipoErrorTransaccion(TipoErrorTransaccion codTipoErrorTransaccion) {
		this.codTipoErrorTransaccion = codTipoErrorTransaccion;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Long getCodDestinoCuenta() {
		return codDestinoCuenta;
	}

	public void setCodDestinoCuenta(Long codDestinoCuenta) {
		this.codDestinoCuenta = codDestinoCuenta;
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

	public CuentasBancarias getCodCuenta() {
		return codCuenta;
	}

	public void setCodCuenta(CuentasBancarias codCuenta) {
		this.codCuenta = codCuenta;
	}

	public TipoTransaccion getCodTipoTransaccion() {
		return codTipoTransaccion;
	}

	public void setCodTipoTransaccion(TipoTransaccion codTipoTransaccion) {
		this.codTipoTransaccion = codTipoTransaccion;
	}

}
