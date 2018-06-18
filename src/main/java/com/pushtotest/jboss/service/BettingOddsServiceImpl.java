package com.pushtotest.jboss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pushtotest.jboss.dao.BettingOddsDao;
import com.pushtotest.jboss.interfaces.BettingOddsService;
import com.pushtotest.jboss.model.BettingOdds;

@Component
public class BettingOddsServiceImpl implements BettingOddsService{

	@Autowired
	private BettingOddsDao bettingOddsDao;
	
	@Override
	public void save(BettingOdds bettingOdds) {
		bettingOddsDao.persist(bettingOdds);
	}

	@Override
	public List<BettingOdds> findByGameIdAndStatus(String gameId, String status) {
		return bettingOddsDao.findByGameIdAndStatus(gameId, status);
	}

}
