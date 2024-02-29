package com.ruby.java.ch06;

public class ThisTest {
	int i = 1;
	
	public void first() {
		int i = 2;
		int j = 3;
		this.i = i + j;
		
		second(4);
	}
	public void second(int i) {
		int j = 5;
		this.i = i + j;//내 메소드가 포함되어있는 클래스의 i라는 의미에서 붙인 디스
	}//게터세터를 쓰면 name=name, age=age같은게 말이 안되게 되니까 디스를 붙여주는 것
	
	public static void main(String[] args) {
		ThisTest exam = new ThisTest();
		exam.first();
		System.out.println("Done");//시스아웃없으면 이런거 하나띄워놔서
	}

}
