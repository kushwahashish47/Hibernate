package com.rays.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.AuctionItem;
import com.rays.dto.Bid;
import com.rays.util.HibDataSource;

public class TestJoin {

	public static void main(String[] args) {

		Session session = null;
		session = HibDataSource.getSession();

		Criteria crit = session.createCriteria(AuctionItem.class);
		crit.setFetchMode("Item_Id", FetchMode.JOIN);
		crit.add(Restrictions.eq("id", 1));

		List list = crit.list();
		Iterator it = list.iterator();

		while (it.hasNext()) {
			AuctionItem ai = (AuctionItem) it.next();
			System.out.println(ai.getId());
			System.out.println(ai.getDescription());

			Set s = ai.getBids();
			
			Iterator it1 = s.iterator();
			while(it1.hasNext()) {
				Bid b = (Bid) it1.next();
			System.out.println(b.getId());
			System.out.println(b.getAmount());
			System.out.println(b.getItemid());
			
			}
			
		
		}

	}

}
