package com.ruby.java.ch05;

public class Test2 {
	static void test(String name, int...v) {
		//v라는 이름의 int형 배열에다 저장을하고
		System.out.print(name + " : ");
		for(int x : v)
		//가시적으로 확인 > 디버깅을 해보면 됨
		//변수x : 배열v >> 배열의 넘버가 정수이므로 int 한 것
			System.out.print(x + " / ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		test("오정임", 98, 85 ,88);
		test("오정님", 97, 84 ,87);
		test("오정심", 96, 83 ,86);
	}
}
