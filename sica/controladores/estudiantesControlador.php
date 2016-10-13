<?php namespace controladores;

	use modelos\Estudiante as Estudiante;

class estudiantesControlador{

		private $estudiante;

		public function __construct(){
			$this->estudiante = new Estudiante();
		}
		public function index(){
			
		}

		public function misNotas($id){
			$datos = array();
			$this->estudiante->set("id_usuario",$id);
			$query = $this->estudiante->notas();
			while($row = $query->fetch_assoc()) {
				$datos[] = array('nombre_materia' => $row['nombre'] ,
					'nota' => $row['nota'],
					'porcentaje' => $row['porcentaje'],
                    'corte' => $row['corte']
				);
			}
			echo json_encode($datos);
		}

		public function estadoMaterias($id){
		    $datos = array();
            $this->estudiante->set("id_usuario",$id);
            $query = $this->estudiante->materias();
            while($row = $query->fetch_assoc()) {
                $datos[] = array(
                    'id' => $row['id_materia'] ,
                    'nombre' => $row['nombre'] ,
                    'promedio' => round($row['promedio'], 2),
                    'estado' => $row['estado']
                );
            }
            echo json_encode($datos);

        }

        public function verHorarios($id){
            $datos = array();
            $this->estudiante->set("id_usuario",$id);
            $query = $this->estudiante->horarios();
            while($row = $query->fetch_assoc()) {
                $datos[] = array(
                    'id' => $row['id_materia'] ,
                    'nombre' => $row['nombre'] ,
                    'dia' => $row['dia'],
                    'horario' => $row['horario']
                );
            }
            echo json_encode($datos);
        }

}

?>
