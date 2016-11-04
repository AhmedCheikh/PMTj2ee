package Client;

//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.pmt.wemtek.persistence.Reunion;

import tn.esprit.pmt.wemtek.services.ReunionEJBRemote;


public class TestMeeting {

	
	public static void addReunion(Reunion reunion) throws NamingException {

		InitialContext context = new InitialContext();
		ReunionEJBRemote proxy = (ReunionEJBRemote) context
       .lookup("wemtek-ear/wemtek-ejb/ReunionEJB!tn.esprit.pmt.wemtek.services.ReunionEJBRemote");
		proxy.addReunion(reunion);

		System.out.println("reunion added!");
		
		
		//List<Reunion> Reunion = new ArrayList<>() ;
		//Reunion = proxy.findAllReunions();
		
		///for (Reunion r : Reunion) {
			//System.out.println("First name : "+r.getName()+" -- "+r.getType() ); 
		//}
		
		
	}

	public static void updateReunion(Reunion reunion, String name, Date dateR, String type, String description) throws NamingException {
		InitialContext context = new InitialContext();
		ReunionEJBRemote proxy = (ReunionEJBRemote) context
				.lookup("/wemtek-ear/wemtek-ejb/ReunionEJB!tn.esprit.pmt.wemtek.services.ReunionEJBRemote");
		reunion.setName(name);
		// task.setDeadLine(DeadLine);
		reunion.setDateR(dateR);

		reunion.setType(type);
		proxy.updateReunion(reunion);


		reunion.setDescription(description);
		proxy.updateReunion(reunion);
		
		System.out.println("task :" + reunion.getIdR() + " has been modified");

	}
	public static Reunion findTaskById(int id, boolean visibility) throws NamingException {
		InitialContext context = new InitialContext();
		ReunionEJBRemote proxy = (ReunionEJBRemote) context
				.lookup("/wemtek-ear/wemtek-ejb/ReunionEJB!tn.esprit.pmt.wemtek.services.ReunionEJBRemote");

		Reunion reunion = proxy.findReunionById(id);
		if (visibility) {
			System.out.println("Reunion  : " + "Id=" + reunion.getIdR() + " Name=" + reunion.getName() + " DateReunion="
					+ reunion.getDateR()+ " Type =" + reunion.getType ()+ " Description =" + reunion.getDescription ());
		}
		return reunion;
	}
	public static void deleteReunionById(int id) throws NamingException {
		InitialContext context = new InitialContext();
		ReunionEJBRemote proxy = (ReunionEJBRemote) context
				.lookup("/wemtek-ear/wemtek-ejb/ReunionEJB!tn.esprit.pmt.wemtek.services.ReunionEJBRemote");
		proxy.deleteReunion(proxy.findReunionById(id));
		System.out.println("Reunion deleted!");
	}
	

	public static void main(String[] args) throws NamingException {
		
	
		//Reunion reunion = new Reunion(1, "mariem",new Date(), "mariem", "mariem");
		//addReunion(reunion);
		//updateReunion(reunion, "ssss",new Date(), "bbbb", "mariem");
		findTaskById(1, false);
		deleteReunionById(1);
		
	}
}
