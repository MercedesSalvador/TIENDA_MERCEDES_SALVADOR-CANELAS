package curso.java.tienda.controller.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.model.usuario.UsuarioDAO;

/**
 * Servlet implementation class ActualizarUsuario
 */
@WebServlet("/actualizarUsuarioAdmin")
public class ActualizarUsuarioAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarUsuarioAdmin() {
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
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String dni = request.getParameter("dni");
		String calle = request.getParameter("calle");
		String localidad = request.getParameter("localidad");
		String provincia = request.getParameter("provincia");
		String telefono = request.getParameter("telefono");
		//String email = request.getParameter("email");
		//String clave = request.getParameter("clave");
		
		int id =Integer.parseInt((String) request.getParameter("id"));
		
		
		UsuarioDAO.editarUsuario(id, nombre,  apellido1,  apellido2, calle, localidad, provincia, telefono,  dni);
		
		response.sendRedirect(request.getContextPath() +"/usuarioAdmin");
		//request.getRequestDispatcher("/usuario").forward(request, response);
	}

}
