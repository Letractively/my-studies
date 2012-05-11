package br.com.mystudies.domain.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.mystudies.domain.enun.SprintStatus;

@Entity
@Table(name="SPRINT")
public class Sprint implements EntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name="NUMBER")
	private Long number;
	
	@Column(name="POINTS")
	private Long points;
		
	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FINAL_DATE")
	private Date finalDate;
	
	@Enumerated(EnumType.STRING)
	private SprintStatus sprintStatus;
	
	@OneToMany(mappedBy="sprint", cascade = CascadeType.ALL, fetch=FetchType.EAGER) // FIXME: can't eager !!
	private Set<Story> stories;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public SprintStatus getSprintStatus() {
		return sprintStatus;
	}

	public void setSprintStatus(SprintStatus sprintStatus) {
		this.sprintStatus = sprintStatus;
	}

	public Set<Story> getStories() {
		return stories;
	}

	public void setStories(Set<Story> stories) {
		this.stories = stories;
	}
		
}
