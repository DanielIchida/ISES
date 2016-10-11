<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="Login" method="post">
    <input type="text" placeholder="nombre" name="user" required><br><br>
    <input type="password" placeholder="clave" name="pass" required><br><br>
   <select name="rol" id="rol">
	<option value="ADMIN">Administrador</option>
	<option value="USUARIO">Usuario</option>
   </select><br><br>
   <button type="submit">Enviar</button>
   <button type="reset">Borrar</button>
</form>
<a href="invitado.jsp">Ingresar como invitado</a>
</body>
</html>