package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDTO;
import com.rays.part.Part;

public class TestQuery {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

//		Query q = session.createQuery("from UserDTO");
//		List list = q.list();
//		Iterator it=list.iterator();
//		while(it.hasNext()) {
//			UserDTO dto = (UserDTO) it.next();
//
//			System.out.println(dto.getId());
//			System.out.print(dto.getFirstName());
//			System.out.print(dto.getLastName());
//			System.out.print(dto.getLoginId());
//			System.out.print(dto.getPassword());
//
//		}

		Query q = session.createQuery("from UserDTO where lastName like 'jain%'");
		List list = q.list();
		Iterator it = list.iterator();

		while (it.hasNext()) {
			UserDTO dto = (UserDTO) it.next();

			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());

		}
//		 Query q1=session.createSQLQuery("select * from UserDTO");
//	 
//			  List list = q1.list();
//			  Iterator it = list.iterator();
//			  
//			  while (it.hasNext()) { Object[] o = (Object[]) it.next();
//			  for (Object object : o) {
//				  System.out.println(object);
//			}
//			 	 
//		}
		session.close();

	}
}
