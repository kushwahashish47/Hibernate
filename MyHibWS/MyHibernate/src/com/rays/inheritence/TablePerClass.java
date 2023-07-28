package com.rays.inheritence;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TablePerClass {

	public static void main(String[] args) {

		CreditCard cc = new CreditCard();
		cc.setCctype("abc");
		cc.setAmount(4500);
		cc.setPaymentType("HDBC");

		Cash c = new Cash();
		c.setAmount(3000);
		c.setPaymentType("nagad");

		Cheque cq = new Cheque();
		cq.setAmount(7000);
		cq.setChequeNo("123");
		cq.setBankName("icicibank");
		cq.setPaymentType("by cheque");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		session.save(cc);
		session.save(c);
		session.save(cq);

		t.commit();
		session.close();

	}

}
