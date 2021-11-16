package curso.java.tienda.model.pedido;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import curso.java.tienda.model.producto.Producto;
import curso.java.tienda.model.usuario.Usuario;
import curso.java.tienda.util.HibernateManager;

public class PedidoDAO {
	
	public static int setPedido(Pedido pedido) {
		//Transaction tx = null;
		Session session = HibernateManager.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); // Crea una transacci�n
		int i = (int)session.save(pedido);// Guarda el objeto creado en la BBDD.
		tx.commit(); // Materializa la transacciOn
		session.close();
		return i;
	}
	
	public static List<Pedido> getPedidos() {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT p from Pedido p");
		List<Pedido> listaPedidos= q.list();
		session.close();
		return listaPedidos;
	}
	
	// Recupera un pedido cuyo id se pasa como parametro
	public static Pedido recuperarPedido(int id) {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		Pedido pedido = (Pedido) session.get(Pedido.class, id);
		if (pedido == null) {
			System.out.println("No existe el pedido");
		} else {
			System.out.println("usuario: " + pedido.getId());
		} 
		session.close();
		return pedido;
	}
	
	// Modifica un pedido cuyo id se pasa como parametro
	public static void editarPedido(int id, String estado) {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		Pedido pedido = recuperarPedido(id);// new Album(id);
		if (pedido == null) {
			System.out.println("No existe el pedido");
		} else {
			pedido.setEstado(estado);
			session.update(pedido);// Modifica el objeto con Id indicado
			session.getTransaction().commit(); // Materializa la transaccion
		}
		session.close();
	}
	
	
	
	

}
