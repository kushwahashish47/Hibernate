package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestGet {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
//		Object o =session.get(UserDTO.class, 2);
//		UserDTO dto = (UserDTO)o;	
//		or
		UserDTO dto= (UserDTO)session.get(UserDTO.class,2);
		
		System.out.print(dto.getId()+"\t");
		System.out.print(dto.getFirstName()+"\t");
		System.out.println(dto.getLastName());
		System.out.println(dto.getLoginId());
		System.out.println(dto.getPassword());
		session.close();
	}
}
