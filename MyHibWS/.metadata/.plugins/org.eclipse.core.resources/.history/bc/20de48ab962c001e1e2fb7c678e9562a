package com.rays.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDTO;
import com.rays.oneone.Address;
import com.rays.oneone.Employee;

public class TestUpdateException {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		UserDTO emp = (UserDTO) session.get(UserDTO.class, 7);
//		session.evict(emp);
		UserDTO emp1 = new UserDTO();
		
		emp1.setId(7);
		emp1.setFirstName("A");

		session.update(emp1);
		//session.merge(emp1);
		tx.commit();
		session.close();
//		we get existing id and set that with some others parameter and then we call update method and then it will throw non unique object exception.
		
//use evict then update when we get and want to update using  upadte  (else--- non unique object exception)  0r use merge directly
		
	}
}
