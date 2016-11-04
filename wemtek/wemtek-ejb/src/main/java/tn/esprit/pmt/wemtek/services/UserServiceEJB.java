package tn.esprit.pmt.wemtek.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.pmt.wemtek.persistence.Role;
import tn.esprit.pmt.wemtek.persistence.User;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class UserServiceEJB
 */
@Stateless
@LocalBean
public class UserServiceEJB implements UserServiceEJBRemote {

	@PersistenceContext(unitName="wemtek-ejb")
	EntityManager em ; 

    /**
     * Default constructor. 
     */
    public UserServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addUser(User user) {
		em.persist(user);
		
	}

	@Override
	public void deleteUser(User user) {
		em.remove(em.merge(user));
		
	}

	@Override
	public void updateUser(User user) {
		em.merge(user) ; 
		
	}

	@Override
	public User findUserById(int id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> findAllUsers() {
		//return em.createQuery("SELECT NEW tn.esprit.pmt.wemtek.persistence.User(u.idUser,u.Password,u.FirstName,u.LastName,u.Email,u.State) FROM User u ",User.class).getResultList();
		//return em.createQuery("SELECT u, c  FROM User u LEFT JOIN u.company c").getResultList();
		return em.createQuery("SELECT u FROM User u",User.class).getResultList();
	}
	
	@Override
	public void validateUser(User user){
		em.createQuery("UPDATE User u SET u.State=1 where u.idUser = :id ")
		.setParameter("id", user.getIdUser())
		.executeUpdate();
	}
	
	@Override
	public boolean authenticate(String email, String password){
		if (em.createQuery("SELECT u FROM User u where u.Email =  ? and u.Password = ? ")
				.setParameter(1, email)
				.setParameter(2, password)
				.getResultList().size() == 0) {
			System.out.println("Wrong ! ");
			return false ; 
		} 
		else {
			System.out.println("Right ! ");
			return true ; }
	}

	@Override
	public List<User> findUserByName(String name) {
		return em.createQuery("SELECT u FROM User u WHERE u.FirstName=:f",User.class).setParameter("f", name).getResultList();
	}

	

	


}
