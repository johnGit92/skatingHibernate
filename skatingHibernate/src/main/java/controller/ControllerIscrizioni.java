package controller;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dao.Service;
import model.Competizione;
import model.Iscrizione;

public class ControllerIscrizioni {

	public List<Iscrizione> getAll() {
		return Service.getIscrizioneDao().getAll();
	}
	
	public List<Iscrizione> ordina(List<Iscrizione> list){
		Comparator<Iscrizione> comparator=new Comparator<Iscrizione>() {

			@Override
			public int compare(Iscrizione o1, Iscrizione o2) {
				
				//primo livello di ordinamento (categoria)
				if(o1.getCategoria().getVal()<o2.getCategoria().getVal())
					return -1;
				else if(o1.getCategoria().getVal()>o2.getCategoria().getVal())
					return 1;
				else {
					//secondo livello di ordinamento (specialità)
					if(o1.getSpecialita().getVal()<o2.getSpecialita().getVal())
						return -1;
					else if(o1.getSpecialita().getVal()>o2.getSpecialita().getVal())
						return 1;
					else {
						//terzo livello di ordinamento (disciplina)
						if(o1.getDisciplina().getVal()<o2.getDisciplina().getVal())
							return -1;
						else if(o1.getDisciplina().getVal()>o2.getDisciplina().getVal())
							return 1;
						else {
							//quarto livello di ordinamento (classe)
							if(o1.getClasse().getVal()<o2.getClasse().getVal())
								return -1;
							else if(o1.getClasse().getVal()>o2.getClasse().getVal())
								return 1;
							else {
								//quinto livello di ordinamento (piccolo/grande gruppo)
								if(o1.getGruppo().getVal()<o2.getGruppo().getVal())
									return -1;
								else if(o1.getGruppo().getVal()>o2.getGruppo().getVal())
									return 1;								
							}
						}
					}
					
				}
				return 0;
			}
			
		};
		Collections.sort(list, comparator);
		return list;
	}
	
	public List<Competizione> getCompetizioni(){
		return Service.getIscrizioneDao().getCompetizioni();
	}
	
	public List<Competizione> ordinaCompetizioni(List<Competizione> competizioni){
		Comparator<Competizione> comparator=new Comparator<Competizione>() {

			@Override
			public int compare(Competizione o1, Competizione o2) {
				
				//primo livello di ordinamento (categoria)
				if(o1.getCategoria().getVal()<o2.getCategoria().getVal())
					return -1;
				else if(o1.getCategoria().getVal()>o2.getCategoria().getVal())
					return 1;
				else {
					//secondo livello di ordinamento (specialità)
					if(o1.getSpecialita().getVal()<o2.getSpecialita().getVal())
						return -1;
					else if(o1.getSpecialita().getVal()>o2.getSpecialita().getVal())
						return 1;
					else {
						//terzo livello di ordinamento (disciplina)
						if(o1.getDisciplina().getVal()<o2.getDisciplina().getVal())
							return -1;
						else if(o1.getDisciplina().getVal()>o2.getDisciplina().getVal())
							return 1;
						else {
							//quarto livello di ordinamento (classe)
							if(o1.getClasse().getVal()<o2.getClasse().getVal())
								return -1;
							else if(o1.getClasse().getVal()>o2.getClasse().getVal())
								return 1;
							else {
								//quinto livello di ordinamento (piccolo/grande gruppo)
								if(o1.getGruppo().getVal()<o2.getGruppo().getVal())
									return -1;
								else if(o1.getGruppo().getVal()>o2.getGruppo().getVal())
									return 1;								
							}
						}
					}
					
				}
				return 0;
			}
			
		};
		Collections.sort(competizioni,comparator);
		
		return competizioni;
	}
	
}
