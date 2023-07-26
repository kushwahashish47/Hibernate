package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.UserDTO;
import com.rays.util.HibDataSource;

public class TestCriteriaOrderBy {

	public static void main(String[] args) {

		Session session = null;
		session = HibDataSource.getSession();

		Criteria crit = session.createCriteria(UserDTO.class);

		crit.add(Restrictions.like("firstName", "A%"));
		// crit.add(Restrictions.like("lastName", "Kus%"));
		// crit.addOrder(Order.asc("firstName"));
		crit.addOrder(Order.desc("firstName"));

		List list = crit.list();
		Iterator it = list.iterator();

		while (it.hasNext()) {

			UserDTO dto = (UserDTO) it.next();
			System.out.println(dto.getFirstName());

		}
	}

}
