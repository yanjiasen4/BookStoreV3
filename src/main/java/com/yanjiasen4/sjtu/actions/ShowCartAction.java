package com.yanjiasen4.sjtu.actions;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.beans.Car;
import com.yanjiasen4.sjtu.service.CarManager;

/*  展示用户购物车中的所有商品
 *  carManager - CarManager
 *  @需要登陆
 */
public class ShowCartAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CarManager carManager;
	private List<Car> carts;

	public CarManager getCarManager() {
		return carManager;
	}
	public List<Car> getCarts() {
		return carts;
	}

	public void setCarts(List<Car> carts) {
		this.carts = carts;
	}

	public void setCarManager(CarManager carManager) {
		this.carManager = carManager;
	}
	
	public String execute() {
		ActionContext actionContext = ActionContext.getContext();
        Map<String,Object> session = actionContext.getSession();
        String username = (String) session.get("username");
		setCarts(carManager.getCars(username));
		System.out.println(this.getCarts());
		if(carts == null || carts.isEmpty()) {
			return ERROR;
		}
		else {
			float total_price = 0;
			for(Car tmp:carts) {
				total_price += tmp.getBookprice() * tmp.getBooknum();
			}
	        session.put("total_price", total_price);
			return SUCCESS;
		}
	}	

}
