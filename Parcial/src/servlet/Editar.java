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
 * Servlet implementation class Editat
 */
@WebServlet("/Editar")
public class Editar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
		 PrivilegiosDaoImpl privilegiosDaoImpl = new PrivilegiosDaoImpl();
		 String id = request.getParameter("id");
		 Usuario u = usuarioDaoImpl.getData(Integer.parseInt(id));
		 Privilegios p = privilegiosDaoImpl.getData(Integer.parseInt(id));
		 request.setAttribute("usuario",u);
		 request.setAttribute("privilegios", p);
		 request.getRequestDispatcher("editar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
