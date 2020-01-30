package com.accolite.student;

public class Student {
	private String usn;    
	private String name;
	private String department;
	private int semester;
	
	public Student() {
		super();
	}
	public Student(String usn, String name, String department, int semester) {
		super();
		this.usn = usn;
		this.name = name;
		this.department = department;
		this.semester = semester;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	
	
	
}
