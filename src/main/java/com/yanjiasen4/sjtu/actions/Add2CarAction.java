package com.yanjiasen4.sjtu.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.service.CarManager;

/*( �û���Indexҳ�����ﳵ�����ʱ���ô�Action
*   @��Ҫ��½
*   carManager�ӿ�ʹ��CarManagerImplʵ��
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
