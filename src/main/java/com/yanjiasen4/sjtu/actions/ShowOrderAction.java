package com.yanjiasen4.sjtu.actions;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.beans.Order;
import com.yanjiasen4.sjtu.service.OrderManager;

/*  展示用户订单的所有内用
 *  orderManager - OrderManager
 *  @需要登陆
 */
public class ShowOrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Order> orders;
	private OrderManager orderManager;
	
	public OrderManager getOrderManager() {
		return orderManager;
	}
	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public String execute() {
		ActionContext actionContext = ActionContext.getContext();
        Map<String,Object> session = actionContext.getSession();
        String username = (String) session.get("username");
        if(username == null) {
        	System.out.println(username);
        	return ERROR;
        }
		setOrders(orderManager.getOrders(username));
		System.out.println(orders);
		return SUCCESS;
	}
}
