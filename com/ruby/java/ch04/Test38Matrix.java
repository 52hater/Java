package com.ruby.java.ch04;

import java.util.Random;

public class Test38Matrix {

	public static void main(String[] args) {
		
		Random rnd1 = new Random();
		
		int A[][] = new int[3][4];//난수 입력 , new=공간할당명령어
		int B[][] = new int[4][5];//난수 입력
	
		for (int i = 0; i < A.length; i++)
			for(int j = 0; j < A[0].length; j++)
				A[i][j] = rnd1.nextInt(10);
		for (int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[0].length; j++) {
					System.out.print(A[i][j]);
		System.out.print("\t");
	}
			System.out.println();
		}
		
			Random rnd2 = new Random();
			System.out.println("\n");
			{
	for (int i = 0; i < B.length; i++)
		for(int j = 0; j < B[0].length; j++)
			B[i][j] = rnd2.nextInt(10);
	for(int i = 0; i <B.length; i++) {
		for(int j = 0; j < B[0].length; j++) {
		System.out.print(B[i][j]);
		System.out.print("\t");
	}
	System.out.println();
	}
	
		int C[][] = new int[3][5];
		int D[][] = new int[3][4];//난수 입력
		int E[][] = new int[3][4];
		int F[][] = new int[4][3];
		
		// C = A * B;//행렬 곱하기
		// E = A + D;//행렬 더하기
		// F = A의 전치행렬(행, 열 바꿈)

	}
	}
}