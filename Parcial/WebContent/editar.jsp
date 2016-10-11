<%@page import="pojo.Privilegios"%>
<%@page import="pojo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Usuario u = (Usuario)request.getAttribute("usuario"); 
   Privilegios p = (Privilegios)request.getAttribute("privilegios");
%>
<form id="form-editar" action="Actualizar">
<p>Actualizar Usuario: <% out.print(u.getId_usuario()); %></p>
<input type="text" name="id" value="<% out.print(u.getId_usuario()); %>"/><br>
<input type="text" name="nombre" value="<% out.print(u.getNombre()); %>"/><br>
<input type="text" name="pass" value="<% out.print(u.getPassword()); %>"/><br>
<select name="rol">
<% if(u.getRol().equals("ADMIN")){%>
    <option value="ADMIN">Administrador</option>
	<option value="USUARIO">Usuario</option>
<% }else{ %>
    <option value="USUARIO">Usuario</option>
    <option value="ADMIN">Administrador</option>
<% } %>
</select><br>
<p>Permisos de usuario</p>
<label>CRUD usuarios</label>
<% if(p.isCrud_usuarios() == true){%>
   <input type="checkbox" name="crud" checked />
<% }else{ %>
   <input type="checkbox" name="crud" />
<% } %>
<label>Pedidos</label>
<% if(p.isMis_pedidos() == true){%>
   <input type="checkbox" name="pedidos" checked />
<% }else{ %>
   <input type="checkbox" name="pedidos" />
<% } %>
<label>Productos</label>
<% if(p.isProductos() == true){%>
   <input type="checkbox" name="productos" checked />
<% }else{ %>
   <input type="checkbox" name="productos" />
<% } %>
<input type="submit" value="Actualizar"/>
</form>
</body>
</html>