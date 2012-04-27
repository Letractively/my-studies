package br.com.mystudies.domain.entity;

import java.util.Date;
import java.util.List;

import br.com.mystudies.domain.enun.Priority;
import br.com.mystudies.domain.enun.Status;

/**
 * @author Robson
 */
public class Story implements EntityBase{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private String title;

	private Priority priority;

	private Status status;

	private Date creationDate;

	private Theme theme;
	
	private List<Comment> comments;

	public Story() {
	}
	
	public Story(String title, Priority priority, Status status,
			Date criationDate) {
		super();
		this.title = title;
		this.priority = priority;
		this.status = status;
		this.creationDate = criationDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
