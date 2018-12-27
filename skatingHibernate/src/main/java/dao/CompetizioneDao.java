package dao;

import model.Competizione;

public interface CompetizioneDao {

	public void create(Competizione competizione);
	public Competizione retrieve(int id);
	public void update(Competizione competizione);
	public void delete(int id);
}
