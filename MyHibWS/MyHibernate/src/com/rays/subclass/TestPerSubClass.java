package com.rays.subclass;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rays.util.HibDataSource;

public class TestPerSubClass {
	public static void main(String[] args) {
//1st case is table per class using-------discriminator tag and then subclass tag in payment.hbm.xml(in results we get one table i.e. payment )
//2nd case is table per sub class using--- joined-subclass (3 tables will appear in result)
//3rd case is table per sub class using----using discriminator tag by using (subclass , discriminator and joins)
		
		CreditCard cc = new CreditCard();
		cc.setCcType("abc");
		cc.setAmount(4500);

		Cash c = new Cash();
		c.setAmount(3000);

		Cheque cq = new Cheque();
		cq.setAmount(7000);
		cq.setChequeNo("123");
		cq.setBankName("icicibank");
		
		Session session = null;
		session = HibDataSource.getSession();

		Transaction tx = session.beginTransaction();
		session.save(cc);
		session.save(c);
		session.save(cq);

		tx.commit();
		session.close();
	}

}
