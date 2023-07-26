package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestAggregateFunctions {
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Query q = session.createQuery("select count(*) from UserDTO");
		Query q1 = session.createSQLQuery("select max(id) from UserDTO");
//		Query q1 = session.createSQLQuery("select count(*) from UserDTO");
		List list = q.list();
		List list1 = q1.list();
		
	System.out.println( list.get(0));
	System.out.println( list1.get(0));
	
	session.close();
	}}
