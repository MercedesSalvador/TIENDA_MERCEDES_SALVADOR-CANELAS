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
public class Pedido {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int id_usuario;
	private double total;
	private String metodo_pago;
	private String estado;
	
	public Pedido(int id_usuario, double total) {
		super();
		this.id_usuario = id_usuario;
		this.total = total;
	}
	
	
	
}
