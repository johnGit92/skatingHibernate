package dao;

import model.Valutazione;

public interface ValutazioneDao {

	void create(Valutazione valutazione);
	Valutazione retrieve(int numero);
	void update(Valutazione valutazione);
	void delete(int numero);
}
