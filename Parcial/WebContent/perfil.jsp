<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parcial</title>
</head>
<body>
<%
int id = (Integer)request.getAttribute("id");
String nombre = (String)request.getAttribute("nombre");
String rol =  (String)request.getAttribute("rol");
boolean crud = (Boolean)request.getAttribute("crud");
boolean pedidos = (Boolean)request.getAttribute("pedidos");
boolean productos = (Boolean)request.getAttribute("productos");
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
<ul>
<li>CRUD: <% out.println(crud); %></li>
<li>PEDIDOS: <% out.println(pedidos); %></li>
<li>PRODUCTOS: <% out.println(productos); %></li>
</ul>
<a href="index.jsp">Cerrar sesión</a>
</body>
</html>