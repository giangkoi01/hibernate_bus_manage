package com.hibernate.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.model.Router;
import com.hibernate.util.HibernateUtil;

public class RouterRepository {
	public List<Router> getAll(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Router order by id").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insertRouter(Router router) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(router);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Router findById(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Router> query = session.createQuery("from Router where id=:router_id");
			query.setParameter("router_id", id);
			return query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
}
