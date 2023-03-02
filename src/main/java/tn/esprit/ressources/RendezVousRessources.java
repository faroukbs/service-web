package tn.esprit.ressources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.business.LogementBusiness;
import tn.esprit.business.RendezVousBusiness;
import tn.esprit.entites.RendezVous;

@Path("rendezvous")
public class RendezVousRessources {

	private static  RendezVousBusiness rvb = new RendezVousBusiness();
	private static  LogementBusiness lb = new LogementBusiness();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRendezVous (RendezVous rv ) {
		rvb.addRendezVous(rv);
		
		return Response.status(Status.CREATED).build();
	}
	//@GET
	//@Produces(MediaType.APPLICATION_JSON)
	//public Response getRendezVousList() {
		
	//	return Response.status(Status.OK).entity(rvb.getListeRendezVous()).build();
	//}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getrendezvousbylog (@QueryParam (value = "refLogement") Integer ref ) {
		if (ref != null) {
			
				return Response.status(Status.OK).entity(rvb.getListeRendezVousByLogementReference(ref)).build();
			}
			else {
				if(rvb.getListeRendezVous().size()!=0) {
					return Response.status(Status.OK).entity(rvb.getListeRendezVous()).build();
				}
					return Response.status(Status.NOT_FOUND).entity("not found").build();
			}		
			
				
	//	}
		
		//return Response.status(Status.OK).entity(rvb.getListeRendezVous()).build();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetRendezVous(@PathParam(value = "id") Integer id) {
		if ( rvb.getRendezVousById(id)== null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.status(Status.OK).entity(rvb.getRendezVousById(id)).build();
	}

	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteee (@PathParam(value = "id")Integer id) {
		
		if (rvb.getRendezVousById(id)!= null) {
			rvb.deleteRendezVous(id);
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.NOT_FOUND).build();
		
	}
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updaterendez(@PathParam(value = "id")Integer id ,RendezVous rv) {
		
		if(rvb.getRendezVousById(id)!= null ) {
			rvb.updateRendezVous(id, rv);
			return Response.status(Status.OK).entity(rvb.getRendezVousById(id)).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	
}
