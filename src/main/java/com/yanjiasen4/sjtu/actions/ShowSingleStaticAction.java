package com.yanjiasen4.sjtu.actions;

import java.util.Map;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.service.OrderManager;

/*  给统计页面发送当前登陆用户统计信息的Action
 *  结果放入data中
 *  使用json格式和ajax协议向前端传输数据
 *  orderManager - OrderManager
 *  @需要登陆
 */
public class ShowSingleStaticAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String data;
	private OrderManager orderManager;
	
	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String execute() {
		ActionContext actionContext = ActionContext.getContext();
        Map<String,Object> session = actionContext.getSession();
        String username = (String) session.get("username");
        double[] result = orderManager.getSingleStat(username);
        JSONArray jo = JSONArray.fromObject(result);  
	    this.data = jo.toString();
	    System.out.println(data);
		return SUCCESS;
	}

}
