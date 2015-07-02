package com.yanjiasen4.sjtu.dao;

import com.yanjiasen4.sjtu.beans.User;

public interface UserDao {

	public int saveUser(User user);
	
	public int checkUser(String username, String password);

	public void changePwd(String username, String npassowrd);
}
