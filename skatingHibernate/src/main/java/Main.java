import java.util.List;

import controller.ControllerIscrizioni;
import model.Iscrizione;

public class Main {

	public static void main(String[] args) {
		
		ControllerIscrizioni controller=new ControllerIscrizioni();
		List<Iscrizione> list=controller.getAll();
		List<Iscrizione> listaOrdinata=controller.ordina(list);
		for(Iscrizione i: listaOrdinata)
			System.out.println(i);
	}

}
