package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Competizione;
import model.Giudice;
import model.Iscrizione;
import model.Valutazione;

public class HibernateUtil {
	private static SessionFactory factory;
	
	private HibernateUtil(){
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Iscrizione.class);
		config.addAnnotatedClass(Competizione.class);
		config.addAnnotatedClass(Giudice.class);
		config.addAnnotatedClass(Valutazione.class);
		factory = config.buildSessionFactory();
	}
	
	public static synchronized Session getSession(){
		if(factory==null) new HibernateUtil();
		return factory.getCurrentSession();
	}
}