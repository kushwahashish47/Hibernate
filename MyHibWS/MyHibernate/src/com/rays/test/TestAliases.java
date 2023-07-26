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

public class TestAliases {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Query q = session.createQuery("select u.id ,u.firstName from UserDTO u");
		List list = q.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {											//this is the way to get all values.
			Object[] o = (Object[]) it.next();
			
			System.out.println(o[0]);
			System.out.println(o[1]);
			
			
		}
		session.close();

	}

}
