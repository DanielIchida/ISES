<?php namespace controladores;

	use modelos\Coordinador as Coordinador;
    use modelos\Materia as Materia;

class coordinadoresControlador{

		private $coor;
        private $mat;

		public function __construct(){
			$this->coor = new Coordinador();
            $this->mat = new Materia();
		}

		public function index(){

		}

		function insertForm(){
		    if($_POST){
                $this->mat->set("id_materia",$_POST['codigo']);
                $this->mat->set("nombre",$_POST['nombre']);
                $this->mat->set("dia",$_POST['dia']);
                $this->mat->set("horario",$_POST['horario']);
                $this->mat->insertar();
                echo "<script type='application/javascript'>alert('datos subidos correctamente');</script>";
                header('Location: http://localhost:9090/sica/coordinadores/materias');
            }else{
                echo "error para acceder a este servicio";
                header('Location: http://localhost:9090/sica/coordinadores/materias');
            }
        }

		public function insertMat(){
            if($_POST){
                $tipo = $_FILES['archivo']['type'];

                $tamanio = $_FILES['archivo']['size'];

                $archivotmp = $_FILES['archivo']['tmp_name'];

                $lineas = file($archivotmp);

                $i=0;

                foreach ($lineas as $linea_num => $linea)
                {
                    if($i != 0)
                    {
                        $datos = explode(";",$linea);
                        $id = trim($datos[0]);
                        $nombre = trim($datos[1]);
                        $dia = trim($datos[2]);
                        $horario = trim($datos[3]);
                        $this->mat->set("id_materia",$id);
                        $this->mat->set("nombre",$nombre);
                        $this->mat->set("dia",$dia);
                        $this->mat->set("horario",$horario);
                        $this->mat->insertar();
                    }
                    $i++;
                }
                echo "<script type='application/javascript'>alert('datos subidos correctamente');</script>";
                header('Location: http://localhost:9090/sica/coordinadores/materias');
            }else{
                echo "error para acceder a este servicio";
                header('Location: http://localhost:9090/sica/coordinadores/materias');
            }
        }

		public function materias(){
                session_start();
		        if(!isset($_SESSION['autenticado'])){
                    header('Location: http://localhost:9090/sica/');
                }else{
                    require_once 'vistas/header.php';
                    require_once 'vistas/coordinadores/materias.php';
                    require_once 'vistas/footer.php';
                }



        }
}
