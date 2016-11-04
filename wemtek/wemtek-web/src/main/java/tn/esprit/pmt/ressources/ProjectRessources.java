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

import tn.esprit.pmt.wemtek.persistence.Project;
import tn.esprit.pmt.wemtek.services.ProjectServiceEJBRemote;

@Path("Projects")
@RequestScoped
public class ProjectRessources {
	@EJB
	ProjectServiceEJBRemote projectRemote;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProjects() {
		return Response.ok(projectRemote.getAllProject()).build();
	}
	
	@GET
	@Path("Project/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findProjectById(@PathParam(value="id")int id) {
		return Response.ok(projectRemote.getProjectById(id)).build();
		
	}
	
	@POST
	@Path("addProject")
	public Response addProject(Project p){
		return Response.ok(projectRemote.addProject(p)).build();
		
	}
	
	@DELETE
	@Path("deleteProject/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProject(@PathParam(value="id")int id){
		
		return Response.ok(projectRemote.deleteProject(id)).build();
	}
	
	@PUT
	@Path("updateProject")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProject(Project p)
	{
		return Response.ok(projectRemote.updateProject(p)).build();
	}

}
