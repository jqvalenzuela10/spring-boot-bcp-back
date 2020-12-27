package pe.edu.cibertec.proyectobcp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransaccionClienteDTO {

	public TransaccionClienteDTO() {

	}
	private Long codCli;
	private Long codTransaccion;
	private BigDecimal monto;
	private String codDestinoCuenta;
	private String descripcion;
	private LocalDate fecha;
	private String hora;
	private String codCuenta;
	private String tipoTransaccion;

	public Long getCodTransaccion() {
		return codTransaccion;
	}

	public void setCodTransaccion(Long codTransaccion) {
		this.codTransaccion = codTransaccion;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getCodDestinoCuenta() {
		return codDestinoCuenta;
	}

	public void setCodDestinoCuenta(String codDestinoCuenta) {
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

	public String getCodCuenta() {
		return codCuenta;
	}

	public void setCodCuenta(String codCuenta) {
		this.codCuenta = codCuenta;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public Long getCodCli() {
		return codCli;
	}

	public void setCodCli(Long codCli) {
		this.codCli = codCli;
	}

	
}

