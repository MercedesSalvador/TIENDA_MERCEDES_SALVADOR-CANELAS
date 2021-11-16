package curso.java.tienda.model.pedido;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import curso.java.tienda.model.producto.Producto;
import curso.java.tienda.model.producto.ProductoDAO;
import curso.java.tienda.model.usuario.Usuario;
import curso.java.tienda.util.HibernateManager;



public class DetallePedidoDAO {
	
	public static int setDetallePedido(DetallePedido dp) {
		//Transaction tx = null;
		Session session = HibernateManager.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); // Crea una transaccion
		int i = (int)session.save(dp);// Guarda el objeto creado en la BBDD.
		tx.commit(); // Materializa la transacciOn
		session.close();
		return i;
	}
	

	
		public boolean existeProductoCarrito(int id, ArrayList<DetallePedido> carrito) {
			boolean existe = false;
			for(int i=0;i<carrito.size();i++) {
				//consigo el id del producto que ya hay en el carrito
				DetallePedido detalle = carrito.get(i);
				int id_producto = detalle.getId_producto(); 
				if(id_producto==id) {
					existe = true;
				}
		}
			
			return existe;
		}
		
		public DetallePedido recuperarDetallePedido(int id, ArrayList<DetallePedido> carrito) {
			for(int i=0; i<carrito.size();i++) {
				DetallePedido dp = carrito.get(i);
				int id_producto = dp.getId_producto();
				if(id_producto == id) {
					return carrito.get(i);
				}
			}
			return null;
		}
	
		public void addCarrito(int id_producto, ArrayList<DetallePedido> carrito) {
			Producto producto = ProductoDAO.getProductoById(id_producto);
			if(producto!=null) {
				
				DetallePedido dp = recuperarDetallePedido(id_producto, carrito);
				//if(existeProductoCarrito(id_producto, carrito)){// si existe sumo 1 unidad a la cantidad que ya exista en el carrito
				if(dp != null) {
					int ud = dp.getUnidades() + 1 ; // obtiene la cantidad de productos y le añade 1
					dp.setUnidades(ud);//modifico la cantidad de uds de la linea de pedido
					//double total = 0;
					double total = (producto.getPrecio() * ud);
					//total+=total+(producto.getPrecio()*cantidad);
					dp.setTotal(total);
					//creo una nueva linea de pedido con 1 unidad del producto	
				} else {
					dp = new DetallePedido(0, 0, id_producto, producto.getNombre(), producto.getPrecio(), 1,producto.getPrecio() );
					
					//dp.setUnidades(1);
					carrito.add(dp);
				}
			
			}

		}
		
		public void eliminarProductoCarrito(int id_producto, ArrayList<DetallePedido> carrito) {
			Producto producto = ProductoDAO.getProductoById(id_producto);
			DetallePedido dp = recuperarDetallePedido(id_producto, carrito);
			if(dp.getUnidades()==1) {
				for(int i=0;i<carrito.size();i++) {
					carrito.remove(i);
				}
			} else {
				int ud = dp.getUnidades() -1;
				dp.setUnidades(ud);
				double total = (producto.getPrecio() * ud);
				dp.setTotal(total);
			}
				
			
		}

		public static List<DetallePedido> getListDetallPedid() {
			Session session = HibernateManager.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("SELECT p from DetallePedido p");
			List<DetallePedido> listaDetallePedi= q.list();
			session.close();
			return listaDetallePedi;
		}
		
		/** Recupera una lista de detalle de pedido cuyo id de pedido se pasa como parámetro
		 * 
		 * @param email
		 * @return
		 */
		public static List<DetallePedido> recuperarDetallePedidoId(int id_pedido) {
			Session session = HibernateManager.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("SELECT u from DetallePedido u WHERE id_pedido = '" + id_pedido + "'");
			List<DetallePedido> results = q.list();
			if (results == null) {
				System.out.println("No hay detalles de pedido");
			} else {
				System.out.println("dp: " + results.get(0).getId_pedido());
			}
			session.close();
			return results;
			}



		public DetallePedido recuperarDp(int id_pedido, List<DetallePedido> listado) {
			for (int i = 0; i < listado.size(); i++) {
				DetallePedido dp = listado.get(i);
				int id = dp.getId();
				if (id_pedido == id) {
					return listado.get(i);
				}
			}
			return null;
		}
		


	}


		

		
		




