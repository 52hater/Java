package com.ruby.java.ch06;

public class Member263p {
	private String name;
	private int age;

	public Member263p() {
		this("guest");
	}
	
	public Member263p(String name) {
		this(name, 0);
	}
	
	public Member263p(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member264p [name=" + name + ", age=" + age + "]";
	}
	public static void main(String[] args) {
		Member263p m1 = new Member263p();
		Member263p m2 = new Member263p("Amy");
		Member263p m3 = new Member263p("Amy", 23);
		System.out.println("m1:" + m1);
		System.out.println("m2:" + m2);
		System.out.println("m3:" + m3);
	}

}
