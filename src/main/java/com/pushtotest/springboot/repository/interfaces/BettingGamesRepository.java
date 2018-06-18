package com.pushtotest.springboot.repository.interfaces;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pushtotest.springboot.model.BettingGames;

// No need implementation, just one interface, and you have CRUD, thanks Spring Data
public interface BettingGamesRepository extends MongoRepository<BettingGames, Long>/*, LoginRepositoryCustom*/ {
	List<BettingGames> findAll();
	List<BettingGames> findAllDistinctByType();
	List<BettingGames> findByType(String type);
}