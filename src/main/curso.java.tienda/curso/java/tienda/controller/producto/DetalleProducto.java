package curso.java.tienda.controller.producto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.model.producto.Producto;
import curso.java.tienda.model.producto.ProductoDAO;

/**
 * Servlet implementation class DetalleProducto
 */
@WebServlet("/detalleProducto")
public class DetalleProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Producto producto = new Producto();

		producto = ProductoDAO.recuperarProducto(id);
		
		request.setAttribute("producto", producto);
		
		//response.sendRedirect(request.getContextPath() + "/jsp/catalogo/detalleProducto.jsp" );
		
		request.getRequestDispatcher("/jsp/catalogo/detalleProducto.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
