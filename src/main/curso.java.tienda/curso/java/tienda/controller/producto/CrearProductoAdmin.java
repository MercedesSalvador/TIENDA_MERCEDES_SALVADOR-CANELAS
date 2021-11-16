package curso.java.tienda.controller.producto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.model.producto.Producto;
import curso.java.tienda.model.producto.ProductoDAO;
import curso.java.tienda.model.usuario.Rol;
import curso.java.tienda.model.usuario.RolDAO;
import curso.java.tienda.model.usuario.Usuario;
import curso.java.tienda.model.usuario.UsuarioDAO;


/**
 * Servlet implementation class Alta
 */
@WebServlet("/crearProductoAdmin")
public class CrearProductoAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearProductoAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/jsp/admin/crearProducto.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		double precio= Double.parseDouble(request.getParameter("precio"));
		int stock = new Integer(request.getParameter("stock")).intValue();
			
		Producto producto = new Producto(nombre, descripcion, precio, stock);
		
		if(!ProductoDAO.existeProducto(producto)) {
			request.setAttribute("producto", producto);
			ProductoDAO dao = new ProductoDAO();
			dao.setProducto(new Producto(nombre, descripcion, precio, stock));
			request.getRequestDispatcher("/catalogoAdmin").forward(request, response);
		}
	
		else {
			String mensaje = "El producto ya existe";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("/jsp/admin/crearProducto.jsp").forward(request, response);
			
		}
	}
}



