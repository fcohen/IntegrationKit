package com.pushtotest.springboot.repository.interfaces;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pushtotest.springboot.model.Notifications;

// No need implementation, just one interface, and you have CRUD, thanks Spring Data
public interface NotificationRepository extends MongoRepository<Notifications, Long> {
	Notifications findById(String id);
	List<Notifications> findByUserIdAndStatus(String userId, String status);
}