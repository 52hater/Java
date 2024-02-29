package com.ruby.java.ch07.inheritance;

public class Student extends Person {
	private String major;
	
	public Student(String name, int age, String major) {
		super(name,age);
		System.out.println("Student 생성자");
				
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public String toString() {
		super.toString();//이거는 부모클래스 펄슨에서 return name + " : " + age; 갖고오는거
		return super.toString() + " : " + major;//이거는 위에거에서 전공을 추가한 것
	}
}
