<?php
require_once 'header.php';
?>
<div id="login">
<h1>Inicio de Sesión</h1>
<form action="usuarios" method="post">
<input type="text" name="usuario" class="usuario" placeholder="Ingrese el correo electronico" required /><br><br>
<input type="password" name="pass" class="pass" placeholder="Ingrese la contraseña" required /><br><br>
<select class="rol" name="rol">
  <option value="Coordinador">Coordinador</option>
  <option value="Docente">Docente</option>
  <option value="Estudiante">Estudiante</option>
  <option value="Administrador">Administrador</option>
</select><br><br>
<input type="submit" name="sesion" value="Ingresar"><br><br>
</form>
</div>
<?php
require_once 'footer.php';
?>
