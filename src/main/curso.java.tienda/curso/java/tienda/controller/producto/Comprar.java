package curso.java.tienda.controller.producto;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.model.pedido.DetallePedido;
import curso.java.tienda.model.pedido.DetallePedidoDAO;
import curso.java.tienda.model.pedido.Pedido;
import curso.java.tienda.model.pedido.PedidoDAO;
import curso.java.tienda.model.producto.Producto;
import curso.java.tienda.model.producto.ProductoDAO;
import curso.java.tienda.model.usuario.Usuario;

/**
 * Servlet implementation class Compra
 */
@WebServlet("/comprar")
public class Comprar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Comprar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<DetallePedido> carrito = (ArrayList<DetallePedido>) request.getSession().getAttribute("carrito");
		// Se recoge el usuario de la sesión activa para mas tarde coger el id_Usuario y pasarselo al pedido
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
	
		String total = (String) request.getSession().getAttribute("totalCarrito");
		String metodoPago = request.getParameter("metodo_pago");
		double tot = Double.parseDouble(total);
		if (carrito.size() > 0) {
			//Se comprueba si el usuario esta logado
			if (usuario != null) {
				if(metodoPago !=null) {
					//Se crea el pedido y se guarda en BBDD
					Pedido pedido = new Pedido();
					pedido.setId_usuario(usuario.getId());
					pedido.setMetodo_pago(metodoPago);
					pedido.setEstado("pendiente");//Por defecto el pedido del cliente se crea en estado pendiente
					pedido.setTotal(tot);
					//asigno la variable id del pedido con id_pedido que me servira para pasarsela a DetallesPedido
					int id_pedido = PedidoDAO.setPedido(pedido);
					
					// Se recorre el carrito para insertar DetallePedido en BBDD
					for (DetallePedido dp : carrito) {
						//DetallePedido detallePedido = new DetallePedido();
						
						dp.setId_pedido(id_pedido);
						dp.getNombre_producto();
						dp.getId_producto();
						dp.getPrecio_unidad();
						dp.getUnidades();
						dp.getTotal();
						DetallePedidoDAO.setDetallePedido(dp);
					}
					for (DetallePedido dp : carrito) {
						ProductoDAO.actualizarStock(dp.getId_producto(), dp.getUnidades());
						
					}
				
					request.getSession().setAttribute("carrito", null);
					request.getSession().setAttribute("mensaje", "Compra realizada correctamente con importe total de: " + total +"€");
					response.sendRedirect(request.getContextPath() + "/jsp/catalogo/compraFinalizada.jsp");
				}else {
					request.setAttribute("msg", "No has seleccionado un metodo de pago");
					response.sendRedirect(request.getContextPath() + "/jsp/catalogo/carrito.jsp");
				}
				
			} else {
				response.sendRedirect(request.getContextPath() + "/jsp/usuario/login.jsp");
			}
		} else {
			request.getSession().setAttribute("mensaje", "No se ha añadido ningun producto.");
			response.sendRedirect(request.getContextPath() + "/jsp/catalogo/compraFinalizada.jsp");
		}
	}
}
	
	
	

