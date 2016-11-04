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

import tn.esprit.pmt.wemtek.persistence.Task;
import tn.esprit.pmt.wemtek.services.TaskServiceEJBRemote;

@Path("tasks")
@RequestScoped

public class TaskRessource {

	@EJB
	TaskServiceEJBRemote metier ;
	
	@GET
	@Produces("application/json")
	public Response getTasks() {
		return Response.ok(metier.findAllTasks()).build();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findTaskById(@PathParam(value="id")int id) {
		return Response.ok(metier.findTaskById(id)).build();	
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateTask(Task u){
		metier.updateTask(u); 
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addTask(Task u){
		metier.addTask(u);
		
	}
	
	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUser(Task u) {
		metier.deleteTask(u);
	}

}
