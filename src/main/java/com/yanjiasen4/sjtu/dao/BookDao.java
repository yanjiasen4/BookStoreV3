package com.yanjiasen4.sjtu.dao;

import java.util.List;

import com.yanjiasen4.sjtu.beans.Book;

public interface BookDao {
	
	public List<Book> getBooks();

	public void insertBook(Book book);

	public void deleteBook(String bookname);

	public void modifyBook(Book book);

	public String[][] getStat();
	
	public List<Book> searchBook(String input);
}
