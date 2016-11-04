package clientWemtek;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.pmt.wemtek.persistence.Role;
import tn.esprit.pmt.wemtek.persistence.User;
import tn.esprit.pmt.wemtek.services.UserServiceEJBRemote;

public class UserTest {

	public static void main(String[] args) throws NamingException {
		InitialContext ctx = new InitialContext();
		UserServiceEJBRemote proxy = (UserServiceEJBRemote)
				ctx.lookup("/wemtek-ear/wemtek-ejb/UserServiceEJB!tn.esprit.pmt.wemtek.services.UserServiceEJBRemote");

		User u1 = new User(4,"pass","ahmed","cheikh","ahmed@esprit.tn",true,null,null,null,null,null,null) ; 
		User u2 = new User(2,"pass2","mohamed","cheikh","mohamed@esprit.tn",false,null,null,null,null,null,null) ;
		// Ajout utilisateurs
//		proxy.addUser(u1);


//		List<User> listUser = new ArrayList<>() ;
//		listUser = proxy.findUserByName("ahmed");
//		
//		for (User user : listUser) {
//			System.out.println("First name : "+user.getFirstName()+" | Last name :  "+user.getLastName()+" | Email :  "+user.getEmail()+" | Etat :  "+user.getState() ); 
//		}
		
//		proxy.authenticate("ahmed@esprit.tn", "passsss");
		
//		proxy.findUserByName("ahmed") ;
		
		proxy.updateUser(new User(1,"pass3","x","cheikh","ahmed@esprit.tn",true,null,null,null,null,null,null));
		
		
		
		
		
		
		

	}

}
