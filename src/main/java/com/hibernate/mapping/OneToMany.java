package com.hibernate.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToMany {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		Configuration cf = new Configuration();
		SessionFactory sf = cf.configure().buildSessionFactory();
		Session s= sf.openSession();
		Transaction tr = s.beginTransaction();
		
		Subject sub = new Subject(81, "Marathi");
		Subject sub1 = new Subject(82,"English");
		Subject	sub2 = new Subject(83, "Hindi");
		
		List<Subject> ListOfClass= new ArrayList();
		
		ListOfClass.add(sub1);
		ListOfClass.add(sub2);
		
		List<Subject> ListOfSubjects = new ArrayList();
		ListOfSubjects.add(sub);
		ListOfSubjects.add(sub1);
		ListOfSubjects.add(sub2);
		
		Student s1 =new Student(101, "A", "B", ListOfSubjects);
		/*Student s2 = new Student(102, "C", "D",ListOfClass);
		
		List<Student> ListOfStudent = new ArrayList<Student>();
		ListOfStudent.add(s1);
		ListOfStudent.add(s2);
		
		List <Student> ListOfTopper=new ArrayList<Student>();
		ListOfTopper.add(s1);

		sub.setSt(ListOfStudent);
		sub1.setSt(ListOfStudent);
		sub2.setSt(ListOfTopper);
*/				
		s.save(s1);
		//s.save(s2);
		
		tr.commit();
		s.close();
		
		
	}

}
