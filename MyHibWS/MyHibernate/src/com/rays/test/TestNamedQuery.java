package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.rays.dto.UserDTO;
import com.rays.util.HibDataSource;

public class TestNamedQuery {
	
	public static void main(String[] args) {
		
		Session session = null;
		session=HibDataSource.getSession()	;
//		in UserDTO hbm file use query tag, name=all user
//		and add one more line.use this where class tag closes
//		and line out cache part from cfg .
		
		Query q = session.getNamedQuery("all user");
		
		
		List list = q.list();
		Iterator it=list.iterator();
		
		while(it.hasNext()) {
			UserDTO dto = (UserDTO) it.next();

			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());

		}

	}

}
