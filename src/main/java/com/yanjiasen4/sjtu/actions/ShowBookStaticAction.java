package com.yanjiasen4.sjtu.actions;

import java.io.IOException;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.service.BookManager;
import net.sf.json.JSONArray;

/*　 给统计页面发送书籍统计信息的Action
 *  结果放入data中
 *  使用json格式和ajax协议向前端传输数据
 *  bookManager - BookManager
 */
public class ShowBookStaticAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BookManager bookManager;
	private String  data;
	
	@JSON(serialize=false)
	public BookManager getBookManager() {
		return bookManager;
	}
	@JSON(serialize=false)
	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String execute() throws IOException {
		 String[][] chatroom;  
	     chatroom = bookManager.getStat();
	     JSONArray jo = JSONArray.fromObject(chatroom);  
	     this.data = jo.toString();
	     System.out.println(data);
	     return SUCCESS;  
	}

}
