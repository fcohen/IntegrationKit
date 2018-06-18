package com.pushtotest.springboot.config;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.pushtotest.springboot.model.BettingGames;
import com.pushtotest.springboot.model.BettingOdds;
import com.pushtotest.springboot.repository.interfaces.BettingGamesRepository;
import com.pushtotest.springboot.repository.interfaces.BettingOddsRepository;

@Component
public class ApplicationStartup 
implements ApplicationListener<ApplicationReadyEvent> {

  /**
   * This event is executed as late as conceivably possible to indicate that 
   * the application is ready to service requests.
   */
/*	
	@Autowired
    private BettingGamesRepository gamesRepository;
	
	@Autowired
    private BettingOddsRepository oddsRepository;
*/
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		/*
		 * Stops all running bets.
		 */
		
		/*//List<BettingGames> bettingGamesList = gamesRepository.findAllDistinctByType();
		 List<BettingGames> bettingGamesList = gamesRepository.findAll();
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