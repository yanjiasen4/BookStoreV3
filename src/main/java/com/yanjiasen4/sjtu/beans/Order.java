package com.yanjiasen4.sjtu.beans;

import java.sql.Timestamp;

public class Order {
	
	private int orderid; // ���ݿ��Զ����� - ������
	private String username;
	private String bookname;
	private float bookprice;
	private int booknum;
	private Timestamp timestamp; //��ʹ�����ݿ�Ĭ��ֵ�� - currenttimestamp
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
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
	public float getBookprice() {
		return bookprice;
	}
	public void setBookprice(float bookprice) {
		this.bookprice = bookprice;
	}
	public int getBooknum() {
		return booknum;
	}
	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
