package curso.java.tienda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.model.pedido.DetallePedido;
import curso.java.tienda.model.producto.Producto;
import curso.java.tienda.model.producto.ProductoDAO;


/**
 * Servlet implementation class Inicio
 */
@WebServlet("")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//se inicializa el carrito y se guarda en sesion
		ArrayList<DetallePedido> carrito = (ArrayList<DetallePedido>) request.getSession().getAttribute("carrito");
		if(carrito == null) {
			carrito = new ArrayList<DetallePedido>();
			request.getSession().setAttribute("carrito", carrito);
		}
		
	
		//Se carga el catalogo de productos
		 List<Producto> listado = ProductoDAO.getProductos();
		//ArrayList<Producto> listado = new ProductoDAO().getListaProductos();
		request.setAttribute("listadoProductos", listado);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
