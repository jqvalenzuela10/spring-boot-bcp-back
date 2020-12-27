package pe.edu.cibertec.proyectobcp.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_cuentas_bancarias")
public class CuentasBancarias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codCuenta;

	@Column(name = "num_cuenta", length = 20, nullable = false)
	private String numCuenta;

	@Column(name = "saldo", precision = 10, scale = 2)
	private BigDecimal saldo;

	@Column(name = "tarjeta", length = 16, nullable = false)
	private String tarjeta;

	@ManyToOne
	@JoinColumn(name = "cod_tipo_moneda")
	private TipoMoneda codTipoMoneda;

	@ManyToOne
	@JoinColumn(name = "cod_cli")
	private Clientes codCli;
	
	
	@ManyToOne
	@JoinColumn(name = "cod_tipo_cuenta_bancario")
	private TipoCuentaBancario tipoCuentaBancario;
	
	public CuentasBancarias() {
		super();
	}

	public Long getCodCuenta() {
		return codCuenta;
	}

	public void setCodCuenta(Long cod_cuenta) {
		this.codCuenta = cod_cuenta;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public TipoMoneda getCodTipoMoneda() {
		return codTipoMoneda;
	}

	public void setCodTipoMoneda(TipoMoneda codTipoMoneda) {
		this.codTipoMoneda = codTipoMoneda;
	}

	public Clientes getCodCli() {
		return codCli;
	}

	public void setCodCli(Clientes codCli) {
		this.codCli = codCli;
	}

	public TipoCuentaBancario getTipoCuentaBancario() {
		return tipoCuentaBancario;
	}

	public void setTipoCuentaBancario(TipoCuentaBancario tipoCuentaBancario) {
		this.tipoCuentaBancario = tipoCuentaBancario;
	}

	
	
}
