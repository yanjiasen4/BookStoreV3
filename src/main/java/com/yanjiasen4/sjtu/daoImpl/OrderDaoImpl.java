package com.yanjiasen4.sjtu.daoImpl;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yanjiasen4.sjtu.beans.Car;
import com.yanjiasen4.sjtu.beans.Order;
import com.yanjiasen4.sjtu.dao.OrderDao;

public class OrderDaoImpl implements OrderDao {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	//�����ݹ��ﳵ��Ϣ�����ƶ��û��Ķ���
	public void generateOrder(String username) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String hql = "from Car where username = '" + username + "'";
		Query query = session.createQuery(hql);
		List<Car> list=(List<Car>)query.list();
		if(!list.isEmpty()) {
			for(Car tmp:list) {
				Order orderItem = new Order();
				orderItem.setBookname(tmp.getBookname());
				orderItem.setBooknum(tmp.getBooknum());
				orderItem.setBookprice(tmp.getBookprice());
				orderItem.setUsername(username);
				System.out.println(orderItem);
				session.save(orderItem);
			}
		}
		ts.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	//�������ƶ��û����ж�����Ϣ
	public List<Order> getOrders(String username) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String hql = "from Order where username = '" + username + "'";
		Query query = session.createQuery(hql);
		List<Order> list=(List<Order>)query.list();
		for(Order od:list) {
			System.out.println(od.getTimestamp());
		}
	
		ts.commit();
		session.close();
		if(!list.isEmpty()) {
			return list;
		}
		else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public String[][] getAllStat() {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String hql = "select username,sum(bookprice*booknum) from Order group by username order by sum(bookprice*booknum)";
		Query query = session.createQuery(hql).setMaxResults(10);
		// ��ѯ�û������������ǰ10
		List<Object[]> list=(List<Object[]>)query.list();
		ts.commit();
		session.close();
		
		// �������String�Ķ�ά�����У�����ת��Ϊjson��ʽ
		int size = list.size();
		String[][] result = new String[size][2];
		int i = 0;
		for(Object[] tmp:list) {
			result[i][0] = (String) tmp[0];
			result[i][1] = Double.toString((Double) tmp[1]);
			i++;
		}
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public double[] getSingleStat(String username) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String hql = "select sum(bookprice*booknum),timestamp from Order where username='"+username+"' group by timestamp order by timestamp";
		Query query = session.createQuery(hql);
		// �����·ݲ�ѯ�ƶ��û���������������¼����¶������ܶ������·�����
		List<Object[]> list=(List<Object[]>)query.list();
		ts.commit();
		session.close();
		
		int start = 0;
		int end = 0;
		Timestamp timestart = (Timestamp)(list.get(0))[1];
		Timestamp timeend = (Timestamp)(list.get(list.size()-1))[1];
		start = timestart.getMonth(); // ���ؽ����һ����Ŀ���·�
		end = timeend.getMonth(); // ���ؽ�����һ����Ŀ���·�
		
		int curr = start;
		int i = 0;
		double[] result = new double[end-start+1];
		double monthlyCost = 0;
		DecimalFormat df = new DecimalFormat("#.00"); // �������ݸ������洢ʱ����ǿ�Ʊ�����λ����
		System.out.println(start);
		for(Object[] tmp:list) {
			Timestamp timestamp = (Timestamp) tmp[1];
			Date date = new Date(timestamp.getTime());
			if(curr != date.getMonth()) {
				df.format(monthlyCost);
				result[i] = monthlyCost;
				monthlyCost = (Double) tmp[0];
				curr++;
				i++;
			}
			else {
				monthlyCost += (Double) tmp[0];
			}
		}
		df.format(monthlyCost);
		result[i] = monthlyCost; // last month
		return result;
	}
}
