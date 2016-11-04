package Client;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.pmt.wemtek.persistence.Document;
import tn.esprit.pmt.wemtek.persistence.Project;
import tn.esprit.pmt.wemtek.services.DocumentServiceEJBRemote;
import tn.esprit.pmt.wemtek.services.ProjectServiceEJBRemote;


public class TestProject {
	
	public static String lookupPath ="wemtek-ear/wemtek-ejb/ProjectServiceEJB!tn.esprit.pmt.wemtek.services.ProjectServiceEJBRemote";
	
	public static void addProject(Project p) throws NamingException{
		InitialContext context = new InitialContext();
		ProjectServiceEJBRemote proxy = (ProjectServiceEJBRemote) context
				.lookup(lookupPath);
		proxy.addProject(p);

		System.out.println("project added!");
	}
	public static void updateProjeect (Project p, String name,String description) throws NamingException {
		InitialContext context = new InitialContext();
		ProjectServiceEJBRemote proxy = (ProjectServiceEJBRemote) context.lookup(lookupPath);
		p.setName(name);
		p.setDescription(description);
		
		proxy.updateProject(p);
		System.out.println("Project :" + p.getId() + " has been modified");
	}
	public static Project findProjectById(int id, boolean visibility) throws NamingException {
		InitialContext context = new InitialContext();
		ProjectServiceEJBRemote proxy = (ProjectServiceEJBRemote) context.lookup(lookupPath);
		Project p = proxy.getProjectById(id);
		if (visibility) {
			System.out.println("Project : " + "Id=" + p.getId() + " Name=" + p.getName() +" Description="+ p.getDescription()
					);
		}
		return p;
	}
	public static void deleteProjectById(int id) throws NamingException {
		InitialContext context = new InitialContext();
		ProjectServiceEJBRemote proxy = (ProjectServiceEJBRemote) context.lookup(lookupPath);
		proxy.deleteProject(id);
		System.out.println("Project deleted!");
	}
	
	public static void findAllProjects() throws NamingException {
		InitialContext context = new InitialContext();
		ProjectServiceEJBRemote proxy = (ProjectServiceEJBRemote) context.lookup(lookupPath);
		List<Project> projects = proxy.getAllProject();
		System.out.println("Projects :");
		for (Project p : projects ){
			System.out.println(p.toString());
		}
	}
	public static void main(String[] args) throws NamingException {
		/* Test Add project 
		Project p = new Project();
		p.setName("testAdd");
		p.setDescription("TestDescription");
		addProject(p);
		*/ 
		
		
		
		//findProjectById(2, true);
		
		//deleteProjectById(2);
		
		findAllProjects();
	}
	

}
