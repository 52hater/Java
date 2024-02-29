package com.ruby.java.ch11;

public class Test01 {

	public static void main(String[] args) {
		try {
			int arr[] = new int[3];
			arr[3] = 30;
			System.out.println("OK");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("잘못된 배열의 인덱스 사용!");
		}
		System.out.println("Good");

	}
}
//루프일경우 오류가나면 프로그램이 종료되는데 예외처리해서 계속 반복되도록
