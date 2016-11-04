package tn.esprit.pmt.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.pmt.wemtek.persistence.Reunion;
import tn.esprit.pmt.wemtek.services.ReunionEJBRemote;


@Path("reunions")
@RequestScoped
public class ReunionResource {
	@EJB
	ReunionEJBRemote metier ;
	
	@GET
	@Produces("application/json")
	public Response getReunions() {
		return Response.ok(metier.findAllReunions()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findUserById(@PathParam(value="id")int id) {
		return Response.ok(metier.findReunionById(id)).build();	
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(Reunion r){
		metier.updateReunion(r); 
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addReunion(Reunion r){
		metier.addReunion(r);
		
	}
	
	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteReunion(Reunion r) {
		metier.deleteReunion(r);
	}
}
