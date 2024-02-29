package com.ruby.java.ch04;

public class Test32 {

	public static void main(String[] args) {
		int[]score;//score=참조변수 / 시작주소공부해
		score = new int[]{1,2,3,4,5};//[]안에 5넣으면 에러 > 초기화할때는 5쓰지말라는것
		//(자바 컴파일러가 알아서 할테니까 니가 초기화하지마라)
		
		int num = score.length;
		System.out.println("num = "+ num); //위에 {}안에 숫자 추가해서 돌려봐
		String str = "nice day";
		int snum = str.length();
		
		int[] arr = new int[5];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		System.out.println(arr.length);
		for(int i = 0; i < arr.length; i++)//<= 등호붙이면 아웃오브바운드151page
			System.out.println(arr[i]);
	}
}
		
		
		//arr.length;

//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println(arr[3]);
//		System.out.println(arr[4]);