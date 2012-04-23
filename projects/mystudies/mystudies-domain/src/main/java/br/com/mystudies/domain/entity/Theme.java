package br.com.mystudies.domain.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.mystudies.domain.enun.Priority;

/**
 * @author Robson
 */
@Entity
@Table(name="THEME")
public class Theme implements EntityBase{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="TITLE")
	private String title;

	@Enumerated(EnumType.STRING)
	@Column(name="PRIORITY")
	private Priority priority;

	@Column(name="CREATION_DATE")
	private Date creationDate;

	@ManyToOne
	@JoinColumn(name="BACKLOG_ID")
	private BackLog backLog;

	@Transient // not implemented
	private List<Story> stories;

	@Transient // not implemented
	private List<Comment> comments;


	public Theme() {
	}

	public Theme(String name, Priority priority, Date creationDate) {
		super();
		this.title = name;
		this.priority = priority;
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BackLog getBackLog() {
		return backLog;
	}

	public void setBackLog(BackLog backLog) {
		this.backLog = backLog;
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
