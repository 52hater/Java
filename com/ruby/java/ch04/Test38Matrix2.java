package com.ruby.java.ch04;

import java.util.Random;

public class Test38Matrix2 {
    public static void main(String[] args) {
        Random rnd1 = new Random();
        int A[][] = new int[3][4]; // 행렬 A의 선언과 난수 입력
        int B[][] = new int[4][5]; // 행렬 B의 선언과 난수 입력
        int D[][] = new int[3][4]; // 행렬 D에도 난수 입력

        // A 행렬에 난수 입력
        System.out.println("A" + "\n");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] = rnd1.nextInt(10);
                System.out.print(A[i][j] + "\t");
            }
            System.out.println("\n"); // 다음 행으로 넘어감
            //n과 t를 어디다가 입력하면 어떤식으로 작동하는지 하나하나 다시 해보면서 복습
        }
      
        // B 행렬에 난수 입력
        System.out.println("B" + "\n");
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                B[i][j] = rnd1.nextInt(10);
                System.out.print(B[i][j] + "\t");
            }
            System.out.println("\n"); // 다음 행으로 넘어감
        }
        System.out.println();
        
        // D 행렬에 난수 입력
        System.out.println("D" + "\n");
        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < D[0].length; j++) {
                D[i][j] = rnd1.nextInt(10);
                System.out.print(D[i][j] + "\t");
            }
            System.out.println("\n"); // 다음 행으로 넘어감
        }
        System.out.println();

        // C = A * B (행렬 곱셈)
        int[][] C = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }//a+=b : a=a+b
            }
        }

        // C 행렬 출력
        System.out.println("C" + "\n");
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[0].length; j++) {
                System.out.print(C[i][j] + "\t");
            }
            System.out.println("\n"); // 다음 행으로 넘어감
        }
        System.out.println();
        
      //E = A + D;//행렬 더하기
        int[][] E = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                E[i][j] = A[i][j] + D[i][j];
            }
        }

        // E 행렬 출력
        System.out.println("E" + "\n");
        for (int i = 0; i < E.length; i++) {
            for (int j = 0; j < E[0].length; j++) {
                System.out.print(E[i][j] + "\t");
            }
            System.out.println("\n"); // 다음 행으로 넘어감
        }
        System.out.println("\n");
        
        // F = A의 전치 행렬
        int[][] F = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                F[j][i] = A[i][j];
            }
        }

        // F 행렬 출력
        System.out.println("F" + "\n");
        for (int i = 0; i < F.length; i++) {
            for (int j = 0; j < F[0].length; j++) {
                System.out.print(F[i][j] + "\t");
            }
            System.out.println("\n"); // 다음 행으로 넘어감
        }
        System.out.println("\n");
    }
}