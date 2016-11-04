package tn.esprit.pmt.wemtek.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.pmt.wemtek.persistence.Company;


/**
 * Session Bean implementation class CompanyServiceEJb
 */
@Stateless
@LocalBean
public class CompanyServiceEJb implements CompanyServiceEJbRemote {
	@PersistenceContext(unitName="wemtek-ejb")
	EntityManager em ; 
    /**
     * Default constructor. 
     */
    public CompanyServiceEJb() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Company> getAllCompany() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT c FROM Company c",Company.class).getResultList();
	}

	@Override
	public String addCompany(Company c) {
		// TODO Auto-generated method stub
		em.persist(c);
		return "Done";
	}

	@Override
	public String deleteCompany(int id) {
		// TODO Auto-generated method stub
		em.remove(getCompanyById(id));
		return "Done";
	}

	@Override
	public String updateCompany(Company c) {
		// TODO Auto-generated method stub
		em.merge(c);
		return "Done";
	}

	@Override
	public Company getCompanyById(int id) {
		// TODO Auto-generated method stub
		return em.find(Company.class, id);
	}

}
