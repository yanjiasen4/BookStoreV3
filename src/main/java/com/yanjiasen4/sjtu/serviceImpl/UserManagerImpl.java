package com.yanjiasen4.sjtu.serviceImpl;

import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;

import com.yanjiasen4.sjtu.forms.LoginForm;
import com.yanjiasen4.sjtu.forms.UserForm;
import com.yanjiasen4.sjtu.beans.User;
import com.yanjiasen4.sjtu.dao.UserDao;
import com.yanjiasen4.sjtu.service.UserManager;

public class UserManagerImpl implements UserManager {
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public int regUser(UserForm userForm) throws HibernateException {
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		user.setAdmin(0);
		return userDao.saveUser(user);		
	}

	public int login(LoginForm loginForm) {
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		int ret = userDao.checkUser(username,password);
		return ret;
	}
		
	public void changePsd(String username, String npassword) {
		userDao.changePwd(username, npassword);
	}
}
