package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Privilegios;
import pojo.Usuario;

public class PrivilegiosDaoImpl implements Dao<Privilegios>{
	
	PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	
	private String query_insert = "INSERT INTO pprivilegios(crud_usuarios, mis_pedidos, productos, id_usuario) VALUES (?, ?, ?, ?);";
	private String query_delete = "DELETE FROM privilegios WHERE id_privilegio = ?";
	private String query_update = "UPDATE privilegios SET crud_usuarios=?, mis_pedidos=?, productos=?, id_usuario=? WHERE id_privilegio = ?";
	private String query_select_data = "SELECT * FROM privilegios WHERE id_usuario = ?";
	private String query_select_all = "SELECT * FROM privilegios";
	
	public PrivilegiosDaoImpl() {
		conn = Conexion.getConection();
	}

	@Override
	public List<Privilegios> getAllData() {
		List<Privilegios> privs = new ArrayList<>();
		try {
			ps = conn.prepareStatement(query_select_all);
			rs = ps.executeQuery();
			while(rs.next()){
				Privilegios p = new Privilegios();
				p.setId_privilegio(rs.getInt("id_privilegio"));
				p.setId_usuario(rs.getInt("id_usuario"));
				p.setCrud_usuarios(rs.getBoolean("crud_usuarios"));
				p.setMis_pedidos(rs.getBoolean("mis_pedidos"));
				p.setProductos(rs.getBoolean("productos"));
				privs.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar los usuarios "+e.getMessage());
		}
		return  privs;
	}

	@Override
	public Privilegios getData(int id) {
		Privilegios p = new Privilegios();
		try {
			ps = conn.prepareStatement(query_select_data);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				p.setId_usuario(rs.getInt("id_usuario"));
				p.setCrud_usuarios(rs.getBoolean("crud_usuarios"));
				p.setMis_pedidos(rs.getBoolean("mis_pedidos"));
				p.setProductos(rs.getBoolean("productos"));
			}else{
				System.out.println("no exites ningun usuario con ese ID");
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar al usuario "+e.getMessage());
		}
		return p;
	}

	@Override
	public void updateData(Privilegios t) {
		try {
			ps = conn.prepareStatement(query_update);
			ps.setBoolean(1, t.isCrud_usuarios());
			ps.setBoolean(2, t.isMis_pedidos());
			ps.setBoolean(3, t.isProductos());
			ps.setInt(4, t.getId_usuario());
			ps.setInt(4, t.getId_privilegio());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al actualizar "+e.getMessage());
		}
	}

	@Override
	public void deleteData(int id) {
		try {
			ps = conn.prepareStatement(query_delete);
			ps.setInt(1,id);		
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al Eliminar "+e.getMessage());
		}
	}

	@Override
	public void insert(Privilegios t) {
		try {
			ps = conn.prepareStatement(query_insert);
			ps.setBoolean(1, t.isCrud_usuarios());
			ps.setBoolean(2, t.isMis_pedidos());
			ps.setBoolean(3, t.isProductos());
			ps.setInt(4, t.getId_usuario());
			ps.executeUpdate();
		} catch (SQLException e) {
		    System.out.println("Error al Insertar "+e.getMessage());
		}
	}

}
