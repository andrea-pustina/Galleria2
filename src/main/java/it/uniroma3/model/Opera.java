package it.uniroma3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Opera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String titolo;
	
	@NotNull
	@Size(min=1)
	private int anno;
	
	@NotNull
	@Size(min=1)
	private String dimensioni;
	
	@NotNull
	@ManyToOne
	private Autore autore;
	
	@NotNull
	@ManyToOne
	private Tecnica tecnica;	

	protected Opera() {}

	public Opera(String titolo, int anno, String dimensioni, Autore autore, Tecnica tecnica) {
		this.titolo = titolo;
		this.anno = anno;
		this.dimensioni = dimensioni;
		this.autore = autore;
		this.tecnica = tecnica;
	}

	@Override
	public String toString() {
		return String.format(
				"Opera[id=%d, titolo='%s']",id, titolo);
	}



}

