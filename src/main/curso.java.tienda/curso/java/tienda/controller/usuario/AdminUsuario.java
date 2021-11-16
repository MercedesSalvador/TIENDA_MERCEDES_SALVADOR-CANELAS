package curso.java.tienda.controller.usuario;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.model.usuario.Usuario;
import curso.java.tienda.model.usuario.UsuarioDAO;



/**
 * Servlet implementation class AdminUsuario
 */
@WebServlet("/adminUsuario")
public class AdminUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacion = request.getParameter("op");
//		String nombre = request.getParameter("nombre");
//		String apellido1 = request.getParameter("apellido1");
//		String apellido2 = request.getParameter("apellido2");
//		String email = request.getParameter("email");
//		String clave = request.getParameter("clave");
		int id_usuario = new Integer(request.getParameter("id")).intValue();
		
		// List<Usuario> listaUsuarios = UsuarioDAO.getUsuarios("SELECT u from Usuario u");
		
		UsuarioDAO uDao = new UsuarioDAO();
		if(operacion.equals("edit")) {
			// recupero el usuario y lo redirijo a la pagina de editar
			Usuario usuario = uDao.recuperarUsuario(id_usuario);
			request.setAttribute("usuario", usuario);
			//uDao.editarUsuario(id_usuario, nombre, apellido1, apellido2, email);
			//response.sendRedirect("/jsp/usuario/editar.jsp");
			request.getRequestDispatcher("/jsp/usuario/editar.jsp").forward(request, response);
		}
		else if(operacion.equals("remove")){
			uDao.borrarUsuario(id_usuario);
			request.getRequestDispatcher("jsp/usuario/lista.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath()/jsp/usuario/lista.jsp);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
