package com.ruby.java.ch02;

public class Test15 {

	public static void main(String[] args) {
		char c = 'F';
		String gender;
		if (c == 'F')
			gender ="여자";
		else
			gender ="남자";//이걸 아래로 정리해서 간결하게 삼항연산자로
		//String gender = (c == 'F') ? "여자" : "남자";
		//                첫번째항       두번째항   세번째항
		//              If(c~~       ?:=then :=else
		System.out.println(gender);

	}

}
