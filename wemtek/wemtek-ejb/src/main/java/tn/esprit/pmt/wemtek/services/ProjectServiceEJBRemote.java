package tn.esprit.pmt.wemtek.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pmt.wemtek.persistence.Project;

@Remote
public interface ProjectServiceEJBRemote {
	
	public List<Project> getAllProject();
	public String addProject(Project p) ; 
	public String deleteProject(int id) ; 
	public String updateProject(Project p) ; 
	public Project getProjectById(int id) ; 

}
