package it.uniroma3.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Opera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String title;

	@NotNull
	private int year;

	@NotNull
	@OneToOne(cascade=CascadeType.ALL)
	private Dimension dimension;

	@NotNull
	@ManyToOne
	private Author author;

	@NotNull
	@ManyToOne
	private Technique technique;	

	protected Opera() {
		this.dimension = new Dimension();
	}

	public Opera(String title, int year, Dimension dimension, Author author, Technique technique) {
		this.title = title;
		this.year = year;
		this.author = author;
		this.technique = technique;
		this.dimension = dimension;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Technique getTechnique() {
		return technique;
	}

	public void setTechnique(Technique technique) {
		this.technique = technique;
	}

}

