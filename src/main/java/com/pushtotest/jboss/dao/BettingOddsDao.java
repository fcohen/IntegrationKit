package com.pushtotest.jboss.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.pushtotest.jboss.model.BettingOdds;

@Component
public class BettingOddsDao {
	static EntityManagerFactory entityManagerFactory;

	public static EntityManagerFactory setUpEntityManagerFactory() {
		return entityManagerFactory = Persistence
				.createEntityManagerFactory("MongoJpa");
	}
	
	public void persist(BettingOdds bettingOdds) {
		EntityManager em = setUpEntityManagerFactory()
				.createEntityManager();
		try {
			if(bettingOdds != null) {
				em.getTransaction().begin();
				em.persist(bettingOdds);
				em.getTransaction().commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public List<BettingOdds> findByGameIdAndStatus(String gameId, String status){
		EntityManager em = setUpEntityManagerFactory()
				.createEntityManager();
		List<BettingOdds> bettingOdds = null;
		
		try {
			Query query = em.createQuery("SELECT * FROM BetOdds where gameId='" + gameId + "' and status='" + status + "'");
			bettingOdds = (List<BettingOdds>) query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return bettingOdds;
	}
}
