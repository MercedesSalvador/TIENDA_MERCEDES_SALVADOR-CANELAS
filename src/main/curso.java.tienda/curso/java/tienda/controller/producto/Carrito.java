package curso.java.tienda.controller.producto;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import curso.java.tienda.model.pedido.DetallePedido;

import curso.java.tienda.model.pedido.DetallePedidoDAO;
import curso.java.tienda.model.producto.Producto;
import curso.java.tienda.model.producto.ProductoDAO;
import curso.java.tienda.model.usuario.Usuario;

/**
 * Servlet implementation class ListaCompra
 */
@WebServlet("/carrito")
public class Carrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carrito() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //Añadir productos al carrito
    public void llenarLista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = new Integer(request.getParameter("id")).intValue();
    	String operacion = request.getParameter("op");

    	ArrayList<DetallePedido> carrito = (ArrayList<DetallePedido>) request.getSession().getAttribute("carrito");
    	Producto p = ProductoDAO.getProductoById(id);
    	DetallePedidoDAO dao = new DetallePedidoDAO();
    	
    	
    	if(operacion.equals("add")) {
    		dao.addCarrito(p.getId(), carrito);
    	}else if (operacion.equals("del")) {
    		dao.eliminarProductoCarrito(p.getId(), carrito);
    	}
 
    	response.sendRedirect(request.getContextPath());

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		llenarLista(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
