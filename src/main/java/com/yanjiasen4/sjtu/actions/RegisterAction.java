package com.yanjiasen4.sjtu.actions;

import com.opensymphony.xwork2.ActionSupport;

import com.yanjiasen4.sjtu.forms.UserForm;
import com.yanjiasen4.sjtu.service.UserManager;

/*  注册Action
 *  用户输入信息放入user中
 *  userManager - UserManager
 */
public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private UserForm user;
	private UserManager userManager;
	
	public UserForm getUser() {
		return user;
	}
	public void setUser(UserForm user) {
		this.user = user;
	}
	public UserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public String execute() {
		try {
			if(userManager.regUser(user)==1) {
				return ERROR;
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
