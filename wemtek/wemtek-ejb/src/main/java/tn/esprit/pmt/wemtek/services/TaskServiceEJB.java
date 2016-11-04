package tn.esprit.pmt.wemtek.services;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.pmt.wemtek.persistence.Task;

/**
 * Session Bean implementation class TaskServiceEJB
 */
@Stateless
@LocalBean
public class TaskServiceEJB implements TaskServiceEJBRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName = "wemtek-ejb")
	EntityManager entitymanager;
    public TaskServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addTask(Task task) {
	entitymanager.persist(task);
		
	}

	@Override
	public void deleteTask(Task task) {
	entitymanager.remove(entitymanager.merge(task));
		
	}

	@Override
	public void updateTask(Task task) {
	entitymanager.merge(task);
		
	}

	@Override
	public Task findTaskById(int id) {
		return entitymanager.find(Task.class, id);
		
	}

	@Override
	public List<Task> findAllTasks() {
		return entitymanager.createQuery("SELECT task FROM Task task ", Task.class).getResultList();
		
	}

}
