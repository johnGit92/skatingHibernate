import java.util.List;

import dao.Service;
import model.Iscrizione;

public class Main {

	public static void main(String[] args) {
		
		Iscrizione iscrizione=new Iscrizione("aaaa", 101, "U. 21", "sssss", "ddddd", "ggggg", 10, "ccccc", "20");
		Service.getIscrizioneDao().create(iscrizione);
		Service.getIscrizioneDao().delete(iscrizione.getNumero());
		List<Iscrizione> list=Service.getIscrizioneDao().getAll();
		for(Iscrizione i: list)
			System.out.println(i);
	}

}
