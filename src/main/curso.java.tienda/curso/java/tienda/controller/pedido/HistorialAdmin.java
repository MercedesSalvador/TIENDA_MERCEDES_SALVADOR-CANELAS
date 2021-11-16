package curso.java.tienda.controller.pedido;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.model.pedido.Pedido;
import curso.java.tienda.model.pedido.PedidoDAO;
import curso.java.tienda.model.producto.Producto;
import curso.java.tienda.model.producto.ProductoDAO;
import curso.java.tienda.model.usuario.Usuario;
import curso.java.tienda.model.usuario.UsuarioDAO;

/**
 * Servlet implementation class Pedido
 */
@WebServlet("/historialAdmin")
public class HistorialAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistorialAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		List<Pedido> listado = PedidoDAO.getPedidos();
		
		request.setAttribute("historial", listado);
		
		
		request.getRequestDispatcher("/jsp/admin/historialAdmin.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
