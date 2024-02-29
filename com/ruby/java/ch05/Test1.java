package com.ruby.java.ch05;

public class Test1 {
	static void test(int...v) {//v라는 이름의 int형 배열에다 저장을하고
		System.out.print(v.length + " : ");
		for(int x : v)//변수x : 배열v >> 배열의 넘버가 정수이므로 int 한 것
	//for(int x :v){} >> for에서 배웠던 i++ >> v:1,2,3 >> 루프돌렸을때 첨에 1이 x에 들어가고
	//그 다음에 2가 x에 들어가고 3이 x에 들어가고
	//가시적으로 확인 > 디버깅을 해보면 됨
	//확장for이 배열아니라도 각종 플렉션계열은 다 들어갈 수 있음 > 사용하기가 굉장히 용이함
			System.out.print(x + "");
		System.out.println();
	}

	public static void main(String[] args) {
		test(1);
		test(1, 2);
		test(1, 2, 3);
	}
}
