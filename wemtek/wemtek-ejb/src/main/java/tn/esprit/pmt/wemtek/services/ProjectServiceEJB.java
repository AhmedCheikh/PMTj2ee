package tn.esprit.pmt.wemtek.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.pmt.wemtek.persistence.Project;

/**
 * Session Bean implementation class ProjectServiceEJB
 */
@Stateless
@LocalBean
public class ProjectServiceEJB implements ProjectServiceEJBRemote {
	@PersistenceContext(unitName="wemtek-ejb")
	EntityManager em ; 
    /**
     * Default constructor. 
     */
    public ProjectServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Project> getAllProject() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT p FROM Project p",Project.class).getResultList();
	}

	@Override
	public String addProject(Project p) {
		em.persist(p);
		return "Done";
		
	}


	@Override
	public String updateProject(Project p) {
		em.merge(p);
		return "Done";
		
	}

	@Override
	public Project getProjectById(int id) {
		return em.find(Project.class, id);
	}

	@Override
	public String deleteProject(int id) {
		em.remove(getProjectById(id));
		return "Done";
		
	}



}
