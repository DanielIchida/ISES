package controladores;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import modelos.Municipios;
import modelos.MunicipiosDAO;
import util.ParserJson;

@Path("/municipios")
public class MunicipiosServices {
	
	private MunicipiosDAO munDAO;
	private Municipios mun;
	
	public MunicipiosServices() {
		munDAO = new MunicipiosDAO();
		mun = new Municipios();
	}
	
	@GET
	@Path("/listado/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String listadoPorDepartamento(@PathParam("id") int id){
		List<Municipios> municipios = munDAO.getListDepartamento(id);
		return ParserJson.getInstace().read(municipios);
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String nombreMunicipio(@PathParam("id") int id){
		mun = munDAO.item(id);
		return ParserJson.getInstace().read(mun);
	}
	

}
