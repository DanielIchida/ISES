package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehiculosDAO implements DAO<Vehiculos>{
	
	private String listado = "SELECT * FROM vehiculos";

	@Override
	public boolean add(Vehiculos entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vehiculos item(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Vehiculos entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Vehiculos entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Vehiculos> getList() {
		List<Vehiculos> vehiculos = new ArrayList<>();
		try {
			Statement st = Conexion.getInstance().conexion().createStatement();
			ResultSet rs = st.executeQuery(listado);
			while(rs.next()){
				Vehiculos v = new Vehiculos();
				v.setPlaca(rs.getString("placa"));
				v.setNombre_conductor(rs.getString("nombre_conductor"));
				v.setMarca(rs.getString("marca"));
				v.setModelo(rs.getInt("modelo"));
				v.setTelefono(rs.getString("telefono"));
				vehiculos.add(v);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return vehiculos;
	}

}
