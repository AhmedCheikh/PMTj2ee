package Client;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.pmt.wemtek.persistence.Company;
import tn.esprit.pmt.wemtek.persistence.Document;
import tn.esprit.pmt.wemtek.persistence.Project;
import tn.esprit.pmt.wemtek.services.CompanyServiceEJbRemote;



public class TestCompany {
	
	public static String lookupPath ="wemtek-ear/wemtek-ejb/CompanyServiceEJb!tn.esprit.pmt.wemtek.services.CompanyServiceEJbRemote";
	
	public static void addCompany(Company c) throws NamingException{
		InitialContext context = new InitialContext();
		CompanyServiceEJbRemote proxy = (CompanyServiceEJbRemote) context.lookup(lookupPath);
		proxy.addCompany(c);

		System.out.println("Company added!");
	}
	public static void updateCompany (Company c, String name,String website) throws NamingException {
		InitialContext context = new InitialContext();
		CompanyServiceEJbRemote proxy = (CompanyServiceEJbRemote) context.lookup(lookupPath);
		c.setName(name);
		c.setWebsite(website);
		
		proxy.updateCompany(c);
		System.out.println("Company :" + c.getId() + " has been modified");
	}
	public static Company findCompanyById(int id, boolean visibility) throws NamingException {
		InitialContext context = new InitialContext();
		CompanyServiceEJbRemote proxy = (CompanyServiceEJbRemote) context.lookup(lookupPath);
		Company c = proxy.getCompanyById(id);
		if (visibility) {
			System.out.println(c.toString());
					
		}
		return c;
	}
	public static void deleteCompanyById(int id) throws NamingException {
		InitialContext context = new InitialContext();
		CompanyServiceEJbRemote proxy = (CompanyServiceEJbRemote) context.lookup(lookupPath);
		proxy.deleteCompany(id); 
		System.out.println("Company deleted!");
	}
	
	public static void findAllCompany() throws NamingException {
		InitialContext context = new InitialContext();
		CompanyServiceEJbRemote proxy = (CompanyServiceEJbRemote) context.lookup(lookupPath);
		List<Company> company = proxy.getAllCompany();
		System.out.println("Projects :");
		for (Company p : company ){
			System.out.println(p.toString());
		}
	}
	public static void main(String[] args) throws NamingException {
		/* Test Add company 
		Company p = new Company();
		p.setName("testAdd");
		p.setWebsite("TestDescription");
		addCompany(p);
		*/ 
		
	}
	

}
