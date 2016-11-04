package tn.esprit.pmt.wemtek.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Template
 *
 */
@Entity

public class Template implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTemplate;
	private String Path;
	
	@OneToMany(mappedBy="templateId")
	private List<User> listUsers;
	private static final long serialVersionUID = 1L;

	public Template() {
		super();
	}   
	public int getIdTemplate() {
		return this.idTemplate;
	}
	
	public void setIdTemplate(int idTemplate) {
		this.idTemplate = idTemplate;
	}   
	public String getPath() {
		return this.Path;
	}

	public void setPath(String Path) {
		this.Path = Path;
	}
	public List<User> getListUsers() {
		return listUsers;
	}
	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
   
}
