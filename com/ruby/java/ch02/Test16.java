package com.ruby.java.ch02;

public class Test16 {

	public static void main(String[] args) {
	byte a = 23;
	int b = a;
	//a = b; 하면 에러남 -> 인트를 바이트로하니까 할 수 없다 세가지 픽스웨이 나오는 것 봐
	//Add cast to 'byte'/Change type of 'a' to 'int'/Change type of 'b' to 'byte
	//밑에 하나씩 연습
	
	byte i = 10;
	byte j = 20;
	byte k = (byte)(i + j);
	//자바에서 +는 정수에 대한 operator -> inplicit casting
	}

}
