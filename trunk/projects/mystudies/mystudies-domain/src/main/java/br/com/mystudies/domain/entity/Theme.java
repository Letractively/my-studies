package br.com.mystudies.domain.entity;

import java.util.Date;
import java.util.List;

import br.com.mystudies.domain.enun.Priority;

/**
 * @author Robson
 */
public class Theme {


	private String title;

	private Priority priority;

	private Date creationDate;

	private List<Story> stories;

	private List<Comment> comments;

	public Theme(String name, Priority priority, Date creationDate) {
		super();
		this.title = name;
		this.priority = priority;
		this.creationDate = creationDate;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
