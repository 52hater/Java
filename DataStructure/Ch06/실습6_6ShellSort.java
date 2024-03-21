package DataStructure.Ch06;

import java.util.Random;

//셸 정렬(버전 1) 6-5
//https://travelbeeee.tistory.com/215

import java.util.Scanner;

class 실습6_6ShellSort {
 //--- 셸 정렬 ---//
 static void shellSort(int[] a, int n) {
	 int count = 0;
	 //h 를 사용해서 대략정렬 : h = 4,2,1에 대하여 반복
     for (int h = n / 2; h > 0; h /= 2)//n = 8 등 짝수일 때 4,2 등으로 효과가 적다//8개의 배열이면 4>2>1로 가는거지
         for (int i = h; i < n; i++) {//i 는 4,5,6 등에 대하여 반복
        	 //아래는 insertionSort 소스코드
             int j;
             int tmp = a[i];
             //h 가 2면 7,3,8,4 를 반복하는 for 문 교재 219
             //j = 0, 2, 4, 6 등으로 반복(인덱스)
             //각 for 루프가 의미하는 바를 주석으로 달고 설명까지 할 수 있도록
             for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
            	 count++;
                 a[j + h] = a[j];
             }
             a[j + h] = tmp;
             //insertionSort와 코드 같은데 for (int h = n / 2; h > 0; h /= 2) 추가
             //하나씩 하지말고 4칸씩 2칸씩 그런식으로 하자는 아이디어를 추가한 것
         }
     System.out.println("\n비교횟수 = " + count);
     //인설션 정렬에 비해서도 성능대폭향상
     //버블은 O(n스퀘어) > n이 1000이면 십억번
     //셸은 O(n 1.25스퀘어) > 성능대폭향상
 }
 static void showData(int[] d) {
     for (int i = 0; i < d.length; i++)
         System.out.print(d[i] + " ");
 }
 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.println("셸 정렬(버전 1)");
     System.out.print("요솟수: ");
     int nx = stdIn.nextInt();
   
     int[] x = new int[nx];
     
     Random rand = new Random();

     for (int i = 0; i < nx; i++) {
    	x[i] = rand.nextInt(999);
     }
     System.out.println("정렬전:");
     showData(x);

     shellSort(x, nx);            // 배열 x를 셸정렬
     System.out.println("정렬후:");
     showData(x);
  

 
 }
}
