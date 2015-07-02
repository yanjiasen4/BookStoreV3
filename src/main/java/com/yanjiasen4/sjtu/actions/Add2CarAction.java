package com.yanjiasen4.sjtu.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.service.CarManager;

/*( 用户在Index页面向购物车添加书时调用此Action
*   @需要登陆
*   carManager接口使用CarManagerImpl实现
*/
public class Add2CarAction extends ActionSupport {

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
		HttpServletRequest req =  ServletActionContext.getRequest();
		String bookname = req.getParameter("bookname");
		Map<String,Object> session = ActionContext.getContext().getSession();
		String username = (String)session.get((Object)"username");
		carManager.addbook(bookname,username);
		return SUCCESS;
	}
}
