package tn.esprit.pmt.wemtek.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pmt.wemtek.persistence.Task;

@Remote
public interface TaskServiceEJBRemote {
	public void addTask(Task task);
	public void deleteTask(Task task);
	public void updateTask(Task task);
	public Task findTaskById(int id);
	public List<Task> findAllTasks();

}
