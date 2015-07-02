package com.yanjiasen4.sjtu.actions;

import java.util.Map;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.service.OrderManager;

/*  ��ͳ��ҳ�淢�͵�ǰ��½�û�ͳ����Ϣ��Action
 *  �������data��
 *  ʹ��json��ʽ��ajaxЭ����ǰ�˴�������
 *  orderManager - OrderManager
 *  @��Ҫ��½
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
