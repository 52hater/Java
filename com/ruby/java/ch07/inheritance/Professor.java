package com.ruby.java.ch07.inheritance;

public class Professor extends Person {
	private String subject;
	
	public Professor(String name, int age, String subject) {
		super(name,age);//생성자내부에서 첫줄에
		System.out.println("Professor 생성자");
		
		this.subject = subject;
	
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String toString() {
		super.toString();//이거는 부모클래스 펄슨에서 return name + " : " + age; 갖고오는거
		return super.toString() + " : " + subject;//이거는 위에거에서 과목을 추가한 것
	}
	
}
