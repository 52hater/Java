package Practice;

public class Practice1 {
   public static void setMatrix(int[][]matrix) {
      int num = 1;
      for(int i = 0; i < matrix.length; i++) {
         for(int j = 0; j < matrix[i].length; j++) {
            matrix[i][j] = num++;
         }
      }
   }
   public static void printMatrix(int[][] matrix) {
      for(int i = 0; i < matrix.length; i++) {
         for(int j =0; j < matrix[i].length; j++) {
            System.out.print(matrix[i][j] + " ");
         }
         System.out.println();
      }
   }

   public static void multipleMatrix(int[][] A, int[][] B) {

      int[][] C = new int[A.length][B[0].length];

      for (int i = 0; i < A.length; i++) {
         for (int j = 0; j < B[0].length; j++) {
            for (int k = 0; k < A[0].length; k++) {
               C[i][j] += A[i][k] * B[k][j];
            }
         }
      }

      System.out.println("A 행렬과 B 행렬의 곱셈 결과:");
      printMatrix(C);//이게 여기서 이렇게 있을 줄은 몰랐다
   }

   public static void main(String[] args) {
      
      int[][] A = new int[4][3];
      setMatrix(A);

      int[][] B = new int[3][4];
      setMatrix(B);

      System.out.println("A 행렬:");
      printMatrix(A);

      System.out.println("B 행렬:");
      printMatrix(B);
      
      multipleMatrix(A, B);
   }
}