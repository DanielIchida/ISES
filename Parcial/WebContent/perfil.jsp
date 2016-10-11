<%@page import="pojo.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parcial</title>
<script src="js/jquery.min.js"></script>
<script src="js/eventos.js"></script>
</head>
<body>
<% 
int id = (Integer)session.getAttribute("id");
String nombre = (String)session.getAttribute("nombre");
String rol =  (String)session.getAttribute("rol");
boolean crud = (Boolean)session.getAttribute("crud");
boolean pedidos = (Boolean)session.getAttribute("pedidos");
boolean productos = (Boolean)session.getAttribute("productos");
%>
<h3><b>Usuario: </b><% out.println(nombre); %></h3>
<p><% 
if(rol.equals("ADMIN")){
	out.println("Administrador");
}else if(rol.equals("USUARIO")){
	out.println("Usuario");
}else{
	out.println("Invitado");
}
%></p>
<%
if(crud == true){
	List<Usuario> usuarios = (List<Usuario>)session.getAttribute("usuarios");
%>
<H4>Agregar Nuevo Usuario</H4>
<form action="Insertar" method="post">
<input type="text" name="id" placeholder="Ingresar Identificacion"/><br><br>
<input type="text" name="nombre" placeholder="Ingresar Nombre"/><br><br>
<input type="text" name="pass"  placeholder="Ingresar contraseña"/><br><br>
<select name="rol" id="rol">
	<option value="ADMIN">Administrador</option>
	<option value="USUARIO">Usuario</option>
</select><br>
<h5>Permisos del Usuario</h5>
<label>CRUD usuarios</label>
<input type="checkbox" name="crud" />
<label>Pedidos</label>
<input type="checkbox" name="pedidos" />
<label>Productos</label>
<input type="checkbox" name="productos" /><br>
<input type="submit" value="Insertar" /></form><br><br>
<table>
<tr>
<th>ID</th>
<th>Nombre</th>
<th>Contraseña</th>
<th>Rol</th>
<th></th>
<th></th>
</tr>
<%
for(Usuario u : usuarios){
	out.println("<tr>");
	out.println("<td>"+u.getId_usuario()+"</td>");
	out.println("<td>"+u.getNombre()+"</td>");
	out.println("<td>"+u.getPassword()+"</td>");
	out.println("<td>"+u.getRol()+"</td>");
	out.println("<td><button onclick='borrar("+u.getId_usuario()+")'>Eliminar</button></td>");
	out.println("<td><a href='Editar?id="+u.getId_usuario()+"'>Actualizar</a></td>");
}
%>
</table>
<%
}else{
%>
<%
}
%>
<%
if(pedidos == true){
%>
<button>Mis Pedidos</button>
<%
}else{
%>
<%
}
%>
<%
if(productos == true){
%>
<button>Productos</button>
<%
}else{
%>
<%
}
%>
<a href="index.jsp">Cerrar sesión</a>
</body>
</html>