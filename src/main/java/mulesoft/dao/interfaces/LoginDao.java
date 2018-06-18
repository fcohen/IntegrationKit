package mulesoft.dao.interfaces;

import mulesoft.model.Login;

public interface LoginDao {
	public void save(Login user);
	public Login findByUserId(String username);
	public void updateBalance(String userId, int balance);
	public Login findByUserNameAndPassword(String userId, String password);
}
