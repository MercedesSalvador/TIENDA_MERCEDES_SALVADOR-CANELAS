package curso.java.tienda.model.producto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import curso.java.tienda.model.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Producto {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String nombre;
	String descripcion;
	double precio;
	int stock;
	String imagen;
	int id_categoria;
	
	public Producto(String nombre, String descripcion, double precio, int stock, String imagen) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}

	public Producto(String nombre, String descripcion, double precio, int stock) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}
	
	
	
	
}
