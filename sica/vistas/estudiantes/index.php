<?php namespace vistas\estudiantes;
?>
<div class="content-perfil">
<h1>Estudiante</h1>
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
<div class="container-fluid menu-opciones" ng-app="notas">
     <div class="row">
       <div class="col-sm-4" data-toggle="modal" data-target="#myModal">
         <p>Notas de mis materias</p>
       </div>
       <div class="col-sm-4" data-toggle="modal" data-target="#myModal2">
           <p>Estado de mis materias</p>
       </div>
       <div class="col-sm-4" data-toggle="modal" data-target="#myModal3">
           <p>Horarios</p>
       </div>
   </div>
    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content" ng-controller="misNotas">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Notas de mis Materias</h4>
                </div>
                <div class="modal-body">
                     <table id="mis-materias">
                         <tr>
                             <th>Corte</th>
                             <th>Materia</th>
                             <th>Porcentajes</th>
                             <th>Notas</th>
                         </tr>
                         <?php
                            $url_notas = URL . "estudiantes/misNotas/".$login['id'];
                         ?>
                         <script type="text/javascript">
                         var url_n ="<?php echo $url_notas; ?>";
                         var app = angular.module('notas', []);
                         app.controller('misNotas', function($scope, $http) {
                             $http.get(url_n).then(function(response) {
                                 $scope.myData2 = response.data;
                             });
                         });
                         </script>
                         <tr ng-repeat="x in myData2">
                             <td>{{x.corte}}</td>
                             <td>{{x.nombre_materia}}</td>
                             <td>{{x.porcentaje}}</td>
                             <td>{{x.nota}}</td>
                         </tr>
                     </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>


    <!-- Modal 2-->
    <div class="modal fade" id="myModal2" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content" ng-controller="misMaterias">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Estado de mis materias</h4>
                </div>
                <div class="modal-body">
                    <table id="mis-materias">
                        <tr>
                            <th>Id</th>
                            <th>Materia</th>
                            <th>Promedio</th>
                            <th>Estado</th>
                        </tr>
                        <?php
                        $url_materias = URL . "estudiantes/estadoMaterias/".$login['id'];
                        ?>
                        <script type="text/javascript">
                            var url_m ="<?php echo $url_materias; ?>";
                            app.controller('misMaterias', function($scope, $http) {
                                $http.get(url_m).then(function(response) {
                                    $scope.myData = response.data;
                                });
                            });
                        </script>
                        <tr ng-repeat="y in myData">
                            <td>{{y.id}}</td>
                            <td>{{y.nombre}}</td>
                            <td>{{y.promedio}}</td>
                            <td>{{y.estado}}</td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>


    <!-- Modal 3-->
    <div class="modal fade" id="myModal3" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content" ng-controller="misHorarios">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Estado de mis materias</h4>
                </div>
                <div class="modal-body">
                    <table id="mis-materias">
                        <tr>
                            <th>Id</th>
                            <th>Materia</th>
                            <th>Promedio</th>
                            <th>Estado</th>
                        </tr>
                        <?php
                        $url_horarios = URL . "estudiantes/verHorarios/".$login['id'];
                        ?>
                        <script type="text/javascript">
                            var url_h ="<?php echo $url_horarios; ?>";
                            app.controller('misHorarios', function($scope, $http) {
                                $http.get(url_h).then(function(response) {
                                    $scope.myData3 = response.data;
                                });
                            });
                        </script>
                        <tr ng-repeat="y in myData3">
                            <td>{{y.id}}</td>
                            <td>{{y.nombre}}</td>
                            <td>{{y.dia}}</td>
                            <td>{{y.horario}}</td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

</div>
</div>


