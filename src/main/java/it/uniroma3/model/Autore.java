package it.uniroma3.model;

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
public class Autore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String nome;
	
	@NotNull
	@Size(min=1)
	private String cognome;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	
	@Temporal(TemporalType.DATE)
	private Date dataMorte;
	
	@ManyToOne
	private Nazione nazione;
	
	@OneToMany(mappedBy="autore")
	private List<Opera> opere;
	

	protected Autore() {
		this.opere = new LinkedList<>();
	}

	public Autore(String nome, String cognome, Date dataNascita, Date dataMorte) {
		this();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita= dataNascita;
		this.dataMorte = dataMorte;
	}
}
