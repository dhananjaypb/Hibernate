package com.hibernate.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
// @Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="ClassType")
public class Parent {
	@Id
	@Column
	int value;
	@Column
	String Name;
	@Column
	String surname;

	public Parent(int value, String name, String surname) {
		super();
		this.value = value;
		Name = name;
		this.surname = surname;
	}

}

@Entity
class Child extends Parent {
	@Column
	int age;
	@Column
	String ChildName;

	public Child(int value, String name, String surname, int age, String childName) {
		super(value, name, surname);
		this.age = age;
		ChildName = childName;
	}

}

class Main {

	public static void main(String[] args) {

		Configuration cf = new Configuration();
		SessionFactory sf = cf.configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tra = s.beginTransaction();

		Parent p = new Parent(105, "ABC", "DEF");
		Child c = new Child(10, "xyz", "Jkl", 26, "PQR");

		s.save(p);
		s.save(c);
		tra.commit();
		s.close();

	}
}