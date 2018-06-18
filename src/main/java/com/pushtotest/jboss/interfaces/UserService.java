package com.pushtotest.jboss.interfaces;

import com.pushtotest.jboss.model.Login;

public interface UserService {
	public void save(Login user);
	public Login findByUserId(String username);
	public void updateBalance(String userId, int balance);
	public Login findByUserNameAndPassword(String userId, String password);
}
