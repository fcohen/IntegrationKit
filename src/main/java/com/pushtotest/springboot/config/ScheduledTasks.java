package com.pushtotest.springboot.config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pushtotest.springboot.model.BettingGames;
import com.pushtotest.springboot.model.BettingOdds;
import com.pushtotest.springboot.repository.interfaces.BettingGamesRepository;
import com.pushtotest.springboot.repository.interfaces.BettingOddsRepository;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    	
	@Autowired
    private BettingGamesRepository gamesRepository;
	
	@Autowired
    private BettingOddsRepository oddsRepository;


    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 300000)
    public void startABet() {
    	/*
		 * Stops all running bets.
		 */
		
		/*List<BettingGames> bettingGamesList = gamesRepository.findAllDistinctByType();
    	Iterator<BettingGames> itr = bettingGamesList.iterator();
    	    	
    	while(itr.hasNext()){
    		BettingGames bg = itr.next();
	    	List<BettingGames> gamesList = gamesRepository.findByType(bg.getType());
	    	Iterator<BettingGames> itr1 = gamesList.iterator();
	    	
	    	while(itr.hasNext()){
	    		BettingGames bg1 = itr1.next();
		    	List<BettingOdds> bettingOddsList = oddsRepository.findByGameIdAndStatus(bg1.getGameId(), "active");
		    	Iterator<BettingOdds> itr2 = bettingOddsList.iterator();
		    	while(itr2.hasNext()){
		    		BettingOdds bo = itr2.next();
		    		bo.setStatus("inactive");
		    		oddsRepository.save(bo);
		    	}
	    	}
    	}*/
    	
    	/*
    	 * Starts new Bets
    	 */
    	    	
    	/*while(itr.hasNext()){
    		BettingGames bg = itr.next();
	    	List<BettingGames> gamesList = gamesRepository.findByType(bg.getType());
	    	Iterator<BettingGames> itr1 = gamesList.iterator();
	    	
	    	while(itr.hasNext()){
	    		BettingGames bg1 = itr1.next();
	    		BettingOdds bo = new BettingOdds();
	    		bo.setGameId(bg1.getGameId());
	    		bo.setHome("[]");
	    		bo.setDraw("[]");
	    		bo.setAway("[]");
	    		bo.setLock("[]");
	    		bo.setStartDate(new Date());
	    		bo.setStatus("active");
	    	}
    	}*/
    	
    	return;
    }
}
