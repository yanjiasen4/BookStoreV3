package com.yanjiasen4.sjtu.actions;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.forms.BookForm;
import com.yanjiasen4.sjtu.service.BookManager;

/*  管理书的Action
 *  显示主页的所有书籍
 *  管理员在管理页面对书进行增删改查
 *  bookManager - BookManager
 *  @需要登陆
 */
public class BookManagerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BookManager bookManager;
	
	private BookForm book;
	
	public BookManager getBookManager() {
		return bookManager;
	}

	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}

	public BookForm getBook() {
		return book;
	}

	public void setBook(BookForm book) {
		this.book = book;
	}

	public String insertBook() {
		bookManager.insertBook(book);
		return SUCCESS;
	}
	
	public String deleteBook() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] books = request.getParameterValues("choice");
		for(String str:books) {
			bookManager.deleteBook(str);
		}
		return SUCCESS;
	}
	
	public String modifyBook() {
		bookManager.modifyBook(book);
		return SUCCESS;
	}
	

}
