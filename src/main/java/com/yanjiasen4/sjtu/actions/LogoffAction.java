package com.yanjiasen4.sjtu.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*  登出Action
 *  移除session中username和admin属性
 *  @需要登陆
 */
public class LogoffAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	public String execute() {
		try {
			ActionContext actionContext = ActionContext.getContext();
	        Map<String,Object> session = actionContext.getSession();
	        session.remove("username");
	        session.remove("admin");	     
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
