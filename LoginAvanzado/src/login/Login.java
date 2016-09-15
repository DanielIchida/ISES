package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String usuario = request.getParameter("user");
		String contrasena = request.getParameter("pass");
		String rol = request.getParameter("rol");
		if(usuario.equals("admin") && contrasena.equals("12345") && rol.equals("admin")){
			request.setAttribute("usuario",usuario);
			request.setAttribute("editar", true);
			request.setAttribute("buscar", true);
			request.setAttribute("borrar", true);
			request.setAttribute("insertar", true);
			request.setAttribute("comprar", false);
			request.setAttribute("pedidos", false);
		    request.getRequestDispatcher("menu.jsp").forward(request, response);
		}else if(usuario.equals("daniel") && contrasena.equals("12345") && rol.equals("usuario")){
			request.setAttribute("usuario",usuario);
			request.setAttribute("editar", false);
			request.setAttribute("buscar", false);
			request.setAttribute("borrar", false);
			request.setAttribute("insertar", false);
			request.setAttribute("comprar", true);
			request.setAttribute("pedidos", true);
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		
	}

}
