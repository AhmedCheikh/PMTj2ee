package tn.esprit.pmt.wemtek.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Company
 *
 */
@Entity

public class Company implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Name;
	private String Website;

	@OneToMany(mappedBy="company")
	private List<User> Members;
	
	private static final long serialVersionUID = 1L;

	public Company() {
		super();
	}   
	public int getId() {
		return this.Id;
	}
	@XmlTransient
	public List<User> getMembers() {
		return Members;
	}
	public void setMembers(List<User> members) {
		Members = members;
	}
	public void setId(int Id) {
		this.Id = Id;
	}   
	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}   
	public String getWebsite() {
		return this.Website;
	}

	public void setWebsite(String Website) {
		this.Website = Website;
	}
	@Override
	public String toString() {
		return "Company [Id=" + Id + ", Name=" + Name + ", Website=" + Website + "]";
	}

   
}
