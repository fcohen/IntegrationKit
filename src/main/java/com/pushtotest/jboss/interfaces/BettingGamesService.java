package com.pushtotest.jboss.interfaces;

import java.util.List;

import com.pushtotest.jboss.model.BettingGames;

public interface BettingGamesService {
	public void save(BettingGames bettingGames);
	public List<BettingGames> findAll();
	public List<BettingGames> findByType(String type);
}
