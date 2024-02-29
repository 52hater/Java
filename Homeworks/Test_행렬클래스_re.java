package Homeworks;

import java.util.Random;

/*
 * 클래스 메소드(객체가 아니라 클래스에 속해있는) 구현 실습 목적 
 * //행렬을 클래스로 만들어서 구현하는거 과제1번
 * 클래스 메소드 선언 앞에 static 키워드, 인스턴스(객체)없이도 호출가능
 * the type (class명) is already defined 나오면 같은이름의 클래스가 패키지 안에 있다는거니까
 * 같은이름의 클래스가 있는걸 찾아서 주석처리하고 위에 프로젝트 > 클리어 하면 됨
 * 그 후에 주석처리 지우면 그 파일이 오류뜸 
 */

/*이 파일에는 Matrix 클래스와 Test_행렬클래스라는 두 개의 클래스가 있습니다.
Matrix 클래스: 이 클래스는 행렬 연산을 수행하는 메소드를 구현한 클래스입니다.
이 클래스 안에는 행렬을 초기화하고 연산하는 여러 메소드들이 정의되어 있습니다.
Test_행렬클래스 클래스: 이 클래스는 메인 메소드인 main 메소드가 포함된 클래스입니다.
이 클래스는 프로그램의 시작점이 되며, 메인 메소드를 통해 행렬 클래스의 메소드들을 호출하고 결과를 출력합니다.
따라서 두 개의 클래스가 정의되어 있고, 각 클래스는 서로 다른 역할을 수행합니다.
Matrix 클래스는 행렬 연산을 정의하고 구현하는 역할을 하고, 
Test_행렬클래스 클래스는 프로그램의 진입점을 제공하고 행렬 연산을 테스트하는 역할을 합니다.*/


class Matrix {//클래스 Matrix
   int rows;//필드값들 선언
   int cols;
   int[]data;//int[]데이터타입 > 1차원배열, int data[] = int[] data는 같은거
   
   public Matrix(int rows, int cols) {//생성자
      this.rows = rows;//매트릭스.rows란 소리래
      this.cols = cols;
      data = new int[rows * cols];
   }
   /*생성자는 객체가 생성될 때 호출되는 특별한 메소드로, 주로 객체의 초기화를 담당합니다.
위의 생성자는 행과 열의 크기를 인자로 받아 해당 크기의 행렬을 초기화합니다. 
행렬의 데이터는 data 배열에 저장되며, 이 배열의 크기는 행과 열의 곱으로 설정됩니다.
따라서 Matrix 객체를 생성할 때, 이 생성자를 호출하여 행렬을 초기화할 수 있습니다.
예를 들어, Matrix B = new Matrix(3,4);와 같이 생성자를 호출하면 3행 4열의 행렬이 초기화되어 생성됩니다.*/

/*해당 생성자에서의 this는 현재 객체를 가리키는 키워드입니다.
자바에서 this는 인스턴스 메소드나 생성자 내에서 사용되며, 해당 메소드나 생성자를 호출한 객체를 가리킵니다.
즉, this는 현재 메소드나 생성자가 속한 객체를 참조합니다.
따라서 this.rows와 this.cols는 생성자가 호출된 객체의 rows와 cols 필드를 가리킵니다.
이렇게 하면 생성자 내에서 현재 객체의 상태를 초기화할 수 있습니다.*/

   void getData() {
      // 난수로 입력

      Random rnd = new Random();//랜덤클래스 임포트 3번줄

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
      Matrix Result = new Matrix(this.rows, Input.cols);
      for (int i = 0; i < Result.rows; i++) {
         for(int j = 0; j < Input.cols; j++) {
            int sum = 0;
            for(int k = 0; k < this.cols; k++) {
               sum += this.data[i * this.cols + k]* Input.data[k * Input.cols + j];
            }
            Result.data[i * Input.cols + j] = sum;
         }
      }
      return Result;
   }
   //this는 현재 객체를 가리키는 키워드임
   //여기서 this 키워드는 Matrix 클래스의 객체를 가리킴
   //이 멀티플라이매트릭스 메소드는 Matrix 클래스에 속해있으므로, 
   //이 메소드의 this는 이 행렬곱셈메소드가 호출된 Matrix 객체를 참조하게 됨

   Matrix transposeMatrix() {//다시 복습
      Matrix result = new Matrix(this.cols, this.rows);
      for (int i = 0; i < this.rows; i++) {
         for (int j = 0; j < this.cols; j++) {
            result.data[j * this.rows + i] = this.data[i * this.cols + j];
         }
      }
      return result;
   }

   void showMatrix(String str) {//다시 복습
      for (int i = 0; i < this.rows; i++) {
         for (int j = 0; j < this.cols; j++) {
            System.out.print(this.data[i * this.cols + j] + " ");
         }
         System.out.println("\n");
      }
      System.out.println();
   }
   //         int[] data1 = this.data;
   //               for(int i = 1; i <= data1.length; i++) {
   //                  System.out.print(this.data[i-1] + "  ");
   //                  if (i % this.cols == 0) {
   //                     System.out.println("\n");
   //                  }
   //               }
   //         for (int j = 0; j < this.cols; j++) {//this를 써야B인지C인지A인지
   //            System.out.println(this.data);
   //         }
   //      }
   //      System.out.println(Arrays.toString(this.data));

   //2차원 배열 모양으로 출력하는 코드 작성
}
public class Test_행렬클래스_re {

   public static void main(String[] args) {//메인도 메소드
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
      B.showMatrix("B[3][4]");
      C.showMatrix("C[3][4]");
      A.showMatrix("A[3][4]");

      System.out.println("행렬 곱하기: D[3][5] = B[3][4] * E[4][5]");
      D = B.multiplyMatrix(E);
      B.showMatrix("B[3][4]");
      E.showMatrix("E[4][5]");
      D.showMatrix("D[3][5]");

      System.out.println("행렬 전치: F[4][3] = B[3][4]의 전치 행렬");
      F = B.transposeMatrix();
      B.showMatrix("B[3][4]");
      F.showMatrix("F[4][3]");

   }

}