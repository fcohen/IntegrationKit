package com.pushtotest.jboss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pushtotest.jboss.dao.BettingGamesDao;
import com.pushtotest.jboss.interfaces.BettingGamesService;
import com.pushtotest.jboss.model.BettingGames;

@Component
public class BettingGamesServiceImpl implements BettingGamesService{

	@Autowired
	private BettingGamesDao bettingGamesDao;
	
	@Override
	public void save(BettingGames bettingGames) {
		bettingGamesDao.persist(bettingGames);
	}

	@Override
	public List<BettingGames> findAll() {
		return bettingGamesDao.findAll();
	}

	@Override
	public List<BettingGames> findByType(String type) {
		return bettingGamesDao.findByType(type);
	}

}
