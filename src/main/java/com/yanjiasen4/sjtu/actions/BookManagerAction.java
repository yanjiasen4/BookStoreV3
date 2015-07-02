package com.yanjiasen4.sjtu.actions;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.forms.BookForm;
import com.yanjiasen4.sjtu.service.BookManager;

/*  �������Action
 *  ��ʾ��ҳ�������鼮
 *  ����Ա�ڹ���ҳ����������ɾ�Ĳ�
 *  bookManager - BookManager
 *  @��Ҫ��½
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
