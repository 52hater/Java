package com.ruby.java.ch06;

public class Member {
	private String name;
	private int age;

	public Member() {
		System.out.println("Member() 생성자 실행");//이 메서드가 없어도 실행은 시킴
	}
	
	public Member(String name) {
		System.out.println("Member(String) 생성자 실행");
		System.out.println(name);
	}
	
	public Member(String name, int age) {
		System.out.println("Member(String, int) 생성자 실행");
		System.out.println(name + " : " + age);
	}
	
	public void setName(String name) {
	}
	
	public static void main(String[] args) { //프로그램 실행하면 제일 먼저 찾아가는 곳 : main
		System.out.println("main() 메서드 실행");//첫번째 메인메서드 실행
		new Member();//디폴트 생성자를 하나 호출
		new Member("Amy");
		new Member("Amy", 23);
	}//뉴 하는순간 실행이 되어서 "멤버생성자실행"

}
