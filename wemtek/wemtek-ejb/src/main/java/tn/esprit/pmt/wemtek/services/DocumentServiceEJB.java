package tn.esprit.pmt.wemtek.services;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.esprit.pmt.wemtek.persistence.Document;

/**
 * Session Bean implementation class DocumentServiceEJB
 */
@Stateless
@LocalBean
public class DocumentServiceEJB implements DocumentServiceEJBRemote {

    
	@PersistenceContext(unitName="wemtek-ejb")
	EntityManager Em ;

	
    public DocumentServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addDocument(Document D) {
		Em.persist(D);
		
		
	}

	@Override
	public void deleteDocument(Document D) {
		Em.remove(Em.merge(D));
		
	}

	@Override
	public void updateDocument(Document D) {
        Em.merge(D);
	}

	@Override
	public Document findDocumentById(int id) {
		return Em.find(Document.class, id); 
		
	}

	@Override
	public List<Document> findAllDocuments() {
		return Em.createQuery("SELECT D FROM Document D ",Document.class).getResultList();

		
	}



}
