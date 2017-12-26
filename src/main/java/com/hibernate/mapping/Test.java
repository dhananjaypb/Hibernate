package com.hibernate.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Configuration cf = new Configuration();
		SessionFactory sf = cf.configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

/*		Address ad = new Address(41161, "Pune", null);
		Employee e = new Employee(101, "ABC", ad);
		ad.setEs(e);
		Address ad1 = new Address(41162, "Mumbai", null);
		Employee e1 = new Employee(102, "DEF", ad1);
		ad1.setEs(e1);
		Address ad2 = new Address(41163, "PCMC", null);
		Employee e2 = new Employee(103, "GHI", ad2);
		ad2.setEs(e2);*/
		
		Address ad = new Address(41161, "Pune");
		Employee e = new Employee(101, "ABC", ad);

		Address ad1 = new Address(41162, "Mumbai");
		Employee e1 = new Employee(102, "DEF", ad1);
		Address ad2 = new Address(41163, "PCMC");
		Employee e2 = new Employee(103, "GHI", ad2);


		
		s.save(e);
		s.save(e1);
		s.save(e2);

		t.commit();
		s.close();

	}

}
