package curso.java.tienda.model.producto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import curso.java.tienda.model.pedido.DetallePedido;
import curso.java.tienda.model.usuario.Usuario;
import curso.java.tienda.model.usuario.UsuarioDAO;
import curso.java.tienda.util.HibernateManager;



public class ProductoDAO {
	
	
	public static void setProducto(Producto producto) {
		//Transaction tx = null;
		Session session = HibernateManager.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); // Crea una transacci�n
		int i = (int)session.save(producto);// Guarda el objeto creado en la BBDD.
		System.out.println("Producto creado con el id: " + i);
		tx.commit(); // Materializa la transacciOn
		session.close();
	}
	
	// Recupera un producto cuyo id se pasa como parametro
	public static Producto recuperarProducto(int id) {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		Producto producto = (Producto) session.get(Producto.class, id);
		if (producto == null) {
			System.out.println("No existe el producto");
		} else {
			System.out.println("usuario: " + producto.getNombre());
		}
		session.close();
		return producto;
	}
	
	// Modifica un producto cuyo id se pasa como parametro
	public static void editarProducto(int id, int id_categoria, String nombre, String descripcion, double precio, int stock ) {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		Producto producto = recuperarProducto(id);// new Album(id);
		if (producto == null) {
			System.out.println("No existe el producto");
		} else {
			producto.setId_categoria(id_categoria);
			producto.setNombre(nombre);
			producto.setDescripcion(descripcion);
			producto.setPrecio(precio);
			producto.setStock(stock);
			
			session.update(producto);// Modifica el objeto con Id indicado
			session.getTransaction().commit(); // Materializa la transaccion
		}
		session.close();
	}

	// Borrar un producto cuyo id se pasa como parametro
	public static void borrarProducto(int id) {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		Producto producto = recuperarProducto(id);// new Album(id);
		if (producto != null) {
			session.delete(producto);
		}
		session.getTransaction().commit(); // Materializa la transaccion

		session.close();
	}
	
	//Lista de productos
	public static List<Producto> getProductos() {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT p from Producto p");
		List<Producto> listaProductos= q.list();
		session.close();
		return listaProductos;
	}
	
	public static boolean existeProducto(Producto producto) {
		boolean existe = false;	
		
		for (Producto p : getProductos()) {
			String nombre = p.getNombre();
				if(nombre.equals(producto.getNombre())) {
					existe=true;
				}
			}
			return existe;
		}
		
/**
 * Recupera producto con el id de categoria
 * @param id_categoria
 * @return
 */
	public static List<Producto> recuperarProductoIdCategoria(int id_categoria) {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT u from Producto u WHERE id_categoria = '" + id_categoria + "'");
		List<Producto> results = q.list();
		if (results == null) {
			System.out.println("No hay detalles de pedido");
		} else {
			System.out.println("dp: " + results.get(0).getId_categoria());
		}
		session.close();
		return results;
		}
	//Actualiza stock
	public static void actualizarStock(int id, int unidades) {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		Producto producto = recuperarProducto(id);// new Album(id);
		if (producto == null) {
			System.out.println("No existe el producto");
		} else {
	
			producto.setStock(producto.getStock()-unidades);
			
			session.update(producto);// Modifica el objeto con Id indicado
			session.getTransaction().commit(); // Materializa la transaccion
		}
		session.close();
	}
		
		


	public static Producto getProductoById(int id) {
		for(int i = 0; i<getProductos().size();i++) {
			Producto producto = getProductos().get(i);
			if(producto.getId()== id) {
				return producto;
			}
		}
		 return null;
	}
	
	
}

