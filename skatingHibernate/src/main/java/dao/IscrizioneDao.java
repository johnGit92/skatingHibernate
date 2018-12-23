package dao;

import java.util.List;

import model.Iscrizione;

/**
 * CRUD operation on "Iscrizione" entity.
 *
 */
public interface IscrizioneDao {
	
	void create(Iscrizione customer);
	void update(Iscrizione customer);
	Iscrizione retrieve(int numero);
	void delete(int numero);
	List<Iscrizione> getAll();
}
