package com.ruby.java.ch06;

public class StaticMethodTest {
	public static void main(String[] args) {
		StaticMethodTest.print1();
		StaticMethodTest exam = new StaticMethodTest();
		exam.print2();
		
	}

	public static void print1() {
		System.out.println("hello");
	}
	
	public void print2() {
		System.out.println("java");
	}
		
}
//main은 왜 static이 붙어야하나
//객체필요없이(new로 인스턴스를 만들지 않아도)사용할 수 있으려면 static
//근데 new로 참조변수로 참조해오는게

