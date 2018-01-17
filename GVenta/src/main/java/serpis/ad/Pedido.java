package serpis.ad;

import javax.persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;


@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private Date fecha;
	private BigDecimal importe;
	
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return String.format("[%s] %s", id, cliente, fecha, importe);

	}
	
}