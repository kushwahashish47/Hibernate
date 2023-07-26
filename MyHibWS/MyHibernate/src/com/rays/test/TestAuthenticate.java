package com.rays.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestAuthenticate {
//(used to get single row)
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session =sf.openSession();
		System.out.println("strated.....................");
		Query q =session.createQuery("from UserDTO where loginId=? AND password=?");
		q.setString(0, "ashish@gmail.com");
		q.setString(1, "Ashish@123");
		
		System.out.println("create query..............");
		List list =q.list();
		
		System.out.println(list);
		
		if(list.size()>0) {
//			Object o =list.get(0);
//			UserDTO dto = (UserDTO)o;
//		OR
		UserDTO dto = (UserDTO)list.get(0);
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLoginId());
		System.out.println(dto.getPassword());
		}else {
			System.out.println("inavalid login id or password");
		}
		session.close();
		}	
	}
	
