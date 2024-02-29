package com.ruby.java.ch05;

import java.util.Arrays;
import java.util.Random;

/*
 * 클래스 메소드(객체가 아니라 클래스에 속해있는) 구현 실습 목적 
 * //행렬을 클래스로 만들어서 구현하는거 과제1번
 * 클래스 메소드 선언 앞에 static 키워드, 인스턴스(객체)없이도 호출가능
 * the type (class명) is already defined 나오면 같은이름의 클래스가 패키지 안에 있다는거니까
 * 같은이름의 클래스가 있는걸 찾아서 주석처리하고 위에 프로젝트 > 클리어 하면 됨
 * 그 후에 주석처리 지우면 그 파일이 오류뜸 
 */
class Matrix {
   int rows;//이런게 필드값
   int cols;
   int[]data;//int[]데이터타입 > 1차원배열밖에 안된대 , int data[] = int[] data는 같은거
   public Matrix(int rows, int cols) {//생성자
      this.rows = rows;//매트릭스.rows란 소리래
      this.cols = cols;
      data = new int[rows * cols];
   }
   private void getData() {
      // 난수로 입력
      
      Random rnd = new Random();
      
      for (int i = 0; i < rows * cols; i++) {
         data[i] = rnd.nextInt(10);
      }
   }
//   B.addMatrix(C); 밑의 매트릭스랑 B >> 클래스가C도 있으니까 B거를 쓰게 this
   Matrix addMatrix(Matrix Input) {
      Matrix Result = new Matrix(this.rows, this.cols);
      for (int i = 0; i < data.length; i++) {
         Result.data[i] = this.data[i] + Input.data[i];
         }
      return Result;
      }
      
      
   Matrix multiplyMatrix(Matrix Input) {
      Matrix Result = new Matrix(this.rows, this.cols);
      for (int i = 0; i < data.length; i++) {
         Result.data[i] = this.data[i] * Input.data[i];
         }
      return Result;
      }
   
   Matrix transposeMatrix() {
      Matrix Result = new Matrix(this.cols, this.rows);
      return Result;
   }
   void showMatrix() {
         int[] data1 = this.data;
               for(int i = 1; i <= data1.length; i++) {
                  System.out.print(this.data[i-1] + "  ");
                  if (i % this.cols == 0) {
                     System.out.println("\n");
                  }
               }
                        System.out.print("\n");
//         for (int j = 0; j < this.cols; j++) {//this를 써야B인지C인지A인지
//            System.out.println(this.data);
//         }
      }
//      System.out.println(Arrays.toString(this.data));
      
      //2차원 배열 모양으로 출력하는 코드 작성
   }

public class Test_행렬클래스 {

   public static void main(String[] args) {
      /*
       * 난수 생성으로 초기화
       * A[3][4] = B[3][4] + C[3][4]; D[3][5] = B[3][4] * E[4][5]; //이제 이거를 구해야되는거지
       * F[4][3] = B[3][4]의 전치 행렬 //이거랑
       */
      Matrix B = new Matrix(3,4);//생성자 메소드를 호출하려고 한거, 그래서 매개변수가(3, 4)
      Matrix C = new Matrix(3,4);
      Matrix A, D, F;
      Matrix E = new Matrix(4,5);

      System.out.println("행렬 더하기: A[3][4] = B[3][4] + C[3][4]");
      B.getData();
      C.getData();
      E.getData();
      
      A = B.addMatrix(C);
      B.showMatrix();
//      C.showMatrix();
//      A.showMatrix();
      
//      System.out.println("행렬 곱하기: D[3][5] = B[3][4] * E[4][5]");
//      D = B.multiplyMatrix(E);
//      B.showMatrix("B[3][4]");
//      E.showMatrix("E[4][5]");
//      D.showMatrix("D[3][5]");
//      
//      System.out.println("행렬 전치: F[4][3] = B[3][4]의 전치 행렬");
//      F = B.transposeMatrix();
//      B.showMatrix("B[3][4]");
//      F.showMatrix("F[4][3]");

   }

}