package tn.esprit.pmt.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.pmt.wemtek.persistence.User;
import tn.esprit.pmt.wemtek.services.UserServiceEJBRemote;

@Path("users")
@RequestScoped
public class UserResource {
	@EJB
	UserServiceEJBRemote metier ;
	
	@GET
	@Produces("application/json")
	public Response getUsers() {
		return Response.ok(metier.findAllUsers()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findUserById(@PathParam(value="id")int id) {
		return Response.ok(metier.findUserById(id)).build();	
	}
	
	@GET
	@Path("/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByName(@PathParam(value="name")String name) {
		return Response.ok(metier.findUserByName(name)).build();	
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(User u){
		metier.updateUser(u); 
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addUser(User u){
		metier.addUser(u);
		
	}
	
	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUser(User u) {
		metier.deleteUser(u);
	}
	
	@PUT
	@Path("validate")
	@Consumes(MediaType.APPLICATION_JSON)
	public void validateUser(User u){
		metier.validateUser(u); 
	}
	
	@GET
	@Path("authenticate/{email}/{password}")
	@Produces("text/plain")
	public Response authenticate(@PathParam(value="email")String email, @PathParam(value="password")String password){
		return Response.ok(metier.authenticate(email,password)).build();	
	}
	
	
	
	
	
	

}
