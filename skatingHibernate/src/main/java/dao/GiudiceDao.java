package dao;

import model.Giudice;

public interface GiudiceDao {

	void create(Giudice giudice);
	Giudice retrieve(String id);
	void update(Giudice giudice);
	void delete(String id);
}
