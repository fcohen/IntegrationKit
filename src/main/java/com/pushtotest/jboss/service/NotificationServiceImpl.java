package com.pushtotest.jboss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pushtotest.jboss.dao.NotificationDao;
import com.pushtotest.jboss.interfaces.*;
import com.pushtotest.jboss.model.Notifications;

@Component
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationDao notificationDao;
	
	@Override
	public void save(Notifications notifications) {
		notificationDao.persist(notifications);
		
	}

	@Override
	public Notifications findById(String id) {
		return notificationDao.findById(id);
	}

	@Override
	public List<Notifications> findByUserIdAndStatus(String userId, String status) {
		return notificationDao.findByUserIdAndStatus(userId, status);
	}
	
}
