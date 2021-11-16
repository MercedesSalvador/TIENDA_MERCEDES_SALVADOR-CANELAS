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
@WebServlet("/historialdp")
public class Historialdp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Historialdp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id_pedido = new Integer(request.getParameter("id")).intValue();

		
		List<DetallePedido> listado_dp = (List<DetallePedido>) DetallePedidoDAO.recuperarDetallePedidoId(id_pedido);
		
		request.setAttribute("historialdp", listado_dp);	
			
		
		request.getRequestDispatcher("/jsp/pedido/detallePedido.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
