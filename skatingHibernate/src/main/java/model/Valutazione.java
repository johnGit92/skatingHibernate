package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="valutazioni")
public class Valutazione {

	private int pk;
	private int numero;
	private String giudice;
	private double tecnico;
	private double coreografico;
	
	public Valutazione(int numero, String id, double tecnico, double coreografico) {
		super();
		this.numero = numero;
		this.giudice = id;
		this.tecnico = tecnico;
		this.coreografico = coreografico;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getId() {
		return giudice;
	}

	public void setId(String id) {
		this.giudice = id;
	}

	public double getTecnico() {
		return tecnico;
	}

	public void setTecnico(double tecnico) {
		this.tecnico = tecnico;
	}

	public double getCoreografico() {
		return coreografico;
	}

	public void setCoreografico(double coreografico) {
		this.coreografico = coreografico;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk")	
	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	@Override
	public String toString() {
		return "Valutazione [numero=" + numero + ", id=" + giudice + ", tecnico=" + tecnico + ", coreografico="
				+ coreografico + "]";
	}
	

}
