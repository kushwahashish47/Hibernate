package com.rays.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.dto.AuctionItem;
import com.rays.dto.Bid;

public class TestAuctionBid {
public static void main(String[] args) {
	Bid bid1 = new Bid();
	bid1.setId(1);
	bid1.setAmount(1000);
	bid1.setTimestamp("xyz");
	
	Bid bid2 =new Bid();
	bid2.setId(2);
	bid2.setAmount(2000);
	bid2.setTimestamp("x");
	
	Bid bid3 = new Bid();
	bid3.setId(3);
	bid3.setAmount(3000);
	bid3.setTimestamp("z");
	
	Set bids = new HashSet();
	bids.add(bid1);
	bids.add(bid2);
	bids.add(bid3);
	
	AuctionItem ai = new AuctionItem();
	ai.setId(1);
	ai.setDescription("auction  1");
	ai.setBids(bids);
	
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	
	Transaction tx = session.beginTransaction();
	session.save(ai);
	tx.commit();
	session.close();

}
}
