package com.yanjiasen4.sjtu.service;

import com.yanjiasen4.sjtu.forms.LoginForm;
import com.yanjiasen4.sjtu.forms.UserForm;

public interface UserManager {

	public int regUser(UserForm user);
    public int login(LoginForm user);
	public void changePsd(String username, String npassword);
}

