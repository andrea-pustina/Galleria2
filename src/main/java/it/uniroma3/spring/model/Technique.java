package it.uniroma3.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Technique {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String name;
	
	@OneToMany(mappedBy="technique")
	private List<Opera> operas;

	protected Technique() {}

	public Technique(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Opera> getOperas() {
		return operas;
	}

	public void setOperas(List<Opera> operas) {
		this.operas = operas;
	}
	
	
}

