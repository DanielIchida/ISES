<?php namespace modelos;
class Materia{

    private $id_materia;
    private $nombre;
    private $dia;
    private $horario;


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

    public function insertar(){
         $sql = "INSERT INTO materias VALUES('$this->id_materia','$this->nombre','$this->dia','$this->horario')";
         $query = $this->con->consultaSimple($sql);
         if($query){
             return true;
         }else{
             return false;
         }
    }



}
?>