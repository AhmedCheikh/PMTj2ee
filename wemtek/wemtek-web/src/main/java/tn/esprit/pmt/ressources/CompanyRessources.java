package tn.esprit.pmt.ressources;


import javax.annotation.security.RolesAllowed;
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

import tn.esprit.pmt.wemtek.persistence.Company;
import tn.esprit.pmt.wemtek.services.CompanyServiceEJbRemote;;

@Path("Companies")
@RequestScoped
public class CompanyRessources {
	@EJB
	CompanyServiceEJbRemote companyRemote;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompanies() {
		return Response.ok(companyRemote.getAllCompany()).build();
	}
	
	@GET
	@Path("Company/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findCompanyById(@PathParam(value="id")int id) {
		return Response.ok(companyRemote.getCompanyById(id)).build();
		
	}
	@RolesAllowed("ADMIN")
	@POST
	@Path("addCompany")
	public Response addProject(Company c){
		return Response.ok(companyRemote.addCompany(c)).build();
		
	}
	
	@DELETE
	@Path("deleteCompany/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProject(@PathParam(value="id")int id){
		
		return Response.ok(companyRemote.deleteCompany(id)).build();
	}
	@PUT
	@Path("updateCompany")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProject(Company c)
	{
		return Response.ok(companyRemote.updateCompany(c)).build();
	}
}
