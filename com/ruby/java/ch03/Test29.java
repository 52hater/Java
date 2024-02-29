package com.ruby.java.ch03;

public class Test29 {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			if((i % 2) == 0)
				continue; //한줄>중괄호 생략가능, 디버깅 용이하도록 아랫줄 배치
			System.out.println(i);
		}

	}

}
