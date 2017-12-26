package com.hibernate.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BAtest {

	public static void main(String[] args) {
		
		Configuration cf = new Configuration();
		SessionFactory sf = cf.configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t= s.beginTransaction();
		
	
		Book b1 = new Book(10, "Bank");
		Book b2 = new Book(20, "CA");
		Book b3 = new Book(30, "IPS");
		
		List<Book> Compitive = new ArrayList<Book>();
		Compitive.add(b1);
		Compitive.add(b2);
		Compitive.add(b3);
		
		Author a1 = new Author(101, "Dhananjay", Compitive);
		//Author a2 = new Author(102, "Adnaan", Compitive);
		
		s.save(a1);
		//s.save(a2);
		t.commit();
		s.close();

	}

}
