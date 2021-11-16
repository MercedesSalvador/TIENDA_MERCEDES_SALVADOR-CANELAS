package curso.java.tienda.model.usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int id_rol;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String calle;
	private String telefono;
	private String provincia;
	private String localidad;
	private String dni;
	private String email;
	private String clave;
	
	public Usuario( String email,String clave) {
		super();
		this.email = email;
		this.clave = clave;
	}
	public Usuario(String nombre, String apellido1, String apellido2,String email, String clave) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.email = email;
		this.clave = clave;
	}
	public Usuario(String nombre, String apellido1, String apellido2, String dni, String calle, String telefono,
			String provincia, String localidad, String email, String clave) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.calle = calle;
		this.telefono = telefono;
		this.provincia = provincia;
		this.localidad = localidad;
		this.email = email;
		this.clave = clave;
	}
	
	
}
