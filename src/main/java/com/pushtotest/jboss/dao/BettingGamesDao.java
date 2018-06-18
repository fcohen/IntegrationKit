package com.pushtotest.jboss.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.pushtotest.jboss.model.BettingGames;
import com.pushtotest.jboss.model.Notifications;

@Component
public class BettingGamesDao {
	
	static EntityManagerFactory entityManagerFactory;

	public static EntityManagerFactory setUpEntityManagerFactory() {
		return entityManagerFactory = Persistence
				.createEntityManagerFactory("MongoJpa");
	}
	
	public void persist(BettingGames bettingGames) {
		EntityManager em = setUpEntityManagerFactory()
				.createEntityManager();
		try {
			if(bettingGames != null) {
				em.getTransaction().begin();
				em.persist(bettingGames);
				em.getTransaction().commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public List<BettingGames> findAll(){
		EntityManager em = setUpEntityManagerFactory()
				.createEntityManager();
		List<BettingGames> bettingGames = null;
		
		try {
			Query query = em.createNativeQuery("db.BetGames.find()");
			bettingGames = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return bettingGames;
	}
	
	
	public List<BettingGames> findByType(String type){
		EntityManager em = setUpEntityManagerFactory()
				.createEntityManager();
		List<BettingGames> bettingGames = null;
		
		try {
			Query query = em.createQuery("SELECT * FROM BetGames where type='" + type + "'");
			bettingGames = (List<BettingGames>) query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return bettingGames;
	}
}
