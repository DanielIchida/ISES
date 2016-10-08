package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if(rol.equals("INVITADO")){
			request.getRequestDispatcher("invitado.jsp").forward(request, response);
		}else{
			UsuarioDaoImpl daoImpl = new UsuarioDaoImpl();
			PrivilegiosDaoImpl privilegiosDaoImpl = new PrivilegiosDaoImpl();
			Usuario usu = new Usuario();
			usu.setNombre(usuario);
			usu.setPassword(contrasena);
			usu.setRol(rol);
			int id = daoImpl.login(usu);
			request.setAttribute("nombre",usu.getNombre());
			request.setAttribute("rol",usu.getRol());
			if(id != 0){
				request.setAttribute("id",id);
				Privilegios pv = privilegiosDaoImpl.getData(id);
				request.setAttribute("id_pv",pv.getId_privilegio());
				request.setAttribute("crud",pv.isCrud_usuarios());
				request.setAttribute("pedidos",pv.isMis_pedidos());
				request.setAttribute("productos",pv.isProductos());
				request.getRequestDispatcher("perfil.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
