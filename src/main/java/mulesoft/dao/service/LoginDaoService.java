package mulesoft.dao.service;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import mulesoft.dao.interfaces.LoginDao;
import mulesoft.model.Login;

@Component
public class LoginDaoService implements LoginDao {
	static EntityManagerFactory entityManagerFactory;

	public static EntityManagerFactory setUpEntityManagerFactory() {
		return entityManagerFactory = Persistence
				.createEntityManagerFactory("MongoJpa");
	}
	
	public void save(Login user) {
		EntityManager em = setUpEntityManagerFactory()
				.createEntityManager();
		try {
			if(user != null) {
				em.getTransaction().begin();
				em.persist(user);
				em.getTransaction().commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public Login findByUserId(String userId) {
		EntityManager em = setUpEntityManagerFactory()
				.createEntityManager();
		Login user = null;
		
		try {
			Query query = em.createQuery("SELECT * FROM Login where userId='" + userId + "'");
			user = (Login) query.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return user;
	}
	
	public Login findByUserNameAndPassword(String userId, String password) {
		EntityManager em = setUpEntityManagerFactory()
				.createEntityManager();
		Login user = null;
		
		try {
			Query query = em.createQuery("SELECT * FROM Login where userId='" + userId + "' and password='" + password + "'");
			user = (Login) query.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return user;
	}
	
	public void updateBalance(String userId, int balance) {
		EntityManager em = setUpEntityManagerFactory()
				.createEntityManager();
		
		try {
			Login user = findByUserId(userId);
			if(user != null) {
			  em.getTransaction().begin();
			  user.setBalance(balance);
			  em.persist(user);
			  em.getTransaction().commit();
			}
			  
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
}
