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
@WebServlet("/opUsuarioAdmin")
public class OperacionesUsuarioAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperacionesUsuarioAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacion = request.getParameter("op");
		
		int id_usuario = Integer.parseInt(request.getParameter("id"));
		
		
	
		
		UsuarioDAO uDao = new UsuarioDAO();
		if(operacion.equals("edit")) {
			// recupero el usuario y lo redirijo a la pagina de editar
			Usuario usuario = uDao.recuperarUsuario(id_usuario);
			request.setAttribute("usuario", usuario);

			request.getRequestDispatcher("/jsp/admin/editarUsuario.jsp").forward(request, response);
		}
		else if(operacion.equals("remove")){
			uDao.borrarUsuario(id_usuario);
			request.getRequestDispatcher("/usuarioAdmin").forward(request, response);
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
