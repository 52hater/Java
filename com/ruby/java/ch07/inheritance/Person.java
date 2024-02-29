package com.ruby.java.ch07.inheritance;

public class Person {
	private final String ID = "123";//final 변수 예(299p)
	private String name;//프라이빗은 자기클래스밖에 못읽음 > 자식클래스도 못읽어
	//그래서 게터세터등 퍼블릭메소드를 이용해서 접근 그게 겟 셋 쓰는 이유
	//프라이빗말고 프로텍티드를 쓰면 자식클래스는 읽을 수 있게 (디폴트인가?)
	//현재 자바 추세는 필드에 프라이빗을 기본적으로 써서 퍼블릭은 없다고 생각하면 됨
	
	private int age;
	
//	public Person() {} //<--기본 생성자

	public Person(String name, int age) {
		System.out.println("Person 생성자");
	}//컨트롤스페이스 누르면 펄슨 컨스트럭터 > 생성자
	
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

	@Override//부모클래스로부터 상속받은 메소드
	//근데 이거는 상속받은게 아니잖아 > 에러날거야..
	public String toString() {
		return name + " : " + age;
	}
	
	
}
