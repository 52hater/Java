package com.ruby.java.ch07.inheritance;

public class Employee extends Person {
	private String dept;//디파트먼트 부서
	
	public Employee(String name, int age, String dept) {
		super(name,age);
		System.out.println("Employee 생성자");
	
		this.dept = dept;
	}
	
	public String getDept() {
		return dept;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String toString() {
		super.toString();//이거는 부모클래스 펄슨에서 return name + " : " + age; 갖고오는거
		return super.toString() + " : " + dept;//이거는 위에거에서 부서를 추가한 것
	}
}
