package clientWemtek;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.pmt.wemtek.persistence.Role;
import tn.esprit.pmt.wemtek.persistence.User;
import tn.esprit.pmt.wemtek.services.RoleServiceEJBRemote;

public class RoleTest {

	public static void main(String[] args) throws NamingException {
		InitialContext ctx = new InitialContext();
		RoleServiceEJBRemote proxy = (RoleServiceEJBRemote)
				ctx.lookup("/wemtek-ear/wemtek-ejb/RoleServiceEJB!tn.esprit.pmt.wemtek.services.RoleServiceEJBRemote");

		User u1 = new User(1,"pass","ahmed","cheikh","ahmed@esprit.tn",true,null,null,null,null,null,null) ; 
		User u2 = new User(2,"pass2","mohamed","cheikh","mohamed@esprit.tn",false,null,null,null,null,null,null) ;
		
		Role r1 = new Role(1,"admin",u1) ; 
		Role r2 = new Role(2,"user",u2) ; 
		
		
		proxy.addRole(r1);
		proxy.addRole(r2);
		
	}

}
