package pojo;

public class Privilegios {
	
	private int id_privilegio;
	private boolean crud_usuarios;
	private boolean mis_pedidos;
	private boolean productos;
	private int id_usuario;
	
	
	public int getId_privilegio() {
		return id_privilegio;
	}
	public void setId_privilegio(int id_privilegio) {
		this.id_privilegio = id_privilegio;
	}
	public boolean isCrud_usuarios() {
		return crud_usuarios;
	}
	public void setCrud_usuarios(boolean crud_usuarios) {
		this.crud_usuarios = crud_usuarios;
	}
	public boolean isMis_pedidos() {
		return mis_pedidos;
	}
	public void setMis_pedidos(boolean mis_pedidos) {
		this.mis_pedidos = mis_pedidos;
	}
	public boolean isProductos() {
		return productos;
	}
	public void setProductos(boolean productos) {
		this.productos = productos;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	
	
	
	

}
