package modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MunicipiosDAO implements DAO<Municipios>{
	
	private String buscarPorDep = "SELECT * FROM municipios WHERE id_departamento = ?";
	private String buscarNomMun = "SELECT * FROM municipios WHERE id_municipio = ?";

	@Override
	public boolean add(Municipios entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Municipios item(Object o) {
		Municipios m = new Municipios();
		PreparedStatement pst;
		try {
			pst = Conexion.getInstance().conexion().prepareStatement(buscarNomMun);
			pst.setInt(1,(int)o);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				m.setId(rs.getInt("id_municipio"));
				m.setNombre(rs.getString("nombre"));
				m.setId_depar(rs.getInt("id_departamento"));	
			}
		} catch (SQLException e) {
			System.out.println("Error SQL "+e.getLocalizedMessage());
		}
		return m;
	}

	@Override
	public boolean update(Municipios entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Municipios entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Municipios> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Municipios> getListDepartamento(int id){
		List<Municipios> municipios = new ArrayList<>();
		PreparedStatement pst;
		try {
			pst = Conexion.getInstance().conexion().prepareStatement(buscarPorDep);
			pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Municipios mun = new Municipios();
				mun.setId(rs.getInt("id_municipio"));
				mun.setNombre(rs.getString("nombre"));
				mun.setId_depar(rs.getInt("id_departamento"));
				municipios.add(mun);
			}
		} catch (SQLException e) {
			System.out.println("Error query: "+e.getLocalizedMessage());
		}
		return municipios;
	}

}
