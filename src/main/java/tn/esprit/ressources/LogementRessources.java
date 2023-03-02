package tn.esprit.ressources;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.business.LogementBusiness;

@Path("logements")
public class LogementRessources {

	public static LogementBusiness lb = new LogementBusiness();
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRendezVousList() {
		if(lb.getLogements()!= null)
			return Response.status(Status.OK).entity(lb.getLogements()).build();
		return Response.status(Status.NOT_FOUND).entity("List Not found").build();
	}
	*/
	
	@GET
	@Path("/{delegation}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetRendezVous(@PathParam(value = "delegation") String delegation) {
		//if ( lb.getLogementsByDeleguation(deleguation)== null) {
			return Response.status(Status.NOT_FOUND).build();
		//}
		//return Response.status(Status.OK).entity(lb.getRendezVousById(id)).build();
	}
}
