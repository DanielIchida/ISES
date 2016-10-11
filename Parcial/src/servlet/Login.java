package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.PrivilegiosDaoImpl;
import modelo.UsuarioDaoImpl;
import pojo.Privilegios;
import pojo.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("user");
		String contrasena = request.getParameter("pass");
		String rol = request.getParameter("rol");
		HttpSession session = request.getSession(true);
		session.setAttribute("nombre",usuario);
		session.setAttribute("rol",rol);
		session.setAttribute("contra", contrasena);
			UsuarioDaoImpl daoImpl = new UsuarioDaoImpl();
			PrivilegiosDaoImpl privilegiosDaoImpl = new PrivilegiosDaoImpl();
			Usuario usu = new Usuario();
			usu.setNombre((String) session.getAttribute("nombre"));
			usu.setPassword((String) session.getAttribute("contra"));
			usu.setRol((String) session.getAttribute("rol"));
			int id = daoImpl.login(usu);
			if(id != 0){
				session.setAttribute("id",id);
				Privilegios pv = privilegiosDaoImpl.getData(id);
				session.setAttribute("id_pv",pv.getId_privilegio());
				session.setAttribute("crud",pv.isCrud_usuarios());
				session.setAttribute("pedidos",pv.isMis_pedidos());
				session.setAttribute("productos",pv.isProductos());
				if(pv.isCrud_usuarios() == true){
					List<Usuario> usuarios = daoImpl.getAllData();
					session.setAttribute("usuarios",usuarios);
				}
				request.getRequestDispatcher("perfil.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
