package com.pushtotest.jboss.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.pushtotest.jboss.model.Notifications;

@Component
public class NotificationDao {
	static EntityManagerFactory entityManagerFactory;

	public static EntityManagerFactory setUpEntityManagerFactory() {
		return entityManagerFactory = Persistence
				.createEntityManagerFactory("MongoJpa");
	}
	
	public void persist(Notifications notification) {
		EntityManager em = setUpEntityManagerFactory()
				.createEntityManager();
		try {
			if(notification != null) {
				em.getTransaction().begin();
				em.persist(notification);
				em.getTransaction().commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public Notifications findById(String id) {
		EntityManager em = setUpEntityManagerFactory()
				.createEntityManager();
		Notifications notifications = null;
		
		try {
			Query query = em.createQuery("SELECT * FROM Notifications where _id='" + id + "'");
			notifications = (Notifications) query.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return notifications;
	}
	
	public List<Notifications> findByUserIdAndStatus(String userId, String status){
		EntityManager em = setUpEntityManagerFactory()
				.createEntityManager();
		List<Notifications> notifications = null;
		
		try {
			Query query = em.createQuery("SELECT * FROM Notifications where userId='" + userId + "' and status='" + status + "'");
			notifications = (List<Notifications>) query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return notifications;
	}
}
