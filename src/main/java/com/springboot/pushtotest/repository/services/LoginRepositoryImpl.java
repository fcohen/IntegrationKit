package com.springboot.pushtotest.repository.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.pushtotest.springboot.model.Login;
import com.pushtotest.springboot.repository.LoginRepository;
import com.pushtotest.springboot.repository.interfaces.LoginRepositoryCustom;

@Repository
public class LoginRepositoryImpl implements LoginRepositoryCustom {

	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
    MongoTemplate mongoTemplate;
	
	
	@Override
	public void registerUser(String userId, String password, String lastName,
			String firstName) {
		//Login newUser = new Login(userId, password, lastName, firstName);
		//mongoTemplate.save(newUser);
	}


	@Override
	public int findByEmail(String userId) {
		Login user = loginRepository.findByUserId(userId);
        if (user != null) {
            return 1;
        }
        return 0;
	}
}
