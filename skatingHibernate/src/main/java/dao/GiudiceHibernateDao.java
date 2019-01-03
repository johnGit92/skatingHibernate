package dao;

import org.hibernate.Session;

import model.Giudice;

public class GiudiceHibernateDao implements GiudiceDao{

	@Override
	public void create(Giudice giudice) {
		Session session=HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(giudice);
			session.getTransaction().commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public Giudice retrieve(String id) {
		Session session=HibernateUtil.getSession();
		Giudice giudice;
		try {
			session.beginTransaction();
			giudice=session.get(Giudice.class, id);
			session.getTransaction().commit();
		}finally {
			session.close();
		}
		return giudice;
	}

	@Override
	public void update(Giudice giudice) {
		Session session=HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(giudice);
			session.getTransaction().commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void delete(String id) {
		Session session=HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Giudice giudice=session.get(Giudice.class, id);
			if(giudice!=null) {
				session.remove(giudice);
				System.out.println("Object deleted!");
			}
			session.getTransaction().commit();
		}finally {
			session.close();
		}
		
	}

}
