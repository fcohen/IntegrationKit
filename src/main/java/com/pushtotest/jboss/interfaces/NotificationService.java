package com.pushtotest.jboss.interfaces;

import java.util.List;

import com.pushtotest.jboss.model.Notifications;

public interface NotificationService {
	public void save(Notifications notifications);
	public Notifications findById(String id);
	public List<Notifications> findByUserIdAndStatus(String userId, String status);
}
