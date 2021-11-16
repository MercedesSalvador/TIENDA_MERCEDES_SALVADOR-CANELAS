package curso.java.tienda.model.usuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import curso.java.tienda.util.HibernateManager;


public class RolDAO {
	//private Session session = HibernateUtil.getSessionFactory().openSession();
	
	public static void setRol(Rol rol) {
		//Transaction tx = null;
		Session session = HibernateManager.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); // Crea una transacci�n
		int i = (int)session.save(rol);// Guarda el objeto creado en la BBDD.
		System.out.println("Rol creado con el id: " + i);
		tx.commit(); // Materializa la transacci�n
		session.close();
	}
	
	public static List<Rol> getList(String c) {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT a from Rol a");
		List<Rol> results = q.list();

//		for(Album album : results) {
//			System.out.println(" - " + album.getTitulo() + ": " + album.getAutor());
//		}
		session.close();
		return results;
	}
	
	//LISTA DE TODOS LOS ROLES
//	public List<Rol> getAllRoles() {
//		String hQuery = "from Roles";
//		List<Rol> listaRoles= session.createQuery(hQuery, Rol.class).list();
//		return listaRoles ;
//	}

	public static void main(String[] args) {
		RolDAO dao = new RolDAO();
		dao.setRol(new Rol(1,"admin"));
		dao.setRol(new Rol(2,"cliente"));
		dao.setRol(new Rol(3,"empleado"));
		List<Rol> lista = dao.getList("SELECT a from Rol a");
		//rol.session.close();
		for(Rol rol : lista) {
			System.out.println(rol.getRol());
		}
	}

	
	
}
