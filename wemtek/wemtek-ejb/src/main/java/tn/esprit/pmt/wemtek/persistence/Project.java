package tn.esprit.pmt.wemtek.persistence;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity

public class Project implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Name;
	private String Description;
	
	@OneToMany(mappedBy="projet",fetch=FetchType.EAGER)
	private List<Task> listTask;
	
	@OneToMany(mappedBy="projet",fetch=FetchType.EAGER)
	private List<Document> listDocument;
	
	@ManyToMany
	private List<User> TeamMember;
	
	private static final long serialVersionUID = 1L;

	public Project() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
	@XmlTransient
	public List<Task> getListTask() {
		return listTask;
	}
	public void setListTask(List<Task> listTask) {
		this.listTask = listTask;
	}
	@XmlTransient
	public List<Document> getListDocument() {
		return listDocument;
	}
	public void setListDocument(List<Document> listDocument) {
		this.listDocument = listDocument;
	}
	@XmlTransient
	public List<User> getTeamMember() {
		return TeamMember;
	}
	public void setTeamMember(List<User> teamMember) {
		TeamMember = teamMember;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", Name=" + Name + ", Description=" + Description + "]";
	}
   
}
