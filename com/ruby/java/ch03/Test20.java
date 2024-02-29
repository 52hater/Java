package com.ruby.java.ch03;

import java.util.Scanner;

public class Test20 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//sc:참조변수		
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		char grade;
		
		if(score >= 90) {
			grade = 'A';
		} else if(score >= 80) {
			grade = 'B';
		} else if(score >= 70) {
			grade = 'C';
		} else if(score >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		System.out.println("당신의 등급은 점수가 " + score + "점이기 때문에 " + grade + "입니다.");
		}
	}
