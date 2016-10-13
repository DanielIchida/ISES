<?php namespace controladores;

	use modelos\Docente as Docente;

class docentesControlador{

		private $docente;

		public function __construct(){
			$this->docente = new Docente();
		}

		public function index(){
      require_once 'vistas/header.php';
      require_once 'vistas/docentes/index.php';
      require_once 'vistas/footer.php';
		}
}
