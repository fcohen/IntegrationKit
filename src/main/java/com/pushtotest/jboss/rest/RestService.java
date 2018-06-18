package com.pushtotest.jboss.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.pushtotest.jboss.interfaces.BettingGamesService;
import com.pushtotest.jboss.interfaces.BettingOddsService;
import com.pushtotest.jboss.interfaces.NotificationService;
import com.pushtotest.jboss.model.BettingGames;
import com.pushtotest.jboss.model.BettingOdds;
import com.pushtotest.jboss.model.Notifications;
import com.pushtotest.jboss.model.UserIdentification;

@Path("/api")
public class RestService {

	@Autowired
    private BettingGamesService gamesRepository;
	
	@Autowired
    private BettingOddsService oddsRepository;

	@Autowired
    private NotificationService nRepository;
	
    @GET
	@Path("/gamesType")
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
    
    @GET
	@Path("/gamesList")
    public String gamesList(@QueryParam("game") String gameType) throws JSONException {
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
    
    @GET
	@Path("/createNotif")
    public String createNotif(@QueryParam("userId") String userId) throws JSONException {
    	Notifications notif = new Notifications(userId, "UNREAD", "Sample Title", "Sample Description");
    	notif.setCreatedDate(new Date());
    	nRepository.save(notif);
    	return "done";
    }
    
    @GET
	@Path("/markAsRead")
    public String createNotif(@QueryParam("userId") String userId, @QueryParam("nId") String nId) throws JSONException {
    	Notifications notif = nRepository.findById(nId);
    	notif.setStatus("READ");
    	nRepository.save(notif);
    	return "done";
    }
    
    @GET
	@Path("/getReadNotifications")
    public String greeting(@QueryParam("userId") String userId) throws Exception {
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
    
    @GET
	@Path("/lockAnOdd")
    public String lockAnOdd(@QueryParam("userId") String userId, @QueryParam("gameId") String gameId, @QueryParam("oddType") String oddType) throws JSONException {
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
