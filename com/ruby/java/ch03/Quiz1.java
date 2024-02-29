package com.ruby.java.ch03;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Num:");
		int num = sc.nextInt();
		
		boolean flag = false;
		for(int i = 2 ; i < num; i++) {
			if(num % i == 0)
				flag = true; //소수가 아니라는얘기 >루프탈출>브레이크
			break;
		}
		System.out.println(flag?"소수가 아닙니다.":"소수입니다.");
	}
	
}
//임의의 수를 입력 받아서 해당 수가 소수인지 확인하는 프로그램 작성 출력 예) 입력:7 -> 소수입니다.
//for쓰고 if %2 =
//a%2 =b a%3=c a%4=d ~~~ a%a=0
//코드짤때 순서 : 숫자하나 입력받자>소수:1과 자기자신을 제외하고 나눠지지않는수
//2부터 자기자신보다 하나 작은 수까지 나누어서 %가 0이 아닌
//num:10이면 2~9까지 나눠지지않으면 소수지
//System.out.println(flag?"소수가 아닙니다.":"소수입니다.");

//int i = 2;
//for(i=2; i<num; i++){
//if(num%i == 0) break;
//}
//System.out.println((i<num)"소수가 아닙니다.":"소수입니다.")); <- 삼항뭐시기