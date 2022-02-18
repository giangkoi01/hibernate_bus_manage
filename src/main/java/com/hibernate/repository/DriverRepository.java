package com.hibernate.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;

import com.hibernate.model.Driver;
import com.hibernate.util.HibernateUtil;

public class DriverRepository {
	public List<Driver> getAll(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("from Driver order by id").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insert(Driver driver) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(driver);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Driver findById(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Driver> query = session.createQuery("from Driver where id=:driver_id");
			query.setParameter("driver_id", id);
			return query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
}
