package DataStructure.Ch02;

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
      for (int[] row : items) {
         for (int item : row) {
            System.out.print(item + " ");
         }
         System.out.println();
         }
//   static void showData(int[][] items) {
//      for (int i = 0; i < items.length; i++) {
//         for (int j = 0; j < items[i].length; j++) {
//            System.out.print(items[i][j] + " ");
//         }
//         System.out.println();
//      }
//   }
      System.out.println();
   }
   static boolean equals(int[][]a, int[][]b) {
      if (a.length != b.length || a[0].length != b[0].length) 
         return false;

      return true;

   }
   static int[][] addMatrix(int [][]X, int[][]Y) {//스태틱메소드, 객체가 안만들어지고 함수처럼 쓰는거
      //X,Y는 변경되지않음, 행렬의 덧셈은 크기가 같아야만 가능
      int rows = X.length;//X의 행의 개수(크기?)
      int cols = X[0].length;//X의 열의 개수 > 덧셈은 두 행렬의 크기가 똑같아야해서 하나만 가져오면 되는 듯
      int [][]Z = new int[rows][cols];//Z는 더한 결과행렬이지//Z생성
      
      if (rows != Y.length | cols != Y[0].length) {//row 든 col 이든 arr[][]X 의 크기니까
         System.out.println("두 행렬의 크기가 일치하지 않음");
      }
      
      for (int i = 0; i < X.length; i++) {//X.length는 rows 로 치환가능하지
         for (int j = 0; j < X[0].length; j++) {//X[0].length도 cols로 치환가능하지
            Z[i][j] = X[i][j] + Y[i][j]; //인덱스 값을 안넣는 실수를 했네
         }
      }
      return Z;//새로 만든 배열 주소를 E가 받는거지
   }
   static int[][] multiplyMatrix(int [][]X, int[][]Y) {//행렬곱셈 다시 복습해 헷갈리네
      int rows = X.length;
      int cols = Y[0].length;
      int [][]Z = new int[rows][cols];
      
      for (int i = 0; i < X.length; i++) {
         for (int j = 0; j < Y[0].length; j++) {
            for (int k = 0; k < X[0].length; k++) {
               Z[i][j] += X[i][k] * Y[k][j];//이거 왜 [i][j]Z 처럼 나타내면 오류?
            }
            
         }
      }

      return Z;

   }
   static int[][] transposeMatrix(int [][]X) {//전치행렬도 다시 복습해 ㅡㅡ//Z가 X의 전치행렬로 되는 메소드
      int rows = X.length;
      int cols = X[0].length;
      int [][]Z = new int[cols][rows];
      
      for (int i = 0; i < X.length; i++) {
         for (int j = 0; j < X[0].length; j++) {
            Z[j][i] = X[i][j];
         }
      }

      return Z;

   }
}