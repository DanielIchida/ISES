package controladores;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import modelos.Reservas;
import modelos.ReservasDAO;
import util.ParserJson;

@Path("/itinerario")
public class ReservasServices {
	
	private ReservasDAO dao;
	private Reservas reservas;
	
	public ReservasServices() {
		dao = new ReservasDAO();
		reservas = new Reservas();
	}

	@POST
	@Path("/reservas")
	public String crearReserva(@FormParam("lugarida") int lugarida,
			                   @FormParam("lugarvuelta") int lugarvuelta,
			                   @FormParam("fechaida") String fechaida,
			                   @FormParam("fechavuelta") String fechavuelta,
			                   @Context HttpServletResponse servletResponse){
		String validar = null;
		reservas.setIda(fechaida);
		reservas.setVuelta(fechavuelta);
		reservas.setLugarIda(lugarida);
		reservas.setLugarVuelta(lugarvuelta);
		if(dao.add(reservas)){
			validar = "ok";
		}else{
			validar = "error";
		}
		return ParserJson.getInstace().read(validar);
	}
	
}
