package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartamentosDAO implements DAO<Departamentos>{
	
	private String listado = "SELECT * FROM departamento";

	@Override
	public boolean add(Departamentos entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Departamentos item(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Departamentos entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Departamentos entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Departamentos> getList() {
		List<Departamentos> departamentos = new ArrayList<>();
		try {
			Statement st = Conexion.getInstance().conexion().createStatement();
			ResultSet rs = st.executeQuery(listado);
			while(rs.next()){
				Departamentos dep = new Departamentos();
				dep.setId(rs.getInt("id_departamento"));
				dep.setNombre(rs.getString("nombre"));
				departamentos.add(dep);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return departamentos;
	}

}
