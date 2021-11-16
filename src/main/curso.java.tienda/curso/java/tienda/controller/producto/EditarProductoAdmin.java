package curso.java.tienda.controller.producto;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.model.producto.Producto;
import curso.java.tienda.model.producto.ProductoDAO;
import curso.java.tienda.model.usuario.Usuario;
import curso.java.tienda.model.usuario.UsuarioDAO;



/**
 * Servlet implementation class AdminUsuario
 */
@WebServlet("/editarProductoAdmin")
public class EditarProductoAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProductoAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacion = request.getParameter("op");

		int id_producto = new Integer(request.getParameter("id")).intValue();
		
	
		
		ProductoDAO dao = new ProductoDAO();
		
		if(operacion.equals("edit")) {
			// recupero el usuario y lo redirijo a la pagina de editar
			Producto producto = dao.recuperarProducto(id_producto);
			
			request.setAttribute("producto", producto);

			request.getRequestDispatcher("/jsp/admin/editarProducto.jsp").forward(request, response);
		}
		else if(operacion.equals("remove")){
			dao.borrarProducto(id_producto);
			request.getRequestDispatcher("jsp/admin/listProductos.jsp").forward(request, response);
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
