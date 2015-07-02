package com.yanjiasen4.sjtu.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.forms.LoginForm;
import com.yanjiasen4.sjtu.service.UserManager;

/*  登陆Action
 *  用户输入存入login中，登陆后在session中添加username值和admin的值
 *  admin: 1 - 管理员权限
 *         0 - 普通用户权限
 *  userManager - UserManager
 */
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private LoginForm login;
	private UserManager userManager;
	
	public LoginForm getLogin() {
		return login;
	}
	public void setLogin(LoginForm login) {
		this.login = login;
	}

	public UserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	public String execute() {
		int ret = userManager.login(login);
		if(ret == 0 || ret == -1)
			return ERROR;
		else {
			ActionContext actionContext = ActionContext.getContext();
	        Map<String,Object> session = actionContext.getSession();
	        session.put("username",login.getUsername());
	        session.put("admin", ret);
			return SUCCESS;
		}
	}

}
