package com.yanjiasen4.sjtu.beans;

public class Car {
	
	private int caritemid; // 数据库自动生成 - 自增长
	private String username;
	private String bookname;
	private int booknum;
	private String bookpic;
	private float bookprice;
	
	public Car() {
	}
	public Car(String username, String bookname, int booknum, String bookpic, float bookprice) {
		this.username = username;
		this.bookname = bookname;
		this.booknum = booknum;
		this.bookpic = bookpic;
		this.bookprice = bookprice;	
	}
	public int getCaritemid() {
		return caritemid;
	}
	public void setCaritemid(int caritemid) {
		this.caritemid = caritemid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getBooknum() {
		return booknum;
	}
	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}
	public String getBookpic() {
		return bookpic;
	}
	public void setBookpic(String bookpic) {
		this.bookpic = bookpic;
	}
	public float getBookprice() {
		return bookprice;
	}
	public void setBookprice(float bookprice) {
		this.bookprice = bookprice;
	}

}
