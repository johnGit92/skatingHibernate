import java.util.List;

import controller.ControllerCompetizioni;
import controller.ControllerIscrizioni;
import dao.CompetizioneDao;
import dao.Service;
import model.Categoria;
import model.Classe;
import model.Competizione;
import model.Disciplina;
import model.Gruppo;
import model.Iscrizione;
import model.Specialita;

public class Main {

	public static void main(String[] args) {
		
		ControllerIscrizioni controller=new ControllerIscrizioni();
		List<Competizione>tuples=controller.getCompetizioni();
		tuples=controller.ordinaCompetizioni(tuples);
		CompetizioneDao compDao=Service.getCompetizioneDao();
		for(Competizione tuple: tuples) {
			compDao.create(tuple);
		}
	}

}
