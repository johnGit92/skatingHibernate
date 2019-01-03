package dao;

import org.hibernate.Session;

import model.Valutazione;

public class ValutazioneHibernateDao implements ValutazioneDao {

	@Override
	public void create(Valutazione valutazione) {
		Session session=HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(valutazione);
			session.getTransaction().commit();
		}finally {
			session.close();
		}

	}

	@Override
	public Valutazione retrieve(int numero) {
		Session session=HibernateUtil.getSession();
		Valutazione valutazione;
		try {
			session.beginTransaction();
			valutazione=session.get(Valutazione.class, numero);
			session.getTransaction().commit();
		}finally {
			session.close();
		}
		return valutazione;
	}

	@Override
	public void update(Valutazione valutazione) {
		Session session=HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(valutazione);
			session.getTransaction().commit();
		}finally {
			session.close();
		}

	}

	@Override
	public void delete(int numero) {
		Session session=HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Valutazione valutazione=session.get(Valutazione.class, numero);
			if(valutazione!=null) {
				session.remove(valutazione);
				System.out.println("Object deleted!");
			}
			session.getTransaction().commit();
		}finally {
			session.close();
		}

	}

}
