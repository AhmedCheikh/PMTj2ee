package tn.esprit.pmt.wemtek.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reunion
 *
 */
@Entity

public class Reunion implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdR;
	private String name;
	private Date DateR;
	private String Type;
	private String Description;
	
	@ManyToMany
	private List<User> listUsers;
	private static final long serialVersionUID = 1L;

	public Reunion() {
		super();
	}   
	public int getIdR() {
		return this.IdR;
	}

	public void setIdR(int IdR) {
		this.IdR = IdR;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Date getDate() {
		return this.DateR;
	}

	public String getType() {
		return this.Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
	public Date getDateR() {
		return DateR;
	}
	public void setDateR(Date dateR) {
		DateR = dateR;
	}
	public List<User> getListUsers() {
		return listUsers;
	}
	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
   
}
