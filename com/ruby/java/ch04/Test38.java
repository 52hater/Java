package com.ruby.java.ch04;

public class Test38 {

	public static void main(String[] args) {
		
//		int arr [][] = new int[3][4];
//		arr[0][0] = 1;
//		arr[0][1] = 2;
//		System.out.println("행의 수: " + arr.length);//행의 길이
//		System.out.println("열의 수: " + arr[0].length);//열의 길이
//		int arr2[][]= {{1,2},{3,4,7,8,},{5,6}}; //Ragged array : 가능은하지만 많이안씀, 코딩주의필요
		
		int[][] arr = new int[5][5];
		int num = 1;
		for(int i = 0; i <arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num++;
	}
}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
	}
}
