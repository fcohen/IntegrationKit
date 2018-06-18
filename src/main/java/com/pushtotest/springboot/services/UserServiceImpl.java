package com.pushtotest.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pushtotest.springboot.interfaces.UserService;
import com.pushtotest.springboot.model.Login;
import com.pushtotest.springboot.repository.LoginRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private LoginRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Login user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public Login findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
    
    @Override
    public Login findByUserIdAndPassword(String userId, String password){
    	return userRepository.findByUserIdAndPassword(userId, password);
    }

	@Override
	public void updateBalance(String userId, int balance) {
		Login user = userRepository.findByUserId(userId);
        user.setBalance(balance);
        userRepository.save(user);
	}
}
