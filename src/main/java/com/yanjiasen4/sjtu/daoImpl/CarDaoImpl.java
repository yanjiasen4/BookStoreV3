package com.yanjiasen4.sjtu.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.yanjiasen4.sjtu.beans.Book;
import com.yanjiasen4.sjtu.beans.Car;
import com.yanjiasen4.sjtu.dao.CarDao;

public class CarDaoImpl implements CarDao {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	// 向购物车添加一本书
	@SuppressWarnings("unchecked")
	public void addbook(String bookname, String username) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String hql1 = "from Car as car where car.bookname = '" + bookname + "'";
		Query query1 = session.createQuery(hql1);
		List<Car> list=(List<Car>)query1.list();
		if(!list.isEmpty()) {
			Car caritem = list.get(0);
			caritem.setBooknum(caritem.getBooknum()+1);
			session.update(caritem);
		}
		else {
			String hql2 = "from Book where bookname = '" + bookname + "'";
			Query query2 = session.createQuery(hql2);
			List<Book> book=(List<Book>)query2.list();
			Book bk = book.get(0);
			Car newcaritem = new Car(username,bookname,1,bk.getPic(),bk.getPrice());
			session.save(newcaritem);
		}
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Car> getCars(String username) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String hql = "from Car where username = '" + username + "'";
		Query query = session.createQuery(hql);
		List<Car> list=(List<Car>)query.list();
		session.getTransaction().commit();
		session.close();
		if(!list.isEmpty()) {
			return list;
		}
		else {
			return null;
		}
	}
	
	// 清空购物车
	public void clearCart(String username) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String hql = "delete Car as c where c.username = '" + username + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	
}
