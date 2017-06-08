package modelos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReservasDAO implements DAO<Reservas>{
	
	private String insert = "INSERT INTO reservas VALUES(NULL,?,?,?,?)";

	@Override
	public boolean add(Reservas entity) {
		boolean validar;
		try {
			PreparedStatement pst = Conexion.getInstance().conexion().prepareStatement(insert);
			pst.setInt(1, entity.getLugarIda());
			pst.setInt(2, entity.getLugarVuelta());
			pst.setString(3, entity.getIda());
			pst.setString(4, entity.getVuelta());
			pst.executeUpdate();
			validar = true;
		} catch (SQLException e) {
		    System.out.println(e.getLocalizedMessage());
		    validar = false;
		}
		return validar;
	}

	@Override
	public Reservas item(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Reservas entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Reservas entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Reservas> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
