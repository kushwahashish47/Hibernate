package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.rays.dto.UserDTO;
import com.rays.util.HibDataSource;

public class TestProjectionsAggregate {

	public static void main(String[] args) {
		Session session = null;

		session = HibDataSource.getSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		ProjectionList pl = Projections.projectionList();
//		pl.add(Projections.count("id"));		
//		pl.add(Projections.rowCount());
//		pl.add(Projections.max("id"));
//		pl.add(Projections.groupProperty("lastName"));

	

		criteria.setProjection(pl);

		List list = criteria.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object dto = (Object) it.next();
			System.out.println(dto);
		}

		session.clear();

	}

}
