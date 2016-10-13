<?php namespace vistas\coordinadores;
   use controladores\usuariosControlador as usuariosControlador;
?>
<div class="content-perfil">
<h1>Coordinador</h1>
    <?php
    echo "<h3>" . $login['nombre'] . "</h3>";
    ?>
<script>
window.onload = function(){
    killerSession();
}
function killerSession(){
setTimeout("window.open('http://localhost:9090/sica/usuarios/logout','_top');",300000);
}
</script>
<a href="http://localhost:9090/sica/usuarios/logout">Cerrar Sesion</a>
<div class="container-fluid menu-opciones">
     <div class="row">
       <div class="col-sm-4">
         <a href="http://localhost:9090/sica/coordinadores/materias"><p>Registrar Materias</p></a>
       </div>
       <div class="col-sm-4">
          <p>Registrar Carreras</p>
       </div>
       <div class="col-sm-4">
          <p>Registrar Estudiantes</p>
       </div>
       <div class="col-sm-4">
         <p>Registrar Docentes</p>
       </div>
       <div class="col-sm-4">
           <p>Asignacion de materia por estudiantes</p>
       </div>
       <div class="col-sm-4">
          <p>Asignacion de materia por docentes</p>
       </div>
       <div class="col-sm-4">
          <p>Verificacion de notas</p>
       </div>
       <div class="col-sm-4">
          <p>Busquedas</p>
       </div>
   </div>
</div>
</div>
