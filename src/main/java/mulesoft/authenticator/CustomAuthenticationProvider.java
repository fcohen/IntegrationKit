package mulesoft.authenticator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	//@Autowired
    //private AuthenticationManager authenticationManager;
	
	@Override
	public Authentication authenticate(Authentication authValue) throws AuthenticationException {
		String name = authValue.getName().trim();
		String secratePass = authValue.getCredentials().toString().trim();
		System.out.println("Name:" + name);
		System.out.println("Password:" + secratePass);
		if (name.equals("venky@zeptoh.com") && secratePass.equals("l3tv3nkyin")) {
			List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("USER"));
			Authentication auth = new UsernamePasswordAuthenticationToken(name, secratePass, grantedAuths);
			//authenticationManager.authenticate(auth);
			
			/*if (auth.isAuthenticated()) {
	            SecurityContextHolder.getContext().setAuthentication(auth);
	        }*/
			
			return auth;
		} else {
			throw new BadCredentialsException("Bad Credentials entered");
			// Custom Message;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
