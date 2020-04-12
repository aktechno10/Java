package com.hibDemo.TestHib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_table")
public class Test 
{
	@Id
	private int id;
	@Column(name = "sname")//create new column	
	private StudName aname;
	private String sclass;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public StudName getAname() {
		return aname;
	}
	public void setAname(StudName aname) {
		this.aname = aname;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}		
}
