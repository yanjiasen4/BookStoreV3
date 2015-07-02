package com.yanjiasen4.sjtu.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.service.CarManager;
import com.yanjiasen4.sjtu.service.OrderManager;

/*  用户在购物车点击Buy按钮调用此Action
 *  carManager - CarManagerImpl
 *  orderManager - OrderManagerImpl
 *  通过orderManager生成用户购买的订单，然后通过carManager清空用户购物车
 *  @需要登陆
 */
public class BuyAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CarManager carManager;
	private OrderManager orderManager;
	
	public CarManager getCarManager() {
		return carManager;
	}
	public void setCarManager(CarManager carManager) {
		this.carManager = carManager;
	}
	public OrderManager getOrderManager() {
		return orderManager;
	}
	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	
	public String execute() {
		ActionContext actionContext = ActionContext.getContext();
        Map<String,Object> session = actionContext.getSession();
        String username = (String) session.get("username");
		orderManager.generateOrder(username);
		carManager.clearCart(username);
		return SUCCESS;
	}
	
}
