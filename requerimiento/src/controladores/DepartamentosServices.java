package controladores;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import modelos.Departamentos;
import modelos.DepartamentosDAO;
import util.ParserJson;

@Path("/departamentos")
public class DepartamentosServices {
	
	private Departamentos dep;
	private DepartamentosDAO depDAO;
	
	public DepartamentosServices() {
		dep = new Departamentos();
		depDAO = new DepartamentosDAO();
	}

	@GET
	@Path("/listado")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDepar(){
		return ParserJson.getInstace().read(depDAO.getList());
	}
	
	
}
