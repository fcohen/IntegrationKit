package mulesoft.dao.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserService {
	public static String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
    }
    
    public static boolean isLoggedIn(){
    	String fName = findLoggedInUsername();
    	return (fName != null);
    }
}
