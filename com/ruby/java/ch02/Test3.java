package com.ruby.java.ch02;

public class Test3 {

	public static void main(String[] args) {
		
		float exchangeRate = 1236.50f;//f가 안붙으면 자바 컴파일러가 더블로 간주함
		//더블은 8바이트 플롯은 4바이트,, 8바이트->4바이트 (정보손실)
		//(코딩의 기본은 치환(assignment)과정에서 정보손실이 없어야함)(대원칙)
		//정보손실아닌게 확실해>어거지로>(float)1236.50; > type casting(explicit conversion)(남발하면 안되는)
		//explicit conversion(데이터변환) <-> implicit conversion 이거는 그냥 구글링해..
		
		String st = "Good Day! How are you";
		
		int num = 2147483647;
		int numSize = Integer.SIZE;//정수변수 int를 클래스Integer로 wrapper class하였음(나중에 배운대)
		System.out.println("numSize= "+ numSize);

		long d = 2147483648L;//L을 쓰는 이유 : 69page (long integer)>아무말이 없으면 4바이트 인티저로 간주
		//롱 디 는 문제없는데 그 상수가 4바이트가 넘었다 > 4바이트 인티저로 표현(메모리에 임시저장)하려하니 오류 > L붙여
		//d 변수가 8바이트인지 4바이트인지 확인하는 방법은?
		int dSize = Long.SIZE;
		System.out.println("dSize= "+ dSize);

	}

}
