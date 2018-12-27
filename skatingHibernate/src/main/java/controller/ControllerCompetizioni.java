package controller;

import java.util.List;

import dao.CompetizioneDao;
import dao.Service;
import model.Competizione;
import model.Iscrizione;

public class ControllerCompetizioni {

	public void carica(List<Iscrizione> iscritti){
		CompetizioneDao compDao=Service.getCompetizioneDao();
		for(Iscrizione i:iscritti) {
			compDao.create(new Competizione(i.getCategoria(), i.getSpecialita(), i.getDisciplina(), 
					i.getClasse(), i.getGruppo()));
		}
	}
}
