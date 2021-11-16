package curso.java.tienda.controller.usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.model.usuario.Usuario;
import curso.java.tienda.model.usuario.UsuarioDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Usuario> listaUsuarios = UsuarioDAO.getUsuarios();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(request, response);
		response.sendRedirect(request.getContextPath() + "/jsp/usuario/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String clave = request.getParameter("clave");
	

		Usuario usuario = new Usuario(email,clave);
		if (!email.equals("") && !clave.equals("")) {
			usuario = UsuarioDAO.comprobarLogin(usuario);
			if (usuario != null) {
				request.getSession().setAttribute("usuario", usuario);
				// si usuario es admin -> redirijo a pagina admin.jsp (una nueva)
				if(usuario.getId_rol()==1) { //USUARIO ADMIN
					request.getRequestDispatcher("/jsp/admin/admin.jsp").forward(request, response);

				}else {
					response.sendRedirect(request.getContextPath());
				}
				
			} else {
				String mensaje = "Nombre y/o contraseña incorrectos";
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("/jsp/usuario/login.jsp").forward(request, response);
				
			}
		}

	}
}
