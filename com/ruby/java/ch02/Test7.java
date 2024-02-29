package com.ruby.java.ch02;

public class Test7 {

	public static void main(String[] args) {
		int a = 10;
		int b,c = 0;
		b = ++a;
		c = a++;
		System.out.println("b="+b+", c="+c);
		System.out.println("a="+a);//a가 12가 되는 것을 확인
		//for문과 while문에서 많이 쓰인다.
		//아래는 Test8
		
		boolean result = (b == c);//괄호는 우선순위가 높다는 뜻(연산자 우선순위)
		//자바의 연산자 및 연산자 우선순위(토마의 엔지니어링 노트 참조해서 공부)
		//대입/할당연산자가 제일 우선순위가 낮다 등등 > 괄호를 해도되고 안해도되고 코딩시 우선순위를 구글링으로 찾아서 적용
		
		System.out.println("result="+result);
		//아래는 부호연산자
		
		short e = 10;
		int f= -e;
		//정수형연산자(-e), short은 2바이트니까 치환할떄 4 ->2 >> 에러가 난다.
		//변수에 대한 데이터 타입을 잘 보는 게 중요 > short f를 -> int f = -e;로 바꿔야함
		//아래는 Test10(부정연산자)
		
		boolean isOn = false;
		while(!isOn);
			//반복 실행
			
			//정수>> 이진법 8진법 16진법 기본적으로 공부해놔야함
			
			
	

	}

}
