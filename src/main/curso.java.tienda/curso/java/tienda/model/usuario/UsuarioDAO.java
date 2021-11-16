package curso.java.tienda.model.usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import curso.java.tienda.model.usuario.Usuario;
import curso.java.tienda.util.HibernateManager;


public class UsuarioDAO {

	
	public static void setUsuario(Usuario usuario) {
		//Transaction tx = null;
		Session session = HibernateManager.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); // Crea una transacci�n
		int i = (int)session.save(usuario);// Guarda el objeto creado en la BBDD.
		System.out.println("Usuario creado con el id: " + i);
		tx.commit(); // Materializa la transacciOn
		session.close();
	}
	
	// Recupera un usuario cuyo id se pasa como parametro
	public static Usuario recuperarUsuario(int id) {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		Usuario usuario = (Usuario) session.get(Usuario.class, id);
		if (usuario == null) {
			System.out.println("No existe el usuario");
		} else {
			System.out.println("usuario: " + usuario.getNombre());
		} 
		session.close();
		return usuario;
	}
	
	// Modifica un usuario cuyo id se pasa como parametro
	public static void editarUsuario(int id, String nombre, String apellido1, String apellido2, String calle,
			String localidad, String provincia,String telefono, String dni) {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		Usuario usuario = recuperarUsuario(id);
		if (usuario == null) {
			System.out.println("No existe el usuario");
		} else {
			usuario.setNombre(nombre);
			usuario.setApellido1(apellido1);
			usuario.setApellido2(apellido2);
			usuario.setCalle(calle);
			usuario.setTelefono(telefono);
			usuario.setLocalidad(localidad);
			usuario.setProvincia(provincia);
			usuario.setDni(dni);
			session.update(usuario);// Modifica el objeto con Id indicado
			session.getTransaction().commit(); // Materializa la transaccion
		}
		session.close();
	}

	
	// Borrar un usuariro cuyo id se pasa como parametro
	public static void borrarUsuario(int id) {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		Usuario usuario = recuperarUsuario(id);
		if(usuario != null) {
			session.delete(usuario);
		}
		session.getTransaction().commit(); // Materializa la transaccion

		session.close();
	}

	// Recupera un usuario cuyo email se pasa como parametro
	public static Usuario recuperarUsuarioEmail(String email) {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("SELECT u from Usuario u WHERE email = '" + email + "'");
		List<Usuario> results = q.list();
		
		if (results == null) {
			System.out.println("No existe el usuario");
		} else {
			System.out.println("usuario: " +  results.get(0).getNombre());
		} 
		session.close();
		return results.get(0);
	}


	public static List<Usuario> getUsuarios() {
		Session session = HibernateManager.getSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT u from Usuario u");
		List<Usuario> listaUsuarios= q.list();
		session.close();
		return listaUsuarios;
	}
		
		
	public static Usuario comprobarLogin(Usuario usuario) {
		boolean existe = false;	
		for(Usuario u: getUsuarios()) {
			String email = u.getEmail();
			String clave=u.getClave();
			if(email.equals(usuario.getEmail()) && clave.equals(usuario.getClave())) {
				
				return recuperarUsuarioEmail(email);
			}
		}
		return null;
	}
	
	//COMPROBAR SI EXISTE USUARIO - PARA DAR DE ALTA
	public static boolean existeUsuario(Usuario usuario) {
		boolean existe = false;	
		
		for(Usuario u: getUsuarios()) {
			
			String clave=u.getClave();
			String email = u.getEmail();
			
			if(email.equals(usuario.getEmail())) {
				existe=true;
			}		
		}
		return existe;
	}

	
	
}
