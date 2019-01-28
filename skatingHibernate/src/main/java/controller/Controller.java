package controller;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dao.GiudiceDao;
import dao.Service;
import dao.ValutazioneDao;
import model.Categoria;
import model.Classe;
import model.Competizione;
import model.Disciplina;
import model.Giudice;
import model.Iscrizione;
import model.Specialita;
import model.Unita;
import model.Valutazione;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
import view.FogliPilota;

public class Controller {

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
								if(o1.getUnita().getVal()<o2.getUnita().getVal())
									return -1;
								else if(o1.getUnita().getVal()>o2.getUnita().getVal())
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
								if(o1.getUnita().getVal()<o2.getUnita().getVal())
									return -1;
								else if(o1.getUnita().getVal()>o2.getUnita().getVal())
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
	
	public List<Iscrizione> generaIscritti(int n){
		
		List<Iscrizione> list=new ArrayList<Iscrizione>();
		Iscrizione iscrizione;
		String asd;
		Double rand;
		int numero=0;
		int i=0;
		for(i=0;i<n;i++) {
			asd="Scuola"+(i+1);
			rand=Math.random()*1000+1;
			numero=rand.intValue();
			//System.out.print(Categoria.randomCategory()+"\n");
			iscrizione=new Iscrizione(asd, numero, Categoria.randomCategory(), Specialita.randomSpecialita(),
					Disciplina.randomDisciplina(), Unita.randomUnita(), i, 
					Classe.randomClasse(), null);
			//System.out.print(iscrizione+"\n");
			list.add(iscrizione);
		}
		
		return list;
	}
	
	public void visualizzaFogliPilota() {
		
		FogliPilota report=new FogliPilota();
		JasperPrint jprint;
		try {
			File file=new File("reports/report_fogli_pilota.jrprint");
			jprint = (JasperPrint)JRLoader.loadObject(file);
			JRViewer viewer=new JRViewer(jprint);
			report.getContentPane().add(viewer);
			report.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		}
		
	}

	public void inserisciValutazioniCasualiDaIscritti(List<Iscrizione> list) {
		
		ValutazioneDao valutazioneDao=Service.getValutazioneDao();
		int numero;
		double tecnico,coreografico,max=6.0,min=5.5;
		for(Iscrizione i:list) {
			numero=i.getNumero();
			tecnico=(Math.random() * ( max - min )) + min;
			coreografico=(Math.random() * ( max - min )) + min;
			tecnico=Math.round(tecnico*10.0)/10.0;
			coreografico=Math.round(coreografico*10.0)/10.0;
			valutazioneDao.create(new Valutazione(numero, "A", tecnico, coreografico));
			tecnico=(Math.random() * ( max - min )) + min;
			coreografico=(Math.random() * ( max - min )) + min;
			tecnico=Math.round(tecnico*10.0)/10.0;
			coreografico=Math.round(coreografico*10.0)/10.0;
			valutazioneDao.create(new Valutazione(numero, "B", tecnico, coreografico));
			tecnico=(Math.random() * ( max - min )) + min;
			coreografico=(Math.random() * ( max - min )) + min;
			tecnico=Math.round(tecnico*10.0)/10.0;
			coreografico=Math.round(coreografico*10.0)/10.0;
			valutazioneDao.create(new Valutazione(numero, "C", tecnico, coreografico));
			tecnico=(Math.random() * ( max - min )) + min;
			coreografico=(Math.random() * ( max - min )) + min;
			tecnico=Math.round(tecnico*10.0)/10.0;
			coreografico=Math.round(coreografico*10.0)/10.0;
			valutazioneDao.create(new Valutazione(numero, "D", tecnico, coreografico));
			tecnico=(Math.random() * ( max - min )) + min;
			coreografico=(Math.random() * ( max - min )) + min;
			tecnico=Math.round(tecnico*10.0)/10.0;
			coreografico=Math.round(coreografico*10.0)/10.0;
			valutazioneDao.create(new Valutazione(numero, "E", tecnico, coreografico));
		}
	}

	public void generaGiudici(int i) {
		
		GiudiceDao dao=Service.getGiudiceDao();
		int count=i,num=0;
		while(count-->0) {
			dao.create(new Giudice("G"+num,"nome"+num,"cognome"+num));
			num++;
		}
		
	}
	
}
