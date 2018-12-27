package dao;

import org.hibernate.Session;

import model.Competizione;

public class CompetizioneHibernateDao implements CompetizioneDao {

	@Override
	public void create(Competizione competizione) {
		Session session=HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(competizione);
			session.getTransaction().commit();
		}finally {
			session.close();
		}

	}

	@Override
	public Competizione retrieve(int id) {
		Session session=HibernateUtil.getSession();
		Competizione competizione;
		try {
			session.beginTransaction();
			competizione=session.get(Competizione.class, id);
			session.getTransaction().commit();
		}finally {
			session.close();
		}
		return competizione;
	}

	@Override
	public void update(Competizione competizione) {
		Session session=HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(competizione);
			session.getTransaction().commit();
		}finally {
			session.close();
		}

	}

	@Override
	public void delete(int id) {
		Session session=HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Competizione competizione=session.get(Competizione.class, id);
			if(competizione!=null) {
				session.remove(competizione);
				System.out.println("Object removed!");
			}
			session.getTransaction().commit();
		}finally {
			session.close();
		}

	}

}
