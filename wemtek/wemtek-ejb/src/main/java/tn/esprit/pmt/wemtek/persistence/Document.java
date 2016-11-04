package tn.esprit.pmt.wemtek.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Document
 *
 */
@Entity

public class Document implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String path;
	
	public Document(String path) {
		super();
		
		this.path = path;
	}
	@ManyToOne
	private Project projet;
	private static final long serialVersionUID = 1L;

	public Document() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	public Project getProjet() {
		return projet;
	}
	public void setProjet(Project projet) {
		this.projet = projet;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", path=" + path + ", projet=" + projet + "]";
	}
	
   
}
