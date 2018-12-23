package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "iscrizioni")
public class Iscrizione {
	
	private String asd;
	private int numero;
	private String categoria;
	private String specialita;
	private String disciplina;
	private String gruppo;
	private int n;
	private String classe;
	private String ballerini;
	
	public Iscrizione() {
		super();
	}

	public Iscrizione(String asd, int numero, String categoria, String specialita, String disciplina, String gruppo,
			int n, String classe, String ballerini) {
		super();
		this.asd = asd;
		this.numero = numero;
		this.categoria = categoria;
		this.specialita = specialita;
		this.disciplina = disciplina;
		this.gruppo = gruppo;
		this.n = n;
		this.classe = classe;
		this.ballerini = ballerini;
	}

	public String getAsd() {
		return asd;
	}

	public void setAsd(String asd) {
		this.asd = asd;
	}

	@Id
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSpecialita() {
		return specialita;
	}

	public void setSpecialita(String specialita) {
		this.specialita = specialita;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getGruppo() {
		return gruppo;
	}

	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getBallerini() {
		return ballerini;
	}

	public void setBallerini(String ballerini) {
		this.ballerini = ballerini;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	@Override
	public String toString() {
		return "Iscrizioni [asd=" + asd + ", numero=" + numero + ", categoria=" + categoria + ", specialita="
				+ specialita + ", disciplina=" + disciplina + ", gruppo=" + gruppo + ", n=" + n + ", classe=" + classe
				+ ", ballerini=" + ballerini + "]";
	}

}
