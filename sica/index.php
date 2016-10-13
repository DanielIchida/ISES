<?php
	define('DS', DIRECTORY_SEPARATOR);
	define('ROOT', realpath(dirname(__FILE__)) . DS);
	define('URL', "http://localhost:9090/sica/");

	require_once "configuracion/Autoload.php";
	configuracion\Autoload::run();
	configuracion\Enrutador::run(new configuracion\Request());
?>
