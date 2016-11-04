package Client;

import java.lang.reflect.Proxy;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.pmt.wemtek.persistence.Task;
import tn.esprit.pmt.wemtek.services.TaskServiceEJBRemote;




public class TestTask {

	
	public static void addTask(Task task) throws NamingException {

		InitialContext context = new InitialContext();
		TaskServiceEJBRemote proxy = (TaskServiceEJBRemote) context
				.lookup("wemtek-ear/wemtek-ejb/TaskServiceEJB!tn.esprit.pmt.wemtek.services.TaskServiceEJBRemote");
		
		
		
		proxy.addTask(task);

		System.out.println("task added!");

	}
	
	public static void updateTask(Task task, int complexity, double Duration, String Etat) throws NamingException {
		InitialContext context = new InitialContext();
		TaskServiceEJBRemote proxy = (TaskServiceEJBRemote) context
				.lookup("wemtek-ear/wemtek-ejb/TaskServiceEJB!tn.esprit.pmt.wemtek.services.TaskServiceEJBRemote");
		task.setComplexity(complexity);
		// task.setDeadLine(DeadLine);
		task.setEtat(Etat);

		task.setDuration(Duration);
		proxy.updateTask(task);

		System.out.println("task :" + task.getId() + " has been modified");

	}
	public static Task findTaskById(int id, boolean visibility) throws NamingException {
		InitialContext context = new InitialContext();
		TaskServiceEJBRemote proxy = (TaskServiceEJBRemote) context
				.lookup("wemtek-ear/wemtek-ejb/TaskServiceEJB!tn.esprit.pmt.wemtek.services.TaskServiceEJBRemote");
		Task task = proxy.findTaskById(id);
		if (visibility) {
			System.out.println("Task : " + "Id=" + task.getId() + " Name=" + task.getComplexity() + " Description="
					+ task.getDuration());
		}
		return task;
	}
	public static void deleteTaskById(int id) throws NamingException {
		InitialContext context = new InitialContext();
		TaskServiceEJBRemote proxy = (TaskServiceEJBRemote) context
				.lookup("wemtek-ear/wemtek-ejb/TaskServiceEJB!tn.esprit.pmt.wemtek.services.TaskServiceEJBRemote");
		proxy.deleteTask(proxy.findTaskById(id));
		System.out.println("Project deleted!");
	}
	
	public static String ProjectPercentageOfCompletion (int idProject) throws NamingException {
		InitialContext context = new InitialContext();
		TaskServiceEJBRemote proxy = (TaskServiceEJBRemote) context
				.lookup("wemtek-ear/wemtek-ejb/TaskServiceEJB!tn.esprit.pmt.wemtek.services.TaskServiceEJBRemote");
		String task= proxy.ProjectPercentageOfCompletion(idProject);
		
		return task ;
		}
	
	
	
	
	
	public static void main(String[] args)throws NamingException {
		Task task = new Task (80 , 9,"syrine");
        // addTask(task);	
		//updateTask(task, 15,7,"dd");
		// findTaskById(2, false);
		//deleteTaskById(0);
		System.out.println(ProjectPercentageOfCompletion(1));

	}

}
