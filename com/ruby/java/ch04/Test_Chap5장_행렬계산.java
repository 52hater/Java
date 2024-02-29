package com.ruby.java.ch04;

import java.util.Random;

/*
 * 하나의 자바 파일에서 함수 구현 실습
 */
public class Test_Chap5장_행렬계산{
	/*
	 * 행렬 덧셈, 곱셈 연산 메소드 정의
	 * 1차버젼: 덧셈후 바로 출력
	 * 2차버젼: 덧셈후 return 값으로 결과 행렬 반환
	 */

	static void showMatrix(int X[][]) {
		//2차원 모습으로 출력
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < X[0].length; j++) {
		System.out.print(X[i][j]);
		}
		System.out.println('\n');
	}
}
	
	static void getData(int X[][]) {
		
		Random rnd = new Random();
		
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < X[0].length; j++) {
				X[i][j] = rnd.nextInt(10);
			}
		}
	}
	
	static int addMatrix(int B[][], int C[][]){
		int A[][] = new int[B.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				A[i][j] = B[i][j] + C[i][j];
			}
		}
	}
	
	
	static int multiplyMatrix(int B[][], int E[][]){
		int D[][] = new int[B.length][E[0].length];
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < E[0].length; j++) {
				for (int k = 0; k < B[0].length; k++) {
					D[i][j] += B[i][k] * E[k][j];
				}
			}
		}
	}
	
	static int transposeMatrix(B[][]) {
		int F[][] = new int[B[0].length][B.length];
		
		
	}
	public static void main(String[] args) {
		/*
		 * 난수 생성으로 초기화
		 * A[3][4] = B[3][4] + C[3][4]; D[3][5] = B[3][4] * E[4][5];
		 * F[4][3] = B[3][4]의 전치 행렬
		 */
		System.out.println("행렬 더하기: A[3][4] = B[3][4] + C[3][4]");
		getData(B);
		getData(C);
		getData(E);
		A = addMatrix(B, C);
		showMatrix(B);
		showMatrix(C);
		showMatrix(A);
		
		System.out.println("행렬 곱하기: D[3][5] = B[3][4] * E[4][5]");
		D = multiplyMatrix(B,E);
		showMatrix(B);
		showMatrix(E);
		showMatrix(D);
		
		System.out.println("행렬 전치: F[4][3] = B[3][4]의 전치 행렬");
		F = transposeMatrix(B);
		showMatrix(B);
		showMatrix(F);

	}

}
