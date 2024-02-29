package com.ruby.java.ch04;

public class Test35 {

	public static void main(String[] args) {
		String []st = {"apple", "peach", "pineapple"};
		for(String stx: st)
			System.out.println(stx);			//스트링일경우
		
		int[]arr = {10,20,30,40,50};
		for(int i = 0; i < 3; i++) //3개만 출력할거야//여기서 int 빼먹는 실수많이함>i라는 변수의 변수선언이없어
									//윗줄에 int i;를 적으면 선언을 했네 근데 그러면 변수의 범위가
									//for문 한정이 아니라 끝까지 적용 됨
									//여튼 선언이 두개면 안되고 만약에 둘 다 있으면 for문 내부i(로컬변수)를 j로 바꿔주든지
									//블럭내부의 로컬변수(local variable) / global variable
			
			System.out.println(arr[i]);
		
		for(int num : arr) {			//확장형 for문(for문:반복)= 배열의 모든 원소를 출력하고자 할 때
			//num:처음부터 끝까지			//배열원소모두출력+인덱스(위치정보)사용이필요하지않을떄=확장형for문 (암기해)
			System.out.println(num);	//위에거보다는 간결한 코딩
										//인덱스:a[i] > i=인덱스,:데이터가 나열된 순번을 나타내는 위치정보
		}

	}

}
