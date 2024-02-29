package com.ruby.java.ch05;

import java.util.Scanner;

public class Quiz2case {
	static int getNumber(Scanner sc) {
		int num;
		do {
			System.out.println("10 ~ 100사이 정수입력[마치려면 0] : ");
			num = sc.nextInt();
		} while (num ! = 0 && (num < 10 || 100 < num));
		return num;
	}
	public static int calc(int a, int b, int c) {
		return a * 2 + b * 3 + c * 5;
	}
	public static void main(String[] args) {
		Scanner sc = new
		
		
	}

}


//Scanner sc = new Scanner(System.in);
//System.out.println("Num:");
//int num = sc.nextInt();
//2:a 3:b 5:c
//for(int a = 1; a <= 10; a++)
//{for(int b = 1; a <= 10; b++)
//{for(int c = 1; c <= 10; C++)
//sum