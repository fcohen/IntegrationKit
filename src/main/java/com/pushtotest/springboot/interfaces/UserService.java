package com.pushtotest.springboot.interfaces;

import com.pushtotest.springboot.model.Login;

public interface UserService {
	public void save(Login user);
	public Login findByUserId(String username);
	public Login findByUserIdAndPassword(String userId, String password);
	public void updateBalance(String userId, int balance);
}
