package tn.esprit.pmt.wemtek.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.pmt.wemtek.persistence.Reunion;
import tn.esprit.pmt.wemtek.persistence.User;

/**
 * Session Bean implementation class ReunionEJB
 */
@Stateless
@LocalBean
public class ReunionEJB implements ReunionEJBRemote {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="wemtek-ejb")

	EntityManager em ; 
    public ReunionEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addReunion(Reunion r) {
		em.persist(r);		
	}

	@Override
	public void deleteReunion(Reunion r) {
		em.remove(em.merge(r));		
	}

	@Override
	public void updateReunion(Reunion r) {
		em.merge(r) ; 
		
	}

	@Override
	public Reunion findReunionById(int id) {
		return em.find(Reunion.class, id);

	}

	@Override
	public List<Reunion> findAllReunions() {
		return em.createQuery("SELECT u FROM Reunion u ",Reunion.class).getResultList();

	}

}
