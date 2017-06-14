package it.uniroma3.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Nazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String nome;
	
	@OneToMany(mappedBy="nazione")
	private List<Autore> autori;

	protected Nazione() {
		this.autori = new LinkedList<>();
	}

	public Nazione(String nome) {
		this();
		this.nome = nome;
	}
}