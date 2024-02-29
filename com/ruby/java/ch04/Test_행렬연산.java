package com.ruby.java.ch04;
//203 252 258

import java.util.Random;

/*
 * 하나의 자바 파일에서 함수 구현 실습
 */
public class Test_행렬연산 {

	static void showMatrix(int X[][]) {//메소드선언, 스태틱이있으면 테스트클래스의 객체를 안만들고,,,리턴타입
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < X[0].length; j++) {
		//2차원 모습으로 출력
		System.out.print(X[i][j] + '\t');
			}
			System.out.println('\n');
		}
	}
	
	static void getData(int X[][]) {//메소드 선언, 메소드명=겟데이터 매개변수(파라미터)=int X[][]
		
		Random rnd = new Random();
		
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < X[0].length; j++) {
				X[i][j] = rnd.nextInt(10);
			}
	}
}
	//리턴타입미싱 > 없으니 앞에 보이드(199~200p)(앞에 스태틱이유는 객체를 안만들었으니까)
	//스태틱을 안쓰려면 메인에서 Test_행렬연산 t1 = new Test_행렬연산();
	//클래식에 객체를 만들어놓고 t1. 으로 근데 스태틱을 쓰면 t1그거 없이 돌릴 수 있다
	//t1을 만들고 겟데이터에 t1.GetData 이렇게 하면 됨
	//자바는 모든게 클래스로 시작, 쇼매트릭스 겟데이타같은건 클래스의 메소드임 근데 스태틱을 쓰면 객체를 안만들어도 메소드를 쓸수있다
	//상단의 클래스객체가 없어도 불러서 쓸수있는애다
	
	
	static int[][] addMatrix(int B[][], int C[][]) {//int[][]를 리턴값으로 반환하는(void아님) 메소드선언
		int A[][] = new int [B.length][B[0].length]; //A 참조변수 선언 A크기
		for (int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[0].length; j++) {
				A[i][j] = B[i][j]+C[i][j];
		//자바에서 모든함수는 리턴타입이 명시되어야함 그래서 int[][]
		//A(m) 참조변수선언, 공간할당안하면 오류  > = new int[][];
		}
	}
		return A; //리턴받아서 메소드 호출한곳으로 돌아감
}
	static int[][] multiplyMatrix(int B[][], int E[][]) {//int[][]를 리턴값으로 반환하는(void아님) 메소드선언
		int D[][] = new int [B.length][E[0].length];
		// 결과 행렬D의 크기는 첫 번째 행렬의 행과 두 번째 행렬의 열의 크기
		for (int i = 0; i < B.length; i++) {
			for ( int j = 0; j < E[0].length; j++) {
				D[i][j] = 0;
			for (int k = 0; k < B[0].length; k++) {
				D[i][j] += B[i][k] * E[k][j]; // A+=B는 A=A+B
				//A[i][k]는 A의 i번째 행과 B의 k번째 열의 요소
				//B[k][j]는 는 B의 k번째 행과 D의 j번째 열의 요소를 의미
				//이렇게 각 요소별로 곱한 값을 모두 더하면 D의 해당 위치의 값	
			}
		}
	}
		return D;
}
	static int[][] transposeMatrix(int B[][]) {//int[][]를 리턴값으로 반환하는(void아님) 메소드선언
		int F[][] = new int[B[0].length][B.length];// 전치 행렬의 크기는 B의 열과 행의 크기
		for (int i = 0; i < B[0].length; i++) {
			for (int j = 0; j < B.length; j++) {
				F[i][j] = B[j][i];
//				F[j][i] = B[i][j];
			}
		}
		return F;
	}
	
	public static void main(String[] args) {
		
		int A[][];//처음에 이렇게 메인에서 선언이 되고
		int B[][] = new int[3][4];
		int C[][] = new int[3][4];
		int E[][] = new int[4][5];
		int D[][]; // D를 저장할 배열선언
        int F[][]; // F를 저장할 배열선언
	
		/*
		 * 난수 생성으로 초기화
		 * A[3][4] = B[3][4] + C[3][4]; D[3][5] = B[3][4] * E[4][5];
		 * F[4][3] = B[3][4]의 전치 행렬
		 */
		System.out.println("행렬 더하기: A[3][4] = B[3][4] + C[3][4]");
		
		getData(B);//메서드호출
		getData(C);
		getData(E);
		A = addMatrix(B, C);
		//이거는 함수호출, 함수호출에서는 배열이름만 나열, 저게 스태틱 인티저[][](이거는 리턴타입)애드매트릭스(){}로 가
		//리턴타입은 결과를 반환하는 값
		//B, C : 파라미터 > 앞으로가는 파라미터패싱 , 변수의 타입을 기재>배열이니까 int[][]x, int[][]y
		//함수에서는 변수의 타입을 기재해야된다
		showMatrix(B);//메소드호출
		showMatrix(C);
		showMatrix(A);//매개변수A 호출받고 위에 쇼매트릭스에서 받는다
		
		System.out.println("행렬 곱하기: D[3][5] = B[3][4] * E[4][5]");
		D = multiplyMatrix(B,E);
		showMatrix(B);//메소드호출
		showMatrix(E);
		showMatrix(D);
		
		System.out.println("행렬 전치: F[4][3] = B[3][4]의 전치 행렬");
		F = transposeMatrix(B);
		showMatrix(B);//메소드호출
		showMatrix(F);
	}

}
