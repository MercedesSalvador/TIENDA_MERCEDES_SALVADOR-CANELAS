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


/**
 * Servlet implementation class catalogo
 */
@WebServlet("/catalogoAdmin")
public class CatalogoAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogoAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
	}
    
  /*  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
	}*/
    	
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Producto> listado = ProductoDAO.getProductos();

    
		request.setAttribute("listadoProductos", listado);
		
		
		
		request.getRequestDispatcher("/jsp/admin/listProductos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	


}
