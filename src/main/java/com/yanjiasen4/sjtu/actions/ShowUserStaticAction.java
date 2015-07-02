package com.yanjiasen4.sjtu.actions;

import java.io.IOException;
import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.service.OrderManager;

import net.sf.json.JSONArray;

/*  ��ͳ��ҳ�淢�������û�ͳ����Ϣ��Action
 *  �������data��
 *  ʹ��json��ʽ��ajaxЭ����ǰ�˴�������
 *  orderManager - OrderManager
 *  @��Ҫ��½
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