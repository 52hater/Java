package DataStructure.Training1;

/*
 * 3번째 실습
 * 교재 83 - 배열 처리
 */

import java.util.Arrays;
import java.util.Random;
public class train_실습2_6다차원배열 {

	public static void main(String[] args) {
		int [][]A = new int[2][3];
		int [][]B = new int[3][4];
		int [][]C = new int[2][4];

		inputData(A);
		inputData(B);
		int [][]D = A.clone();//교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData(A);
		System.out.println("D[2][3] = ");
		showData(D);
		System.out.println();
		System.out.println("B[3][4] = ");
		showData(B);
		int [][]E = addMatrix(A,D);
		System.out.println("E[2][3] = ");
		showData(E);//A와 B가 바뀌면 안되니까 새로운 배열을 만들어서 전달해야되는거라서 E=A.addMatrix(B)가 아님 스태틱이니까 객체생성 x
		C = multiplyMatrix(A,B);
		System.out.println("C[2][4] = ");
		showData(C);

		int [][]F = transposeMatrix(A);
		System.out.println("F[3][2] = ");
		showData(F);
		boolean result = equals(A, D);
		System.out.println(" equals(A,D) = " + result);
		
		System.out.println("F = " + Arrays.deepToString(F));//2차원 배열 처리 
	}
	static void inputData(int [][]data) {
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				data[i][j] = rand.nextInt(10); // 랜덤한 값을 배열에 할당
			}
		}
	}
	static void showData(int[][]items) {
		for (int[] item : items) {
			System.out.print(items);
		}
		System.out.println();
	}
	static boolean equals(int[][]a, int[][]b) {
		if (a.length != b.length || a[0].length != b[0].length) 
			return false;

		return true;

	}
	static int[][] addMatrix(int [][]X, int[][]Y) {//스태틱메소드, 객체가 안만들어지고 함수처럼 쓰는거
		//X,Y는 변경되지않음, 
		int rows = X.length;
		int cols = X[0].length;
		int [][]Z = new int[rows][cols];
		

		return Z;//새로 만든 배열 주소를 E가 받는거지
	}
	static int[][] multiplyMatrix(int [][]X, int[][]Y) {
		int rows = X.length;
		int cols = Y[0].length;
		int [][]Z = new int[rows][cols];
		
		return Z;
		
	}
	static int[][] transposeMatrix(int [][]X) {
		int rows = X.length;
		int cols = X[0].length;
		int [][]Z = new int[cols][rows];

		return Z;
		
	}
}

