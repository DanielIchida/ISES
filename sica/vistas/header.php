<?php
header('Last-Modified: '.gmdate('D, d M Y H:i:s').'GMT');
header('Cache-Control: no-cache, must-revalidate, max-age=0');
header('Cache-Control: post-check=0, pre-check=0 , false');
header('Pragma: no-cache');
?>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>SICA</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<?php echo URL; ?>recursos/css/estilos.css">
    <link rel="stylesheet" href="<?php echo URL; ?>recursos/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <script type="text/javascript" src="<?php echo URL; ?>recursos/js/jquery.min.js"></script>
    <script type="text/javascript" src="<?php echo URL; ?>recursos/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<?php echo URL; ?>recursos/js/angular.min.js"></script>
  </head>
  <body>
  <nav>
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-6">
           <img src="<?php echo URL; ?>recursos/imagenes/logo.png" alt="" />
        </div>
        <div class="col-sm-6"></div>
      </div>
    </div>
  </nav>

