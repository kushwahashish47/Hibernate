package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.UserDTO;
import com.rays.util.HibDataSource;

public class TestDetachedCriteria {
	public static void main(String[] args) {

		DetachedCriteria dc = DetachedCriteria.forClass(UserDTO.class);

		dc.add(Restrictions.like("firstName", "A%"));
		Session session = null;
		session = HibDataSource.getSession();
		
		
		List list = dc.getExecutableCriteria(session).list();
			Iterator it =list.iterator();
			while (it.hasNext()) {
				UserDTO dto = (UserDTO) it.next();
				
				System.out.println(dto.getId());
				System.out.println(dto.getFirstName());
				System.out.println(dto.getLastName());
				System.out.println(dto.getLoginId());
				System.out.println(dto.getPassword());
	
				
			}
			session.close();
	}

}
