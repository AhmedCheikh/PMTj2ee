package tn.esprit.pmt.wemtek.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.pmt.wemtek.persistence.Role;

/**
 * Session Bean implementation class RoleServiceEJB
 */
@Stateless
@LocalBean
public class RoleServiceEJB implements RoleServiceEJBRemote {

	@PersistenceContext(unitName="wemtek-ejb")
	EntityManager em ; 
    /**
     * Default constructor. 
     */
    public RoleServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addRole(Role r) {
		em.persist(r);
		
	}

	@Override
	public void deleteRole(Role r) {
		em.remove(em.merge(r));
		
	}

	@Override
	public List<Role> getListRoles() {
		return em.createQuery("SELECT r FROM Role r",Role.class).getResultList();
	}

}
