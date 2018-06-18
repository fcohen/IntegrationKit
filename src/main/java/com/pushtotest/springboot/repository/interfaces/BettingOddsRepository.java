package com.pushtotest.springboot.repository.interfaces;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pushtotest.springboot.model.BettingOdds;

public interface BettingOddsRepository extends MongoRepository<BettingOdds, Long> {
	List<BettingOdds> findByGameIdAndStatus(String gameId, String status);
}
