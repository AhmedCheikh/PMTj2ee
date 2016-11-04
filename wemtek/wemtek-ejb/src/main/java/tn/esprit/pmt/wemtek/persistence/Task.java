package tn.esprit.pmt.wemtek.persistence;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity

public class Task implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double duration;
	private int complexity;
	private Date deadLine;
	private String etat;
	@ManyToOne
	private Project projet; 
	@ManyToOne
	private User assignedTo;
	
	private static final long serialVersionUID = 1L;

	public Task() {
		super();
	}	
	public Task(double duration, int complexity , String etat) {
		super();
		this.duration = duration;
		this.complexity = complexity;
		//this.deadLine = deadLine;
		this.etat = etat;
	
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public int getComplexity() {
		return complexity;
	}

	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Project getProjet() {
		return projet;
	}

	public void setProjet(Project projet) {
		this.projet = projet;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}   
	
   
}
