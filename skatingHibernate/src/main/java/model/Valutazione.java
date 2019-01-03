package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="valutazioni")
public class Valutazione {

	private int numero;
	private String id;
	private double tecnico;
	private double coreografico;
	
	public Valutazione(int numero, String id, double tecnico, double coreografico) {
		super();
		this.numero = numero;
		this.id = id;
		this.tecnico = tecnico;
		this.coreografico = coreografico;
	}

	@Id
	public long getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Valutazione [numero=" + numero + ", id=" + id + ", tecnico=" + tecnico + ", coreografico="
				+ coreografico + "]";
	}
	

}
