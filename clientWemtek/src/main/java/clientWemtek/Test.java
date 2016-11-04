package Client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.pmt.wemtek.persistence.Document;
import tn.esprit.pmt.wemtek.services.DocumentServiceEJBRemote;

public class Test {

	public static void main(String[] args) throws NamingException {
	
		InitialContext context = new InitialContext();
		DocumentServiceEJBRemote  proxy = (DocumentServiceEJBRemote) context.lookup("wemtek-ear/wemtek-ejb/DocumentServiceEJB!tn.esprit.pmt.wemtek.services.DocumentServiceEJBRemote");

		Document document= new Document(1,"Syrine"); 
		proxy.addDocument(document);
	}

}
