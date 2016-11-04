package Client;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.pmt.wemtek.persistence.Document;

import tn.esprit.pmt.wemtek.services.DocumentServiceEJBRemote;

public class TestDocument {
	
	public static void AddDocuments(Document document) throws NamingException {

		InitialContext context = new InitialContext();
		DocumentServiceEJBRemote proxy = (DocumentServiceEJBRemote) context
				.lookup("wemtek-ear/wemtek-ejb/DocumentServiceEJB!tn.esprit.pmt.wemtek.services.DocumentServiceEJBRemote");
		proxy.addDocument(document);

		System.out.println("document added!");

	}
	
	public static void UpdateDocument (Document document, String Path, String Name, int NbrDow) throws NamingException {
		InitialContext context = new InitialContext();
		DocumentServiceEJBRemote proxy = (DocumentServiceEJBRemote) context
				.lookup("wemtek-ear/wemtek-ejb/DocumentServiceEJB!tn.esprit.pmt.wemtek.services.DocumentServiceEJBRemote");
		document.setPath(Path);	
		document.setName(Name);
		document.setNumberDownloading(NbrDow);
		
		proxy.updateDocument(document);
		System.out.println("Document :" + document.getId() + " has been modified");

	}
	public static Document findDocumentById(int id, boolean visibility) throws NamingException {
		InitialContext context = new InitialContext();
		DocumentServiceEJBRemote proxy = (DocumentServiceEJBRemote) context
				.lookup("wemtek-ear/wemtek-ejb/DocumentServiceEJB!tn.esprit.pmt.wemtek.services.DocumentServiceEJBRemote");
		Document document = proxy.findDocumentById(id);
		if (visibility) {
			System.out.println("Task : " + "Id=" + document.getId() + " Path=" + document.getPath() + " Name=" + document.getName()
			+ " Number downloading=" + document.getNumberDownloading()
					);
		}
		return document;
	}
	public static void findDocumentName(String name, boolean visibility) throws NamingException {
		InitialContext context = new InitialContext();
		DocumentServiceEJBRemote proxy = (DocumentServiceEJBRemote) context
				.lookup("wemtek-ear/wemtek-ejb/DocumentServiceEJB!tn.esprit.pmt.wemtek.services.DocumentServiceEJBRemote");
		Document document = proxy.findDocumentByName(name);
		if (visibility) {
			System.out.println(document.toString());
		}
	}
	
	public static void DeleteDocumentById(int id) throws NamingException {
		InitialContext context = new InitialContext();
		DocumentServiceEJBRemote proxy = (DocumentServiceEJBRemote) context
				.lookup("wemtek-ear/wemtek-ejb/DocumentServiceEJB!tn.esprit.pmt.wemtek.services.DocumentServiceEJBRemote");
		proxy.deleteDocument(proxy.findDocumentById(id));
		System.out.println("Document deleted!");
	}
	
	public static void findAllDocument() throws NamingException {
		InitialContext context = new InitialContext();
		DocumentServiceEJBRemote proxy = (DocumentServiceEJBRemote) context
				.lookup("wemtek-ear/wemtek-ejb/DocumentServiceEJB!tn.esprit.pmt.wemtek.services.DocumentServiceEJBRemote");
		List<Document> ll = proxy.findAllDocuments();
		System.out.println("Documents :");
		
		for (Document l : ll ){
			System.out.println(l.toString());
			
			
		}
		
	}
	
	public static void NumberDownloading() throws NamingException {
		InitialContext context = new InitialContext();
		DocumentServiceEJBRemote proxy = (DocumentServiceEJBRemote) context
				.lookup("wemtek-ear/wemtek-ejb/DocumentServiceEJB!tn.esprit.pmt.wemtek.services.DocumentServiceEJBRemote");
		List<Document> ll = proxy.findAllDocuments();
		System.out.println("Number documents Downloading :");
		int somme=0;
		for (Document l : ll ){
			
			somme+=l.getNumberDownloading();
			
		}
		System.out.println(somme);
	}
	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Document doc = findDocumentById(5, false); 
		//Document d = new Document("Path", "Esprit", 14); 
 	   //AddDocuments(d);
		//AddDocuments(doc);
		//UpdateDocument(doc,"jjjjj","mmmmm",1);
		//DeleteDocumentById(2);
		//findAllDocument();
		//NumberDownloading();
		findDocumentName("Path", true); 
		

	}
	

}
