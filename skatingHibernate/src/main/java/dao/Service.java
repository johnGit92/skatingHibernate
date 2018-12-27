package dao;

public class Service {
	
	private static IscrizioneDao iscrizioneDao;
	private static CompetizioneDao competizioneDao;
	
	public static IscrizioneDao getIscrizioneDao(){
		if(iscrizioneDao==null) iscrizioneDao = new IscrizioneHibernateDao();
		return iscrizioneDao;
	}
	
	public static CompetizioneDao getCompetizioneDao() {
		if(competizioneDao==null) competizioneDao=new CompetizioneHibernateDao();
		return competizioneDao;
	}
}
