package com.pushtotest.jboss.security;

import java.security.acl.Group;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import org.bson.types.ObjectId;
import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.pushtotest.jboss.model.Login;

/**
 * The simples username and password based login module possible,
 * extending JBoss' {@link UsernamePasswordLoginModule}.
 */
@Component
public class UserSecurityService extends UsernamePasswordLoginModule {
	
	@SuppressWarnings("rawtypes")
    public void initialize(Subject subject, CallbackHandler callbackHandler,
            Map sharedState,
            Map options) {
        // We could read options passed via <module-option> in standalone.xml if there were any here
        // For an example see http://docs.redhat.com/docs/en-US/JBoss_Enterprise_Application_Platform/5/html/Security_Guide/sect-Custom_LoginModule_Example.html

        // We could also f.ex. lookup a data source in JNDI
        // For an example see http://www.docjar.com/html/api/org/jboss/security/auth/spi/DatabaseServerLoginModule.java.html
        super.initialize(subject, callbackHandler, sharedState, options);
    }
	
    /**
     * (required) The UsernamePasswordLoginModule modules compares the result of this
     * method with the actual password.
     */
    @Override
    protected String getUsersPassword() throws LoginException {
    	String[] userCredentials = getUsernameAndPassword();
    	String userName = userCredentials[0];
    	//String ePassword = userCredentials[1];
    	System.out.format("Security Service: authenticating user '%s'\n", userName);
    	
    	Login user = null;
    	
    	try {
    		//user = userService.findByUserId(userName);
    		user = passwordFromDB(userName);
    		
    		if(user != null) {
	    		String password = user.getPassword();
	    		System.out.format("Security Service: UserName:" + userName + " and password in DB: '%s'\n", password);
	    		HttpServletRequest request = (HttpServletRequest) javax.security.jacc.PolicyContext.getContext("javax.servlet.http.HttpServletRequest");
	    		request.getSession().setAttribute("user", user);
	    		return password;
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
        return "notValid";
    }
    
    private Login passwordFromDB(String userName) {
    	MongoClient mongoConnection = new MongoClient("localhost");
		DB database = mongoConnection.getDB("test");
		DBCollection collection = database.getCollection("Login");
		BasicDBObject query = new BasicDBObject();
		query.put("userId", userName);
	
		DBCursor cursor = collection.find(query);
		DBObject dbObj = null;
		Login user = null;
		
		try {
			while (cursor.hasNext()) {
				dbObj = cursor.next();
				user = new Login();
				ObjectId objId = (ObjectId) dbObj.get("_id");
				user.setId(objId.toString());
				user.setUserId((String) dbObj.get("userId"));
				user.setPassword((String) dbObj.get("password"));
				user.setFirstName((String) dbObj.get("firstName"));
				user.setLastName((String) dbObj.get("lastName"));
				user.setBalance((int) dbObj.get("balance"));
			}
		} finally {
			mongoConnection.close();
			cursor.close();
		}
		return user;
    }
    

    /**
     * (required) The groups of the user, there must be at least one group called
     * "Roles" (though it likely can be empty) containing the roles the user has.
     */
    @Override
    protected Group[] getRoleSets() throws LoginException {
        SimpleGroup group = new SimpleGroup("Roles");
        try {
            group.addMember(new SimplePrincipal("USER"));
        } catch (Exception e) {
            throw new LoginException("Failed to create group member for " + group);
        }
        return new Group[] { group };
    }

}