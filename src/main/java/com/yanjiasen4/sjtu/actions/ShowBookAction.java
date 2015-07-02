package com.yanjiasen4.sjtu.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.beans.Book;
import com.yanjiasen4.sjtu.service.BookManager;

/*  展示所有书Action
 *  bookManager - BookManager
 *  @需要登陆
 */
public class ShowBookAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<Book> books;
	private BookManager bookManager;
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public BookManager getBookManager() {
		return bookManager;
	}

	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}
	
	public String execute() {
		setBooks(bookManager.getBooks());
		return SUCCESS;
	}
	
	public String executed() {
		setBooks(bookManager.getBooks());
		return SUCCESS;
	}
	
	public String executem() {
		setBooks(bookManager.getBooks());
		return SUCCESS;
	}
}
