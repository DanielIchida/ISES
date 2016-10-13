<?php namespace vistas\docentes;
   use controladores\usuariosControlador as usuariosControlador;
?>
<div class="content-perfil">
<h1>Docentes</h1>
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
         <p>Registrar notas</p>
       </div>
       <div class="col-sm-4">
         <p>Materias Asignadas</p>
       </div>
       <div class="col-sm-4">
         <p>Buscar Notas</p>
       </div>
   </div>
</div>
</div>
