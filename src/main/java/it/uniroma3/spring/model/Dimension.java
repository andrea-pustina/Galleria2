package it.uniroma3.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Dimension {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private int x;
	
	@NotNull
	private int y;
	
	@OneToOne(mappedBy="dimension")
	private Opera opera;

	protected Dimension() {
	}

	public Dimension(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Opera getOpera() {
		return opera;
	}

	public void setOpera(Opera opera) {
		this.opera = opera;
	}

	
	
}
