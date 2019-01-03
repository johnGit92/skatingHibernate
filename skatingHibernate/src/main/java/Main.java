import java.util.List;

import controller.Controller;
import dao.CompetizioneDao;
import dao.IscrizioneDao;
import dao.Service;
import model.Competizione;
import model.Iscrizione;

public class Main {

	public static void main(String[] args) {
		
		Controller controller=new Controller();
		
		//genera e memorizza 500 iscritti in maniera pseudocasuale
		List<Iscrizione> list=controller.generaIscritti(500);
		IscrizioneDao iscrizioneDao=Service.getIscrizioneDao();
		for(Iscrizione i:list) {
			iscrizioneDao.create(i);
		}
		
		//ottieni e ordina lista competizioni
		List<Competizione>competizioni=controller.getCompetizioni();
		competizioni=controller.ordinaCompetizioni(competizioni);
		
		//memorizza competizioni
		CompetizioneDao compDao=Service.getCompetizioneDao();
		for(Competizione competizione: competizioni) {
			compDao.create(competizione);
		}
	}

}
