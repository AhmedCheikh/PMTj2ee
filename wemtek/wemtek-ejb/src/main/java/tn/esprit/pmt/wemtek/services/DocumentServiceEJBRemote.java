package tn.esprit.pmt.wemtek.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pmt.wemtek.persistence.Document;


@Remote
public interface DocumentServiceEJBRemote {

	public void addDocument(Document D);
	public void deleteDocument(Document D);
	public void updateDocument(Document D);
	public Document findDocumentById(int id);
	public List<Document>findAllDocuments();
}
