package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.rays.dto.UserDTO;
import com.rays.util.HibDataSource;

public class TestCache {
	public static void main(String[] args) {
		Session session = null;
		session = HibDataSource.getSession();
		Query q = session.createQuery("from UserDTO where id = 2");
		q.setCacheable(true);                                 //it will prevent query to run again and again
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

		Query q1 = session.createQuery("from UserDTO where id =2");
		q1.setCacheable(true);									//it will prevent query to run again and again
		List list2 = q1.list();
		Iterator it1 = list2.iterator();

		while (it1.hasNext()) {
			UserDTO dto1 = (UserDTO) it1.next();

			System.out.println(dto1.getId());
			System.out.println(dto1.getFirstName());
			System.out.println(dto1.getLastName());
			System.out.println(dto1.getLoginId());
			System.out.println(dto1.getPassword());
		}
		session.close();

	}

}
