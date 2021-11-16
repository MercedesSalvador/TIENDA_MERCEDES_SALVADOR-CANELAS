package curso.java.tienda.controller.usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.model.usuario.Rol;
import curso.java.tienda.model.usuario.RolDAO;
import curso.java.tienda.model.usuario.Usuario;
import curso.java.tienda.model.usuario.UsuarioDAO;


/**
 * Servlet implementation class Alta
 */
@WebServlet("/altaUsuarioAdmin")
public class AltaUsuarioAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;


       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuarioAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/jsp/admin/crearUsuario.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String calle = request.getParameter("calle");
		String telefono = request.getParameter("telefono");
		String provincia = request.getParameter("provincia");
		String localidad = request.getParameter("localidad");
		String dni = request.getParameter("dni");
		String email = request.getParameter("email");
		String clave = request.getParameter("clave");
		
		
		Usuario usuario = new Usuario( nombre, apellido1,  apellido2,  calle,  telefono,
				 provincia,  localidad,  dni,  email, clave);
		 usuario.setId_rol(2); //se crea por defecto rol cliente
		
		//Usuario usuario = new Usuario();
		if(!UsuarioDAO.existeUsuario(usuario)) { 
			request.getSession().setAttribute("usuario", usuario);
			

			UsuarioDAO.setUsuario(usuario);
			
			request.getRequestDispatcher("/jsp/admin/listaUsuarios.jsp").forward(request, response); //devuelve la raiz del proyecto
			
		}
		else {
			String mensaje = "El usuario ya existe";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("/jsp/admin/crearUsuario.jsp").forward(request, response);
		
		}
	}
}


