package com.yanjiasen4.sjtu.daoImpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yanjiasen4.sjtu.beans.Book;
import com.yanjiasen4.sjtu.dao.BookDao;

public class BookDaoImpl implements BookDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooks() {		
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		try {
			String hql = "from Book";
			Query query = session.createQuery(hql);
			List<Book> list=(List<Book>)query.list();
			ts.commit();
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
			if(ts != null) {
				ts.rollback();
			}
		}		 
		finally {
			session.close();
		} 
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public void insertBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String hql = "from Book where BookName = '" + book.getBookName() + "'";
		Query query = session.createQuery(hql);
		List<Book> list=(List<Book>)query.list();
		if(list.isEmpty()) {
			session.save(book);
		} // if this book has already been created, do nothing
		ts.commit();
		session.close();
	}
	
	public void deleteBook(String bookname) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String hql = "delete from Book where BookName = '" +  bookname + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		ts.commit();	
		session.close();
	}

	public void modifyBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.update(book);
		ts.commit();		
		session.close();
	}
	
	public String[][] getStat() {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String hql = "select Type,count(Type) from Book group by Type";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Object[]> list=(List<Object[]>)query.list();
		int size = list.size();
		String[][] result = new String[size][2];
		int i = 0;
		// 结果放入二维数组中，方便json格式转化
		for(Object[] obj:list) {
			result[i][0] = (String) obj[0];
			result[i][1] = Long.toString((Long) obj[1]);
			i++;
		}
		ts.commit();
		session.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> searchBook(String input) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String hql = "from Book where bookname like '" + input + "'";
		Query query = session.createQuery(hql);
		List<Book> list=(List<Book>)query.list();
		ts.commit();
		session.close();
		return list;
	}
}
