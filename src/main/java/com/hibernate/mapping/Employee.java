package com.hibernate.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table
public class Employee {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Identy")
	int EmpId;
	//@Id
	@Column(name = "Name")
	String Name;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	//@JoinTable(name = "Basic_Detail", joinColumns = @JoinColumn(name = "Name"), inverseJoinColumns = @JoinColumn(name = "Pincode"))
	@JoinColumn(name="Address")
	Address ad;

	public Employee(int empId, String name, Address ad) {
		super();
		EmpId = empId;
		Name = name;
		this.ad = ad;
	}

	public Employee() {
		super();
	}

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Address getAd() {
		return ad;
	}

	public void setAd(Address ad) {
		this.ad = ad;
	}

}

@Entity
@Table
class Address {
	 @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Pincode")
	int pincode;
	//@Id
	@Column(name = "City")
	String City;
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Employee")
	Employee es;*/

	public Address() {
		super();
	}

/*	public Address(int pincode, String city, Employee es) {
		super();
		this.pincode = pincode;
		City = city;
		this.es = es;

	}*/
	
	

	public int getPincode() {
		return pincode;
	}

	public Address(int pincode, String city) {
	super();
	this.pincode = pincode;
	City = city;
}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

/*	public Employee getEs() {
		return es;
	}

	public void setEs(Employee es) {
		this.es = es;
	}*/

}
