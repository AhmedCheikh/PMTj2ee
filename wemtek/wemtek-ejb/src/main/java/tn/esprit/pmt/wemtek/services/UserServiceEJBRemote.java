package tn.esprit.pmt.wemtek.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pmt.wemtek.persistence.Role;
import tn.esprit.pmt.wemtek.persistence.User;

@Remote
public interface UserServiceEJBRemote {
	
	public void addUser(User user) ; 
	public void deleteUser(User user) ; 
	public void updateUser(User user) ; 
	public User findUserById(int id) ; 
	public List<User> findAllUsers();
	public void validateUser(User user); 
	public boolean authenticate(String email, String Password);
	public List<User> findUserByName(String name) ;
	
}
