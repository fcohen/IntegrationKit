package com.pushtotest.springboot.repository.interfaces;

public interface LoginRepositoryCustom {
	public void registerUser(String userId, String password, String lastName, String FirstName);
	public int findByEmail(String userId);
}
