package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	public static Connection getConection() {
		 Connection c = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/tienda",
	            "postgres", "1234");
	         System.out.println("Opened database successfully");
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      return c;
	}
	
	

}
