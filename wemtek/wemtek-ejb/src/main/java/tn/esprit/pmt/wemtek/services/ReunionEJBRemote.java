package tn.esprit.pmt.wemtek.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pmt.wemtek.persistence.Reunion;

@Remote
public interface ReunionEJBRemote {
	public void addReunion(Reunion r) ; 
	public void deleteReunion(Reunion r) ; 
	public void updateReunion(Reunion r) ; 
	public Reunion findReunionById(int id) ; 
	public List<Reunion> findAllReunions();

}
