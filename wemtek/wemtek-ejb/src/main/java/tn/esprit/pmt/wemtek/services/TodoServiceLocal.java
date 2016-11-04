package tn.esprit.pmt.wemtek.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.pmt.wemtek.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
