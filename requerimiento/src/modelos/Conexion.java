package modelos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	

    public String db = "itinerario";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "root";
    public String pass = "";
	
	private static Conexion con = new Conexion();
	
	private Conexion(){}
	
	public static Conexion getInstance(){
		return con;
	}
	
	public Connection conexion(){
		Connection cx = null;
		try{
			 Class.forName("com.mysql.jdbc.Driver");
             cx = DriverManager.getConnection(this.url, this.user, this.pass);
		}catch(Exception ex){
			 System.out.println("Error en la conexion "+ex.getLocalizedMessage());
		}
		return cx;
	}

}
