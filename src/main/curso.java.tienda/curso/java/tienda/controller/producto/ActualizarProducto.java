package curso.java.tienda.controller.producto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.model.producto.ProductoDAO;
import curso.java.tienda.model.usuario.UsuarioDAO;

/**
 * Servlet implementation class ActualizarUsuario
 */
@WebServlet("/actualizarProductoAdmin")
public class ActualizarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		double precio = Double.parseDouble(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
		int id = Integer.parseInt(request.getParameter("id"));
	
				

		
		ProductoDAO.editarProducto(id,id_categoria, nombre, descripcion, precio, stock);
		
		
		response.sendRedirect(request.getContextPath() +"/catalogoAdmin");
	
	}

}
