package tn.esprit.pmt.wemtek.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pmt.wemtek.persistence.Role;

@Remote
public interface RoleServiceEJBRemote {
	
	public void addRole(Role r);
	public void deleteRole(Role r);
	public List<Role> getListRoles();

}
