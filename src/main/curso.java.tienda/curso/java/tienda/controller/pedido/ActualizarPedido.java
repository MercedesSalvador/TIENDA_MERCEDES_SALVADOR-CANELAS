package curso.java.tienda.controller.pedido;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.model.pedido.PedidoDAO;
import curso.java.tienda.model.usuario.UsuarioDAO;

/**
 * Servlet implementation class ActualizarUsuario
 */
@WebServlet("/actualizarPedido")
public class ActualizarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect(request.getContextPath() + "jsp/usuario/lista.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String estado = request.getParameter("estado");

		int id = new Integer(request.getParameter("id")).intValue();
		
		
		PedidoDAO.editarPedido(id, estado);

		
		response.sendRedirect(request.getContextPath() +"/historialAdmin");
	
	}

}
