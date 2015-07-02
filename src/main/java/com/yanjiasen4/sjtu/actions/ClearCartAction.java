package com.yanjiasen4.sjtu.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.service.CarManager;

/*  �û��ڹ��ﳵ�������չ��ﳵ����
 *  carManager - CarManager
 *  @��Ҫ��½
 */
public class ClearCartAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CarManager carManager;

	public CarManager getCarManager() {
		return carManager;
	}
	public void setCarManager(CarManager carManager) {
		this.carManager = carManager;
	}
	
	public String execute() {
		ActionContext actionContext = ActionContext.getContext();
        Map<String,Object> session = actionContext.getSession();
        String username = (String) session.get("username");
		carManager.clearCart(username);
		return SUCCESS;
	}
	
}
