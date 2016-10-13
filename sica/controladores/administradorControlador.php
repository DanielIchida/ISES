<?php namespace controladores;

	use modelos\Administrador as Administrador;

class administradorControlador{

		private $admin;

		public function __construct(){
			$this->admin = new Administrador();
		}

		public function index(){
    
		}
}
