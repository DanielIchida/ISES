<?php namespace controladores;

	use modelos\Usuario as Usuario;

class usuariosControlador{

		private $usuario;

		public function __construct(){
			$this->usuario = new Usuario();
		}

		public function index(){
        if($_POST){$this->usuario->set("correo_universidad", $_POST['usuario']);
          $this->usuario->set("contra", $_POST['pass']);
          $this->usuario->set("rol", $_POST['rol']);
					$login = $this->usuario->login();
					if($login == 0){
						echo'<script type="text/javascript">
										 alert("Usuario o Contraseña Incorrecta");
										 window.location="http://localhost:9090/sica/"
									</script>';
					}else{
						session_start();
						$_SESSION["autenticado"] = "SI";
					    if($login['rol'] == 'Estudiante'){
								require_once 'vistas/header.php';
								require_once 'vistas/estudiantes/index.php';
								require_once 'vistas/footer.php';
							}else if($login['rol'] == 'Docente'){
								require_once 'vistas/header.php';
								require_once 'vistas/docentes/index.php';
								require_once 'vistas/footer.php';
							}else if($login['rol'] == 'Coordinador'){
								require_once 'vistas/header.php';
								require_once 'vistas/coordinadores/index.php';
								require_once 'vistas/footer.php';
							}else{
								require_once 'vistas/header.php';
								require_once 'vistas/administrador/index.php';
								require_once 'vistas/footer.php';
							}
					}
				}
		}

		public function logout(){
			session_start();
			$_SESSION["autenticado"] = "NO";
			session_unset();
            session_destroy();
				header('Location: http://localhost:9090/sica/');
			die("Redirecting to: http://localhost:9090/sica/");
		}
}

?>
