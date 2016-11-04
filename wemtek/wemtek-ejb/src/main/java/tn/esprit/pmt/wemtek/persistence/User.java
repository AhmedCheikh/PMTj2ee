package tn.esprit.pmt.wemtek.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	private int idUser;
	private String Password;
	private String FirstName;
	private String LastName;
	private String Email;
	private Boolean State ; 
	@OneToOne
	private Role UserRole;
	@ManyToOne
	private Company company;
	@ManyToMany(mappedBy="TeamMember")
	private List<Project> ProjectList;
	
	@OneToMany(mappedBy="assignedTo")
	private List<Task> TaskList;
	
	@ManyToMany
	private List<Reunion> listReuinon;
	
	@ManyToOne
	private Template templateId;
	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   

	public User(int idUser, String password, String firstName, String lastName, String email, Boolean state,
			Role userRole, Company company, List<Project> projectList, List<Task> taskList, List<Reunion> listReuinon,
			Template templateId) {
		super();
		this.idUser = idUser;
		Password = password;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		State = state;
		UserRole = userRole;
		this.company = company;
		ProjectList = projectList;
		TaskList = taskList;
		this.listReuinon = listReuinon;
		this.templateId = templateId;
	}



	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}   
	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}   
	public String getFirstName() {
		return this.FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}   
	public String getLastName() {
		return this.LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}   
	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}
	public Role getUserRole() {
		return UserRole;
	}
	public void setUserRole(Role userRole) {
		UserRole = userRole;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	@XmlTransient
	public List<Project> getProjectList() {
		return ProjectList;
	}
	public void setProjectList(List<Project> projectList) {
		ProjectList = projectList;
	} 
	
	@XmlTransient
	public List<Task> getTaskList() {
		return TaskList;
	}
	public void setTaskList(List<Task> taskList) {
		TaskList = taskList;
	}
	
	@XmlTransient
	public List<Reunion> getListReuinon() {
		return listReuinon;
	}
	public void setListReuinon(List<Reunion> listReuinon) {
		this.listReuinon = listReuinon;
	}
	
	@XmlTransient
	public Template getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Template templateId) {
		this.templateId = templateId;
	}
	
	public Boolean getState() {
		return State;
	}

	public void setState(Boolean state) {
		State = state;
	}

   
}
