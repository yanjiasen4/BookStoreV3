package com.yanjiasen4.sjtu.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.yanjiasen4.sjtu.beans.Book;
import com.yanjiasen4.sjtu.service.BookManager;

/*  查询图书Acton
 *  用户在主页Index中的搜索框输入信息，放入input中，然后根据输入和书名匹配查询
 *  查询结果放入books中
 *  bookManager - BookManager
 *  @需要登陆
 */
public class SearchBookAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5725363443549843718L;
	
	private BookManager bookManager;
	private String input;
	private List<Book> books;

	public BookManager getBookManager() {
		return bookManager;
	}

	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
	public String execute() {
		System.out.println(input);
		setBooks(bookManager.searchBook(input));
		return SUCCESS;
	}

}
