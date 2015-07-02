package com.yanjiasen4.sjtu.actions;

import java.io.IOException;
import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.service.OrderManager;

import net.sf.json.JSONArray;

/*  给统计页面发送所有用户统计信息的Action
 *  结果放入data中
 *  使用json格式和ajax协议向前端传输数据
 *  orderManager - OrderManager
 *  @需要登陆
 */
public class ShowUserStaticAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private OrderManager orderManager;

	private String  data;
	
	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String execute() throws IOException {
		 String[][] result;  
	     result = orderManager.getAllStat();
	     JSONArray jo = JSONArray.fromObject(result);  
	     this.data = jo.toString();
	     return SUCCESS;  
	}
	
}