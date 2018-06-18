package com.pushtotest.springboot.resources;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pushtotest.springboot.model.BettingGames;
import com.pushtotest.springboot.model.BettingOdds;
import com.pushtotest.springboot.model.Notifications;
import com.pushtotest.springboot.model.UserIdentification;
import com.pushtotest.springboot.repository.interfaces.BettingGamesRepository;
import com.pushtotest.springboot.repository.interfaces.BettingOddsRepository;
import com.pushtotest.springboot.repository.interfaces.NotificationRepository;

@RestController
@RequestMapping("api")
public class RestResource {

	@Autowired
    private BettingGamesRepository gamesRepository;
	
	@Autowired
    private BettingOddsRepository oddsRepository;

	@Autowired
    private NotificationRepository nRepository;
	
    @RequestMapping(value = "/gamesType", produces = "application/json")
    public String gamesType() {
    	//List<BettingGames> bettingGamesList = gamesRepository.findAllDistinctByType();
    	List<BettingGames> bettingGamesList = gamesRepository.findAll();
    	Iterator<BettingGames> itr = bettingGamesList.iterator();
    	
    	JSONArray jAr = new JSONArray();
    	while(itr.hasNext()){
    		/*JSONObject jObj = new JSONObject();
    		jObj.put("game", arg1)*/
    		BettingGames bg = itr.next();
    		jAr.put(bg.getType());
    	}
    	return jAr.toString();
    }
    
    @RequestMapping(value = "/gamesList", produces = "application/json")
    public String gamesList(@RequestParam("game") String gameType) throws JSONException {
    	List<BettingGames> bettingGamesList = gamesRepository.findByType(gameType);
    	Iterator<BettingGames> itr = bettingGamesList.iterator();
    	
    	JSONArray jAr = new JSONArray();
    	while(itr.hasNext()){
    		JSONObject jObj = new JSONObject();
    		BettingGames bg = itr.next();
    		jObj.put("game_id", bg.getGameId());
    		jObj.put("team1", bg.getTeam1());
    		jObj.put("team2", bg.getTeam2());
    		
    		SimpleDateFormat parser=new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
    		parser.setTimeZone(TimeZone.getTimeZone("GMT"));
    		jObj.put("date", parser.format(new Date()));
    		
    		jObj.put("homebet", "-");
    		jObj.put("drawbet", "-");
    		jObj.put("awaybet", "-");
    		jAr.put(jObj);
    	}
    	return jAr.toString();
    }
    
    @RequestMapping(value = "/createNotif", produces = "application/json")
    public String createNotif(@RequestParam("userId") String userId) throws JSONException {
    	Notifications notif = new Notifications(userId, "UNREAD", "Sample Title", "Sample Description");
    	notif.setCreatedDate(new Date());
    	nRepository.save(notif);
    	return "done";
    }
    
    @RequestMapping(value = "/markAsRead", produces = "application/json")
    public String createNotif(@RequestParam("userId") String userId, @RequestParam("nId") String nId) throws JSONException {
    	Notifications notif = nRepository.findById(nId);
    	notif.setStatus("READ");
    	nRepository.save(notif);
    	return "done";
    }
    
    @RequestMapping(value = "/getReadNotifications", produces = "application/json")
    public String greeting(@RequestParam("userId") String userId) throws Exception {
        List<Notifications> nList = nRepository.findByUserIdAndStatus(userId, "READ");
        Iterator<Notifications> itr = nList.iterator();
        
        JSONArray jAr = new JSONArray();
        while(itr.hasNext()){
        	Notifications notif = itr.next();
        	JSONObject jObj = new JSONObject();
        	jObj.put("nId", notif.getId());
        	Date cDate = notif.getCreatedDate();
        	SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-YYYY");
        	jObj.put("date", sdf.format(cDate));
        	jObj.put("title", notif.getTitle());
        	jObj.put("description", notif.getDescription());
        	jObj.put("status", notif.getStatus());
        	
        	jAr.put(jObj);
        }
        return jAr.toString();
    }
    
    @RequestMapping(value = "/lockAnOdd", produces = "application/json")
    public String lockAnOdd(@RequestParam("userId") String userId, @RequestParam("gameId") String gameId, @RequestParam("oddType") String oddType) throws JSONException {
    	List<BettingOdds> bettingOddsList = oddsRepository.findByGameIdAndStatus(gameId, "active");
    	Iterator<BettingOdds> itr = bettingOddsList.iterator();
    	boolean result = true;
    	while(itr.hasNext()){
    		BettingOdds bo = itr.next();
    		String lockStr = (bo.getLock() != null) ? bo.getLock() : "[]";
    		if(lockStr.contains(userId)) result = false;
    		else{
    			JSONArray jAr = new JSONArray(lockStr);
    			jAr.put(userId);
    			bo.setLock(jAr.toString());
    			if(oddType.equals("home")){
    				JSONArray homeList = new JSONArray((bo.getHome() != null) ? bo.getHome() : "[]");
    				homeList.put(userId);
        			bo.setHome(homeList.toString());
    			} else if(oddType.equals("draw")){
    				JSONArray drawList = new JSONArray((bo.getDraw() != null) ? bo.getDraw() : "[]");
    				drawList.put(userId);
        			bo.setHome(drawList.toString());
    			} else if(oddType.equals("away")){
    				JSONArray awayList = new JSONArray((bo.getAway() != null) ? bo.getAway() : "[]");
    				awayList.put(userId);
        			bo.setHome(awayList.toString());
    			}
    			oddsRepository.save(bo);
    		}
    	}
    	return ""+result;
    }
}