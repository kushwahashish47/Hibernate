package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestCRUD {

	public static void main(String[] args) {

		UserDTO dto = new UserDTO();

		dto.setId(8);
//		dto.setFirstName("b");
//		dto.setLastName("msn");
//		dto.setLoginId("am@gll.com");
//		dto.setPassword("Am34");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

//		session.save(dto);
		session.update(dto);
//		session.delete(dto);
//		session.saveOrUpdate(dto);
		
		tx.commit();

		session.close();
	}
}
