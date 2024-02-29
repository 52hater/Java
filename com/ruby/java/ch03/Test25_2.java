package com.ruby.java.ch03;

import java.util.Scanner;

public class Test25_2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Num:");
		int num = sc.nextInt();//숫자입력대기모드 > 디버깅시 숫자를 입력해야지
//		for(int i =0; i < 10; i++) {
//		System.out.println(i);
//	}
//	System.out.println("OK");
	
		int sum1 = 0; //홀수 합
		int sum2 = 0; //짝수 합
		for (int i = 0; i <= num; i++) {
			
			if (i % 2 == 0) {	//짝수
				sum2 += i;
				System.out.println("e" + sum2);
			}
			else {				//홀수
				sum1 += i;
				System.out.println("o" + sum1);
			}
		}
		System.out.println("OK:" + sum1 + "," + sum2);
	}

}

//for (int i = 0; i < 10 ; i++){	} 숙달
//int j = 0; enter for (; j <10 ; j++){		} 가끔씀
//for (int i = 0; i < 10 ; i+=2){	} 필요에 따라 자주 씀 (10은 가변)