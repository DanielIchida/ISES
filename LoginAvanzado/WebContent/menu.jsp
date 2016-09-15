<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>
<h1 class="correcto">Bienvenido:</h1>
<%
String usuario = (String)request.getAttribute("usuario");
boolean editar = (Boolean)request.getAttribute("editar");
boolean buscar = (Boolean)request.getAttribute("buscar");
boolean borrar = (Boolean)request.getAttribute("borrar");
boolean insertar = (Boolean)request.getAttribute("insertar");
boolean comprar = (Boolean)request.getAttribute("comprar");
boolean pedidos = (Boolean)request.getAttribute("pedidos");
out.println("<h2>"+usuario+"</h2>");
%>
<ul>
	<il><button <% if(editar == true ){ out.print("enabled"); }else{out.print("disabled");}%>>Editar</button></il>
	<il><button <% if(buscar == true ){ out.print("enabled"); }else{out.print("disabled");}%>>Buscar</button></il>
	<il><button <% if(borrar == true ){ out.print("enabled"); }else{out.print("disabled");}%>>Borrar</button></il>
	<il><button <% if(insertar == true ){ out.print("enabled"); }else{out.print("disabled");}%>>Insertar</button></il>
	<il><button <% if(comprar == true ){ out.print("enabled"); }else{out.print("disabled");}%>>Comprar</button></il>
	<il><button <% if(pedidos == true ){ out.print("enabled"); }else{out.print("disabled");}%>>Pedidos</button></il>
</ul>
<a href="usuarioRol.jsp">Cerrar Sesion</a>
</body>
</html>