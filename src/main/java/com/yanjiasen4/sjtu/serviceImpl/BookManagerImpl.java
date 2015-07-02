package com.yanjiasen4.sjtu.serviceImpl;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.yanjiasen4.sjtu.beans.Book;
import com.yanjiasen4.sjtu.dao.BookDao;
import com.yanjiasen4.sjtu.forms.BookForm;
import com.yanjiasen4.sjtu.service.BookManager;

public class BookManagerImpl implements BookManager {
	
	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return bookDao.getBooks();
	}

	public void insertBook(BookForm bookForm) {
		Book book = new Book();
		BeanUtils.copyProperties(bookForm, book);
		book.setPic("img/16.jpg");
		bookDao.insertBook(book);	
	}
	
	public void deleteBook(String bookname) {
		bookDao.deleteBook(bookname);	
	}

	public void modifyBook(BookForm bookForm) {
		Book book = new Book();
		BeanUtils.copyProperties(bookForm, book);
		bookDao.modifyBook(book);	
	}
	
	public String[][] getStat() {
		return bookDao.getStat();
	}
	
	public List<Book> searchBook(String input) {
		return bookDao.searchBook(input);
	}
}
