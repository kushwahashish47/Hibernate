package com.rays.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.oneone.Address;
import com.rays.oneone.Employee;

public class TestEvict {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Employee emp = (Employee) session.get(Employee.class, 10);
//		session.evict(emp);
		Employee emp1 = new Employee();
		
		emp1.setId(10);
		emp1.setFirstname("A");

//		session.update(emp1);
		session.merge(emp1);
		tx.commit();
		session.close();
//use evict then update when we get and want to update using  upadte  (else--- non unique object exception)  0r use merge directly
		
	}
}