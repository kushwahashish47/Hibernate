package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.UserDTO;
import com.rays.util.HibDataSource;

public class TestRestriction {

	public static void main(String[] args) {

		Session Session = null;

		Session session = HibDataSource.getSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.like("firstName", "Ash%"));
//		criteria.add(Restrictions.eq("id", 2));
		List list1 = criteria.list();

		Iterator it = list1.iterator();

		while (it.hasNext()) {
			UserDTO dto = (UserDTO) it.next();

			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());

		}
	}

}
