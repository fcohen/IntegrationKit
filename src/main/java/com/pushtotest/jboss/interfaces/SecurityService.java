package com.pushtotest.jboss.interfaces;

public interface SecurityService {
	public String findLoggedInUsername();
	public void autologin(String username, String password);
}
