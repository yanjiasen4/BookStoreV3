package com.yanjiasen4.sjtu.serviceImpl;

import java.util.List;

import com.yanjiasen4.sjtu.beans.Order;
import com.yanjiasen4.sjtu.dao.OrderDao;
import com.yanjiasen4.sjtu.service.OrderManager;

public class OrderManagerImpl implements OrderManager {
	
	private OrderDao orderDao;
	
	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void generateOrder(String username) {
		orderDao.generateOrder(username);
	}

	public List<Order> getOrders(String username) {
		return orderDao.getOrders(username);
	}
	public String[][] getAllStat() {
		return orderDao.getAllStat();
	}
	public double[] getSingleStat(String username) {
		return orderDao.getSingleStat(username);
	}
}
