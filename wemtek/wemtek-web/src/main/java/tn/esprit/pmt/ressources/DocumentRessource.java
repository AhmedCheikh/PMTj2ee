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

import tn.esprit.pmt.wemtek.persistence.Document;
import tn.esprit.pmt.wemtek.services.DocumentServiceEJBRemote;

@Path("documents")
@RequestScoped
public class DocumentRessource {

	
	@EJB
	DocumentServiceEJBRemote metier; 
	
	@GET
	@Produces("application/json")
	public Response getDocuments() {
		return Response.ok(metier.findAllDocuments()).build();
	}
	
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findDocumentById(@PathParam(value="id")int id) {
		return Response.ok(metier.findDocumentById(id)).build();	
	}
	
	
	@PUT
	@Path("Update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void UpdateDocument(Document Doc){
		metier.updateDocument(Doc); 
	}
	@POST
	@Path("Add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void AddDocuments(Document Doc){
		metier.addDocument(Doc);
		
	}
	@DELETE
	@Path("Delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void DeleteDocument(Document Doc) {
		metier.deleteDocument(Doc);
	}
	

	
}
