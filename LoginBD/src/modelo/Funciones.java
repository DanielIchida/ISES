package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ing-daniel on 20/09/2016.
 */
public class Funciones {

    public ResultSet login(String nombre , String pass){

        Conexion conexionOracle = new Conexion();
        Connection conn = null;
        ResultSet rs = null;
        try{
           conexionOracle.conectar();
           conn = conexionOracle.getConnection();
           System.out.println("Conexion "+conn);
           Statement st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM USUARIOS WHERE NOMBRE = '"+nombre+"' AND PASS = '"+pass+"'");
        }catch (SQLException ex){
            System.out.print(ex.getMessage());
        }

        return  rs;

    }

}
