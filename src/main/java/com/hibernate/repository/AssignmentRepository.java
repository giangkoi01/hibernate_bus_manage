package com.hibernate.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernate.model.Assignment;
import com.hibernate.util.HibernateUtil;

public class AssignmentRepository {
	public List<Assignment> getAll(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Assignment").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insertAssignment(Assignment assignment) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(assignment);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
}
