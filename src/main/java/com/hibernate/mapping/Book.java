package com.hibernate.mapping;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Book {
	
	@Id
	int BookId;
	String BName;
	public Book(int bookId, String bName) {
		super();
		BookId = bookId;
		BName = bName;
	}
	public Book() {
		super();
	}
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public String getBName() {
		return BName;
	}
	public void setBName(String bName) {
		BName = bName;
	}
	
	
	
}

@Entity
class Author
{
	@Id
	int AId;
	String Aname;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinTable
	List<Book> Bk;
	public Author(int aId, String aname, List<Book> bk) {
		super();
		AId = aId;
		Aname = aname;
		Bk = bk;
	}
	public Author() {
		super();
	}
	public int getAId() {
		return AId;
	}
	public void setAId(int aId) {
		AId = aId;
	}
	public String getAname() {
		return Aname;
	}
	public void setAname(String aname) {
		Aname = aname;
	}
	public List<Book> getBk() {
		return Bk;
	}
	public void setBk(List<Book> bk) {
		Bk = bk;
	}
		
}
