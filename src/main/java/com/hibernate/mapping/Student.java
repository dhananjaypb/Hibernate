package com.hibernate.mapping;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Student_Info")
public class Student {
	@Id
	int StdId;
	@Column
	String Name;
	@Column
	String Surname;
	@OneToMany(cascade = CascadeType.ALL)
	
	List<Subject> Su;

	public Student(int stdId, String name, String surname, List<Subject> su) {
		super();
		StdId = stdId;
		Name = name;
		Surname = surname;
		Su = su;
	}

	public Student() {
		super();
	}

	public int getStdId() {
		return StdId;
	}

	public void setStdId(int stdId) {
		StdId = stdId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public List<Subject> getSu() {
		return Su;
	}

	public void setSu(List<Subject> su) {
		Su = su;
	}

}

@Entity
class Subject {
	@Id
	@Column
	int Marks;
	@Column(name = "Subject")
	String SubName;
	/*@ManyToMany(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	List<Student> st;*/

	
	/*public Subject(int marks, String subName, List<Student> st) {
		super();
		Marks = marks;
		SubName = subName;
		this.st = st;
	}*/

	public Subject() {
		super();
	}

	public Subject(int marks, String subName) {
		super();
		Marks = marks;
		SubName = subName;
	}

	public int getMarks() {
		return Marks;
	}

	public void setMarks(int marks) {
		Marks = marks;
	}

	public String getSubName() {
		return SubName;
	}

	public void setSubName(String subName) {
		SubName = subName;
	}

/*	public List<Student> getSt() {
		return st;
	}

	public void setSt(List<Student> st) {
		this.st = st;
	}*/

}
