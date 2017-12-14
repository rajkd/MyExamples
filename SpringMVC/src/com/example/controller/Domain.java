package com.example.controller;

import java.util.Date;

public class Domain {
	private String name = "John Doe";
	private int age = 100;
	private Date dob = null;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Domain [name=" + name + ", age=" + age + ", dob=" + dob + "]";
	}
	
	
}
