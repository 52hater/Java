package com.ruby.java.ch09;

import java.util.Arrays;

public class Test16 {

	public static void main(String[] args) {
		int score[] = { 85, 90, 95, 100, 75 };//정수배열
		int score2[] = Arrays.copyOf(score, score.length);//어레이이용해서 배열 통째로 복사하는거
		int score3[] = Arrays.copyOfRange(score, 3, 5);//일부를 복사하는 것
		//자바는 기존의 라이브러리에 있는 것을 최대한 많이 사용하는 것이 중요

		int score4[] = new int[score.length];
		System.arraycopy(score, 0, score4, 0, score.length);
		
		//System.out.println(score); 
		//스코어는 참조변수고 내가 스트링을 요구하니까 오브젝트 클래스의 주소를 찍어버려서 안됨

		System.out.println(Arrays.toString(score));//스코어배열을 투스트링으로 바꾸는데
		System.out.println(Arrays.toString(score2));//투스트링이 대괄호 콤마 그런걸 해주는 것.
		System.out.println(Arrays.toString(score3));
		System.out.println(Arrays.toString(score4));

		System.out.println(Arrays.equals(score, score2));//두 배열이 같냐?
		//Arrays는 자바에서 제공하는 클래스고 여러가지 기능이있다, 이런거 있는거 잘 갖다쓰는게 장땡

		Arrays.sort(score);
		System.out.println(Arrays.toString(score));
		System.out.println(Arrays.equals(score, score2));

		int index = Arrays.binarySearch(score, 100);
		System.out.println(index);
	}
}