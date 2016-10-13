<?php namespace modelos;

	class Estudiante{

		private $id_usuario;
		private $nombre;
		private $apellido;
		private $correo_personal;
		private $telefono;
		private $celular;
		private $direccion;
		private $rol;
		private $correo_universidad;
		private $contra;

        private $con;

		public function __construct(){
			$this->con = new Conexion();
		}

		public function set($atributo, $contenido){
			$this->$atributo = $contenido;
		}

		public function get($atributo){
			return $this->$atributo;
		}

		public function notas(){
			$sql = "SELECT nombre , nota , porcentaje , corte FROM calificaciones INNER JOIN asignar_materias_estudiante ON calificaciones.id_asignar_materia_estudiante = asignar_materias_estudiante.id_asignar_materia_estudiante INNER JOIN asignar_materias ON asignar_materias_estudiante.id_asignar_materia = asignar_materias.id_asignar_materia INNER JOIN materias ON asignar_materias.id_materia = materias.id_materia WHERE asignar_materias_estudiante.id_usuario = $this->id_usuario";
			$consulta = $this->con->consultaRetorno($sql);
			return $consulta;
		}

		public function materias(){
           $sql = "SELECT materias.id_materia ,AVG(nota) AS promedio  , materias.nombre , asignar_materias_estudiante.estado FROM `calificaciones` INNER JOIN asignar_materias_estudiante ON calificaciones.id_asignar_materia_estudiante = asignar_materias_estudiante.id_asignar_materia_estudiante INNER JOIN asignar_materias ON asignar_materias_estudiante.id_asignar_materia = asignar_materias.id_asignar_materia INNER JOIN materias ON asignar_materias.id_materia = materias.id_materia WHERE asignar_materias_estudiante.id_usuario = $this->id_usuario GROUP BY materias.nombre";
            $consulta = $this->con->consultaRetorno($sql);
            return $consulta;
        }

        public function horarios(){
             $sql = "SELECT materias.id_materia , nombre , dia , horario FROM `asignar_materias_estudiante` INNER JOIN asignar_materias ON asignar_materias_estudiante.id_asignar_materia = asignar_materias.id_asignar_materia INNER JOIN materias ON asignar_materias.id_materia = materias.id_materia WHERE id_usuario = $this->id_usuario";
             $consulta = $this->con->consultaRetorno($sql);
			 return $consulta;
        }

    
	}
?>
