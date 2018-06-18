package com.pushtotest.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pushtotest.springboot.model.Login;
import com.pushtotest.springboot.repository.interfaces.LoginRepositoryCustom;

// No need implementation, just one interface, and you have CRUD, thanks Spring Data
public interface LoginRepository extends MongoRepository<Login, Long>/*, LoginRepositoryCustom*/ {
    Login findByUserIdAndPassword(String userId, String password);
    Login findByUserId(String userId);
}