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
 * Servlet implementation class Actualizar
 */
@WebServlet("/Actualizar")
public class Actualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Actualizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String usuario = request.getParameter("nombre");
		String contrasena = request.getParameter("pass");
		String rol = request.getParameter("rol");
		String crud = request.getParameter("crud");
		String pedidos = request.getParameter("pedidos");
		String productos = request.getParameter("productos");
		boolean c , pd , pr;
		if(crud == null){
			c = false;
		}else{
			c = true;
		}
		if(pedidos == null){
			pd = false;
		}else{
			pd = true;
		}
		if(productos == null){
			pr = false;
		}else{
			pr = true;
		}
		UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
		PrivilegiosDaoImpl privilegiosDaoImpl = new PrivilegiosDaoImpl();
		Usuario u = new Usuario();
		u.setId_usuario(Integer.parseInt(id));
		u.setNombre(usuario);
		u.setPassword(contrasena);
		u.setRol(rol);
		usuarioDaoImpl.updateData(u);
		Privilegios pv = new Privilegios();
		pv.setCrud_usuarios(c);
		pv.setMis_pedidos(pd);
		pv.setProductos(pr);
		pv.setId_usuario(Integer.parseInt(id));
		privilegiosDaoImpl.updateData(pv);
		out.println("Dato actualizado correctamente");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
