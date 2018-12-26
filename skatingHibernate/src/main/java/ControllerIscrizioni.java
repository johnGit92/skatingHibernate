import java.util.List;

import dao.Service;
import model.Iscrizione;

public class ControllerIscrizioni {

	public List<Iscrizione> getAll() {
		return Service.getIscrizioneDao().getAll();
	}
	
	
	
}
