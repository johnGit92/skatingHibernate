package dao;

public class Service {
	
	private static IscrizioneDao iscrizioneDao;
	
	public static IscrizioneDao getIscrizioneDao(){
		if(iscrizioneDao==null) iscrizioneDao = new IscrizioneHibernateDao();
		return iscrizioneDao;
	}
}
