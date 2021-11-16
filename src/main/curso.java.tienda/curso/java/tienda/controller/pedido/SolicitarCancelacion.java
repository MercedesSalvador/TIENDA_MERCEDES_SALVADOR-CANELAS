package curso.java.tienda.controller.pedido;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class Pedido
 */
@WebServlet("/solicitaCancelacion")
public class SolicitarCancelacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitarCancelacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		int id_pedido = new Integer(request.getParameter("id")).intValue();


		Pedido pedido =PedidoDAO.recuperarPedido(id_pedido);
		
	
		
		PedidoDAO.editarPedido(id_pedido,"pendiente cancelacion");

		
		
		request.getRequestDispatcher("/historial").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
