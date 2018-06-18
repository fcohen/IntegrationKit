package com.pushtotest.jboss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pushtotest.jboss.dao.LoginDao;
import com.pushtotest.jboss.interfaces.UserService;
import com.pushtotest.jboss.model.Login;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public void save(Login user) {
		loginDao.persist(user);
	}

	@Override
	public Login findByUserId(String username) {
		return loginDao.findByUserId(username);
	}

	@Override
	public void updateBalance(String userId, int balance) {
		loginDao.updateBalance(userId, balance);		
	}
	
	@Override
	public Login findByUserNameAndPassword(String userId, String password) {
		return loginDao.findByUserNameAndPassword(userId, password);
	}

}
