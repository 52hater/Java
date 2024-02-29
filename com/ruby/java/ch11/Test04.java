package com.ruby.java.ch11;

import java.io.FileInputStream;

public class Test04 {

	public static void test() throws Exception {

		FileInputStream fi = new FileInputStream("a1.txt");
		int c = fi.read();
		System.out.println((char) c);
	}

	public static void main(String[] args) {
		System.out.println("Start");
		try {
			test();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("End");
	}
}
//이미 만들어져있는 프로그램 사용할때 트라이캐치로 싸줄래? 던질래?
//여기 안에서 처리하겠다:트라이캐치//호출하는데서 모아서 처리하겠다 > 익셉션으로 던져

