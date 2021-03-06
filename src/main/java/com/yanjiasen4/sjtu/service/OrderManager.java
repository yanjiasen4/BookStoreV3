package com.yanjiasen4.sjtu.service;

import java.util.List;

import com.yanjiasen4.sjtu.beans.Order;

public interface OrderManager {

	public void generateOrder(String username);

	public List<Order> getOrders(String username);	

	public String[][] getAllStat();

	public double[] getSingleStat(String username);
}
