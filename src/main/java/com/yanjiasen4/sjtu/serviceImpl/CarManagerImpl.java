package com.yanjiasen4.sjtu.serviceImpl;

import java.util.List;

import com.yanjiasen4.sjtu.beans.Car;
import com.yanjiasen4.sjtu.dao.CarDao;
import com.yanjiasen4.sjtu.service.CarManager;

public class CarManagerImpl implements CarManager {
	
	private CarDao carDao;

	public CarDao getCarDao() {
		return carDao;
	}

	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	public void addbook(String bookname, String username) {
		carDao.addbook(bookname, username);
	}
	
	public List<Car> getCars(String username) {
		return carDao.getCars(username);
	}
	
	public void clearCart(String username) {
		carDao.clearCart(username);
	}
	
}
