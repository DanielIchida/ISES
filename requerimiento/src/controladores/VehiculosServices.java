package controladores;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import modelos.Vehiculos;
import modelos.VehiculosDAO;
import util.ParserJson;

@Path("/vehiculos")
public class VehiculosServices {
	
	private VehiculosDAO dao;
	private Vehiculos vehiculo;
	
	public VehiculosServices() {
		dao = new VehiculosDAO();
		vehiculo = new Vehiculos();
	}
	
	@GET
	@Path("/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public String getVehiculos(){
		return ParserJson.getInstace().read(dao.getList());
	}
	

}
