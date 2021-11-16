package curso.java.tienda.model.producto;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import curso.java.tienda.model.usuario.Rol;
import curso.java.tienda.model.usuario.RolDAO;
import curso.java.tienda.util.HibernateManager;

public class CategoriaDAO {
	
	public static void setCategoria(Categoria categoria) {
		//Transaction tx = null;
		Session session = HibernateManager.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); // Crea una transacci�n
		int i = (int)session.save(categoria);// Guarda el objeto creado en la BBDD.
		System.out.println("categoria creado con el id: " + i);
		tx.commit(); // Materializa la transaccion
		session.close();
	}
	
	public static List<Categoria> getList(String c) {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT c from Categoria c");
		List<Categoria> results = q.list();
		session.close();
		return results;
	}


}
