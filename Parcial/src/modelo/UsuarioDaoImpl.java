package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Usuario;

public class UsuarioDaoImpl implements Dao<Usuario>{
	
	PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	
	private String query_insert = "INSERT INTO pusuarios(nombre, password, rol)VALUES ( ?, ?, ?)";
	private String query_delete = "DELETE FROM usuarios WHERE id_usuario = ?";
	private String query_update = "UPDATE usuarios SET nombre=?, password=?, rol=? WHERE id_usuario = ?";
	private String query_select_data = "SELECT * FROM usuarios WHERE id_usuario = ?";
	private String query_select_all = "SELECT * FROM usuarios";
    private String query_login = "SELECT * FROM usuarios WHERE nombre = ? AND password = ? AND rol = ?";
	
	public UsuarioDaoImpl() {
		conn = Conexion.getConection();
	}

	@Override
	public List<Usuario> getAllData() {
		List<Usuario> usuarios = new ArrayList<>();
		try {
            ps = conn.prepareStatement(query_select_all);
			rs = ps.executeQuery();
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setRol(rs.getString("rol"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar los usuarios "+e.getMessage());
		}
		return usuarios;
	}

	@Override
	public Usuario getData(int id) {
		Usuario usuario = new Usuario();
		try {
			ps = conn.prepareStatement(query_select_data);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setRol(rs.getString("rol"));
			}else{
				System.out.println("no exites ningun usuario con ese ID");
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar al usuario "+e.getMessage());
		}
		return usuario;
	}

	@Override
	public void updateData(Usuario t) {
		try {
			ps = conn.prepareStatement(query_update);
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getRol());
			ps.setInt(4, t.getId_usuario());
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
	public void insert(Usuario t) {
		try {
			ps = conn.prepareStatement(query_insert);
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getRol());
			ps.executeUpdate();
		} catch (SQLException e) {
		    System.out.println("Error al Insertar "+e.getMessage());
		}
	}
	
	public int login(Usuario t){
		int id_usuario = 0;
		try {
			ps = conn.prepareStatement(query_login);
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getRol());
			rs = ps.executeQuery();
			if(rs.next()){
				id_usuario = rs.getInt("id_usuario");
			}else{
				id_usuario = 0;
			}
		} catch (SQLException e) {
			System.out.println("Error en el login "+e.getMessage());
		}
		return id_usuario;
	}

}
