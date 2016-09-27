<%--
  Created by IntelliJ IDEA.
  User: ing-daniel
  Date: 20/09/2016
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Pagina jsp</title>
  </head>
  <body>
  <form action="Sesion" method="POST">
    <input type="text" placeholder="nombre" name="user" required><br><br>
    <input type="password" placeholder="clave" name="pass" required><br><br>
    <button type="submit">Enviar</button>
    <button type="reset">Borrar</button>
  </form>
  </body>
</html>
