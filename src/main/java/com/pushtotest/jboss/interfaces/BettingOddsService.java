package com.pushtotest.jboss.interfaces;

import java.util.List;

import com.pushtotest.jboss.model.BettingOdds;

public interface BettingOddsService {
	public void save(BettingOdds bettingOdds);
	public List<BettingOdds> findByGameIdAndStatus(String gameId, String status);
}
