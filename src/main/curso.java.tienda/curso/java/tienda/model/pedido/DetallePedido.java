package curso.java.tienda.model.pedido;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class DetallePedido {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int id_pedido;
	private int id_producto;
	private String nombre_producto;
	private double precio_unidad;
	private int unidades;
	private double total;
	
	public DetallePedido(int id) {
		id_producto = id;
	}

	public DetallePedido(int id_pedido, int id_producto, String nombre_producto, double precio_unidad, int unidades,
			double total) {
		super();
		this.id_pedido = id_pedido;
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.precio_unidad = precio_unidad;
		this.unidades = unidades;
		this.total = total;
	}

	
}
