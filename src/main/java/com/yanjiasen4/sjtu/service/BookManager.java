package com.yanjiasen4.sjtu.service;

import java.util.List;

import com.yanjiasen4.sjtu.beans.Book;
import com.yanjiasen4.sjtu.forms.BookForm;

public interface BookManager {
	
	public List<Book> getBooks();

	public void insertBook(BookForm bookForm);

	public void deleteBook(String str);

	public void modifyBook(BookForm bookForm);

	public String[][] getStat();

	public List<Book> searchBook(String input);

}
