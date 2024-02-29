package com.ruby.java.ch09;
/*
 * ==, s1.equals(s2) //이 두개 차이를 공부하는 것이 목표
 * S1==S3 / S2==S4 이거 보는 것
 */
public class Test02 {

	public static void main(String[] args) {

		String s1 = new String("java");//heap에 객체 생성,
		String s3 = new String("java");//내용은 자바로 같지만 메모리 공간할당이 따로임 즉 S1 != S3
		String s2 = "java";//컴파일러가 static 영역에 데이터 생성한 후에 참조
		String s4 = "java";//근데 S2 == S4 맞음
		//스트링은 클래스 > 변수면 참조변수 > 참조변수면 메모리주소를 가리킴
		//인티저처럼 s4의 값이 Java가 아니라 메모리주소
		//int n/String s2 //n과 s2의 공통점 : 로컬변수, 스택영역/차이점 : 참조변수는 주솟값이지 해당 값을 가진 게 아님
		//그러면 상수값 자바는 어디저장? > 데이터영역 > 그 상수의 주소를 참조변수 s2가 가리킨다는 것(java의 메모리주소)
		//근데 상수값 자바는 데이터영역에 한 집에 있어, 자바컴파일러는 같은 상수가 여러번 나오면 한번만 표현(최적화 optimization)
		//메모리 공간 절약도 최적화, 참조변수 s2, s4는 같은 상수값 Java의 주솟값을 가리킴 따라서 S2 == S4 true

		System.out.println(System.identityHashCode(s1)+":" + System.identityHashCode(s3));//해시코드를 찍었더니 같은 값
		System.out.println(s1 + " : "+ s3.toString());
		System.out.println(s2.hashCode()+":" + s4.hashCode());//해시코드를 찍었더니 같은 값
		if (s1 == s3) {			
			System.out.println("s1 == s3::동일 객체이다.");
		} else {
			System.out.println("s1 == s3::다른 객체이다.");
		}
		
		System.out.println(System.identityHashCode(s2)+":" + System.identityHashCode(s4));//같은 값
		System.out.println(s2.hashCode()+":" + s4.hashCode());//같은 값
		if (s2 == s4) {
			System.out.println("s2 == s4::동일 객체이다.");
		} else {
			System.out.println("s2 == s4::다른 객체이다.");
		}
		//s1.해서 이퀄스 보면 클래스가 오브젝트가 아니라 스트링으로 되어있음 > 객체식별X, 그냥 문자열값이 같냐//로 재정의 되어있다
		//이퀄스 오브젝트는 객체식별자였는데 여기는 오버라이딩으로 스트링클래스에서 재정의 되어있는 것
		//항상 메소드가 어디서 정의된 것이 실행되는지를 확인하는게 중요
		
		if (s1.equals(s3)) {//Object의 equal()를 overriding - hash code가 아닌 값으로 비교하도록 String class에서 재정의한 것
			System.out.println("s1.equals(s3)::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1.equals(s3)::다른 문자열을 가집니다.");
		}
		if (s1 == s2) {//Object의 equal()를 overriding - hash code가 아닌 값으로 비교하도록 String class에서 재정의한 것
			System.out.println("s1 ==s2 ::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1 != s2::다른 문자열을 가집니다.");
		}
		if (s1 == s2) {//Object의 equal()를 overriding - hash code가 아닌 값으로 비교하도록 String class에서 재정의한 것
			System.out.println("s1 ==s2 ::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1 != s2::다른 문자열을 가집니다.");
		}
		if (s2 == s4) {//Object의 equal()를 overriding - hash code가 아닌 값으로 비교하도록 String class에서 재정의한 것
			System.out.println("s2 == s4 ::동일 문자열을 가집니다.");
		} else {
			System.out.println("s2 != s4::다른 문자열을 가집니다.");
		}
		if (s2.equals(s4)) {
			System.out.println("s2.equals(s4)::동일 문자열을 가집니다.");
		} else {
			System.out.println("s2.equals(s4)::다른 문자열을 가집니다.");
		}
		if (s1.equals(s4)) {
			System.out.println("s1.equals(s4)::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1.equals(s4)::다른 문자열을 가집니다.");
		}

		System.out.println("s1 = " + s1 + ", s2 = " + s2);
		String s5 = "JAVA";

		if (s1.equals(s5)) {
			System.out.println("s1.equals(s5)::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1.equals(s5)::다른 문자열을 가집니다.");
		}

		if (s1.equalsIgnoreCase(s5)) {
			System.out.println("s1.equalsIgnoreCase(s5)::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1.equalsIgnoreCase(s5)::다른 문자열을 가집니다.");
		}
		System.out.println(s1);//객체식별자가 아니라 스트링값 java를 출력함
		System.out.println(s2);//오브젝트클래스에서 정의된 메소드가 아니라
		System.out.println(s3);//스트링클래스에서 재정의된 메소드
		System.out.println(s4);
	}
}