<?php namespace modelos;

	class Usuario{

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

		public function login(){
			$sql = "SELECT * FROM usuarios WHERE correo_universidad = '{$this->correo_universidad}' AND contrasena = '{$this->contra}' AND rol = '{$this->rol}'";
			$consulta = $this->con->consultaRetorno($sql);
			$row = $consulta->fetch_array(MYSQLI_ASSOC);
			if($consulta->num_rows == 0){
				$datos = 0;
			}else{
				$datos = array('nombre' => $row['nombre'] ,
											 'apellido' => $row['apellido'],
											 'rol' => $row['rol'],
										   'correo' => $row['correo_universidad'],
										   'contra' => $row['contrasena'],
										   'id' => $row['id_usuario']);
			}
			return $datos;
		}


	}
?>
