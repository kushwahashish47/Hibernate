package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.rays.dto.UserDTO;
import com.rays.util.HibDataSource;

public class TestProjections {
	public static void main(String[] args) {

		Session session = null;

		session = HibDataSource.getSession();
		
		Criteria criteria = session.createCriteria(UserDTO.class);
		ProjectionList pl = Projections.projectionList();
		
		pl.add(Projections.property("id"));
		pl.add(Projections.property("firstName"));
		criteria.setProjection(pl);
		
		List list1 = criteria.list();
		Iterator it = list1.iterator();

		while (it.hasNext()) {
			Object[] dto = (Object[]) it.next();

			System.out.print(dto[0]);
			System.out.println(dto[1]);

		}

	}

}