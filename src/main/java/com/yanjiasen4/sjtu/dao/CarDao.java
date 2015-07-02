package com.yanjiasen4.sjtu.dao;

import java.util.List;

import com.yanjiasen4.sjtu.beans.Car;

public interface CarDao {
	
	public void addbook(String bookname, String username);

	public List<Car> getCars(String username);

	public void clearCart(String username);

}
