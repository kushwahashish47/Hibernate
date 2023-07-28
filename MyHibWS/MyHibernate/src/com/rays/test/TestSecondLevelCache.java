package com.rays.test;

import org.hibernate.Session;

import com.rays.dto.UserDTO;
import com.rays.util.HibDataSource;

public class TestSecondLevelCache {
	public static void main(String[] args) {

		Session session = null;
		session = HibDataSource.getSession();
		UserDTO dto = (UserDTO) session.get(UserDTO.class, 1);

		System.out.print(dto.getId() + "\t");
		System.out.print(dto.getFirstName() + "\t");
		System.out.println(dto.getLastName());
		System.out.println(dto.getLoginId());
		System.out.println(dto.getPassword());

//	session.evict(dto);	
//while using evict , the query did not run again it shows that we get data from second level cache.
//		for 2nd level cache ---incfg file---- we use class cache tag and did read-only and give class path.
//		and enable 2nd level cache
		
		UserDTO dto1 = (UserDTO) session.get(UserDTO.class, 1);

		System.out.print(dto1.getId() + "\t");
		System.out.print(dto1.getFirstName() + "\t");
		System.out.println(dto1.getLastName());
		System.out.println(dto1.getLoginId());
		System.out.println(dto1.getPassword());

		session.close();

	}

}
