<?php namespace vistas\adminitrador;
   use controladores\usuariosControlador as usuariosControlador;
?>
<div class="content-perfil">
<h1>Administrador</h1>
<?php
   echo "<h3>" . $login['nombre'] . "</h3>";
?>
<script>
window.onload = function(){killerSession();}
function killerSession(){
setTimeout("window.open('http://localhost:9090/sica/usuarios/logout','_top');",300000);
}
</script>
<a href="http://localhost:9090/sica/usuarios/logout">Cerrar Sesion</a>
<div class="container-fluid menu-opciones">
     <div class="row">
       <div class="col-sm-4">
         <ul>
         <li>Estudiantes</li>
         <li>Docentes</li>
         <li>Coordinador</li>
         <li>Materias</li>
         <li>Carreras</li>
         <li>Asignaciones</li>
         </ul>
       </div>
       <div class="col-sm-8">
       </div>
   </div>
</div>
</div>
