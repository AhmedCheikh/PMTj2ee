package tn.esprit.pmt.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.pmt.wemtek.persistence.Role;
import tn.esprit.pmt.wemtek.persistence.User;
import tn.esprit.pmt.wemtek.services.RoleServiceEJBRemote;

@Path("roles")
@RequestScoped
public class RoleResource {
	
	@EJB
	RoleServiceEJBRemote metier ;
	
	@GET
	@Produces("application/json")
	public Response getRoles() {
		return Response.ok(metier.getListRoles()).build();
	}
	
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addRole(Role r){
		metier.addRole(r);
		
	}
	
	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteRole(Role r) {
		metier.deleteRole(r);
	}

}
