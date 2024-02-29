package com.ruby.java.ch09;
//iterator 개념 실습 
import java.util.StringTokenizer;
//토큰:변수나 연산자나 어떤 숫자의 단위
//10장의 iterator과 밀접한 관련이 있음

public class Test14 {
	public static void main(String[] args) {

		String msg = "Although the world is full of suffering, it is full also of the overcoming of it.";
		//예를들어 a=10, b=20, c=30이 있다
		//그러면 뭐 토큰을 a=10은 토큰 ,는 separator 그런식으로 쓸 수도있고
		//=도 separator로 쓸래 그럴 수도 있는 듯?
		StringTokenizer st1 = new StringTokenizer(msg);//StringTokenizer클래스
		System.out.println("단어 수 : " + st1.countTokens());//st1 이라는 객체가 토큰들을 가지고있고
		while (st1.hasMoreTokens()) {//hasMoreTokens Although, the, world 등 토큰들
			System.out.print(st1.nextToken() + " + " );//하나씩 끄집어내라 > 넥스트토큰
			//st1.nextToken()
		}
		StringTokenizer st11 = new StringTokenizer(msg, ",. ");//세퍼레이터를 콤마와 쩜과 블랭크로 한다는 것.
		//여기서 블랭크를 지워서 없애면 콤마와 마침표만으로 하니까 토큰수(단어수)가 줄어들지
		//분리자를 지정할 수 있다.
		System.out.println("단어 수 : " + st11.countTokens());
		while (st11.hasMoreTokens()) {
			System.out.print(st11.nextToken() + " + " );
		}
		System.out.println("\n================");
		String s = "id=guest&name=Amy&pwd=1004"; 
		StringTokenizer st2 = new StringTokenizer(s, "&");// 분리자를 &로 함
		while (st2.hasMoreTokens()) {
			System.out.println("남아있는 토큰 수 : " + st2.countTokens());
			System.out.println(st2.nextToken());
		}

		System.out.println("================");
		StringTokenizer st3 = new StringTokenizer(s, "=&");
		while (st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());//해즈모어토큰, 넥스트토큰 공부(자바코딩에서 기본)
		}
	}
}