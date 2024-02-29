package com.ruby.java.ch05;

public class b203pParameter {
	public static void main(String[] args) {
		
		System.out.println("1");//일단 1이 먼저 출력
		
		String num = takeoff("mark1", "mark2"); 
		//여기서 int num이 아니라 스트링을 쓰는건 참조타입이라서? 아니면 takeoff();땜에?
		//takeoff라는 메소드가 리턴하는 값을 num에 저장(먼저 takeoff메소드본문으로 가서 takeoff출력 후
		//리턴값을 가지고 돌아와서(리턴값 100을)takeoff num에 리턴값을 넣고 100이 출력,,
		//그 이후에 쭉 내려가서 2 출력
		System.out.println(num);
		
	//	System.out.println(takeoff());
		
		System.out.println("2");
	}
	static String takeoff(String name1, String name2) {//mark1을 name이라는 스트링변수에서 받는다
		//mark1말고 예를들어 6이면 int name이 되겠지
		System.out.println("takeoff");
		
		//int String long boolean char
		
		return name1 + " ===> " + name2;
		//리턴값을 지우려면?
		//리턴값을 지우면 static String에서 오류가 남 리턴값이 없는데 왜 형식이 그렇냐는거지
		//그래서 String을 지우고 void > 이거 책 201페이지에 내용있음
		//그러면 저 위에 String num쪽에서 오류가 남 void인데 왜 숫자를 넣냐는거지
		//String num = 을 지우고 takeoff();
		//그리고 그 밑에 num출력라인도 지워
		//그러면 출력값이 1 takeoff 2가 나오지
	}
}
