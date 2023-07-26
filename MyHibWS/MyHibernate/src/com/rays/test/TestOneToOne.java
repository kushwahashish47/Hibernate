package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.oneone.Address;
import com.rays.oneone.Employee;

public class TestOneToOne {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Address address = new Address();
		address.setId(1);
		address.setCity("Indore");
		address.setState("M.P");

		Employee employee = new Employee();
		employee.setId(1);
		employee.setFirstname("Ashwin");
		employee.setLastName("Jain");
		employee.setEmpAddress(address);

		session.save(employee);
		tx.commit();
		session.close();

	}
}
