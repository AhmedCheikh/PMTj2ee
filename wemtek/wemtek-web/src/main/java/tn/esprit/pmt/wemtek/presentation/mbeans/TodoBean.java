package tn.esprit.pmt.wemtek.presentation.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.pmt.wemtek.persistence.Todo;
import tn.esprit.pmt.wemtek.services.TodoServiceLocal;

@ManagedBean
@RequestScoped
public class TodoBean {

	@EJB
	private TodoServiceLocal todoServiceLocal;

	private List<Todo> todos;
	private Todo todo;

	public TodoBean() {
	}

	@PostConstruct
	public void init() {
		todos = todoServiceLocal.findAll();
		todo = new Todo();
	}

	public String doCreateTodo() {
		String navigateTo = "/todos?faces-redirect=true";
		todoServiceLocal.create(todo);
		return navigateTo;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public Todo getTodo() {
		return todo;
	}

	public void setTodo(Todo todo) {
		this.todo = todo;
	}

}
