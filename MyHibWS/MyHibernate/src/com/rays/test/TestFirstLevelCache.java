package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.rays.dto.UserDTO;
import com.rays.util.HibDataSource;

public class TestFirstLevelCache {
	public static void main(String[] args) {
		
	
	Session session = null;
	session = HibDataSource.getSession();
	UserDTO dto=(UserDTO) session.get(UserDTO.class, 1);
	
	System.out.print(dto.getId()+"\t");
	System.out.print(dto.getFirstName()+"\t");
	System.out.println(dto.getLastName());
	System.out.println(dto.getLoginId());
	System.out.println(dto.getPassword());
	
	
//	session.evict(dto);	
//	if we did not use evict then we get data from 1st level cache--it shows that query runs 
//	only ones and and  we get data from first level cache.
	
	UserDTO dto1=(UserDTO) session.get(UserDTO.class, 1);
	
	System.out.print(dto1.getId()+"\t");
	System.out.print(dto1.getFirstName()+"\t");
	System.out.println(dto1.getLastName());
	System.out.println(dto1.getLoginId());
	System.out.println(dto1.getPassword());
	
	
	session.close();

	

	}

}
