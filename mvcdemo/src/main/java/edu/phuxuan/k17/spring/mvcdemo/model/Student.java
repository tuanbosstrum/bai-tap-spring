package edu.phuxuan.k17.spring.mvcdemo.model;



public class Student {
private String fullname;
	
	public Student() {
		
	}
	public Student(String fullname) {
		super();
		
		this.fullname = fullname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
}