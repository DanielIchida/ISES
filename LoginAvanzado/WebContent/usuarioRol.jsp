<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<title>Escoja el rol</title>
</head>
<body>

<form action="Login" method="POST">
<input type="text" placeholder="nombre" name="user" required><br><br>
<input type="password" placeholder="clave" name="pass" required><br><br>
<select name="rol">
	<option value="admin">Administrador</option>
	<option value="usuario">Usuario</option>
</select><br><br>
<button type="submit">Enviar</button>
<button type="reset">Borrar</button>

</form>

</body>
</html>