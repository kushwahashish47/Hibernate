package com.rays.dirtyCheck;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.dto.AuctionItem;

public class TestDirtyCheck {
	public static void main(String[] args) {
		
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	session.setFlushMode(FlushMode.MANUAL);
//	use this to AVOID dirtycheck
	Transaction tx = session.beginTransaction();

	
	AuctionItem ai = (AuctionItem) session.get(AuctionItem.class,3);
//	after getting data we set data and then it quickly update data in database without calling update method is known as dirtycheck.
	ai.setDescription("new Auction 5");
	tx.commit();
	session.close();
	
	
	}
}
