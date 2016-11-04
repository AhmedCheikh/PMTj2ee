package tn.esprit.pmt.wemtek.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity

public class Role implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int RoleId;
	private String Role;
	@OneToOne(mappedBy="UserRole")
	private User user;
	private static final long serialVersionUID = 1L;

	public Role() {
		super();
	}   
	
	public Role(int roleId, String role, User user) {
		super();
		RoleId = roleId;
		Role = role;
		this.user = user;
	}




	public int getRoleId() {
		return this.RoleId;
	}

	public void setRoleId(int RoleId) {
		this.RoleId = RoleId;
	}   
	public String getRole() {
		return this.Role;
	}

	public void setRole(String Role) {
		this.Role = Role;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
   
}
