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
import curso.java.tienda.model.usuario.Usuario;
import curso.java.tienda.model.usuario.UsuarioDAO;



/**
 * Servlet implementation class AdminUsuario
 */
@WebServlet("/editarPedidoAdmin")
public class EditarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacion = request.getParameter("op");

		int id_pedido = new Integer(request.getParameter("id")).intValue();
		
		
		PedidoDAO dao = new PedidoDAO();
		
		if(operacion.equals("edit")) {
			// recupero el pedido y lo redirijo a la pagina de editar
			Pedido pedido = dao.recuperarPedido(id_pedido);
			request.setAttribute("pedido", pedido);
			request.getRequestDispatcher("/jsp/admin/editarPedido.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
