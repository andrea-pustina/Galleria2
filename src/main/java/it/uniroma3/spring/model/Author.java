package it.uniroma3.spring.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String firstname;
	
	@NotNull
	@Size(min=1)
	private String lastname;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Temporal(TemporalType.DATE)
	private Date deathDate;
	
	@ManyToOne
	private Nation nation;
	
	@OneToMany(mappedBy="author")
	private List<Opera> operas;
	

	protected Author() {
		this.operas = new LinkedList<>();
	}

	public Author(String firstname, String lastname, Date birthDate, Date deathDate) {
		this();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate= birthDate;
		this.deathDate = deathDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

	public List<Opera> getOperas() {
		return operas;
	}

	public void setOperas(List<Opera> operas) {
		this.operas = operas;
	}
	
	
}
