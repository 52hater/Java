package com.ruby.java.ch04;

public class Test36 {

	public static void main(String[] args) {
		char letter = 'A';
		int num = 'A';
		System.out.println("num = " + num);	//A를 찍어봤더니 65나옴>+i>66(B),67(C),~유니코드값
		char[] alphabet = new char[26];	//new:공간할당 명령어
		
		for(int i = 0; i < alphabet.length; i++) {
			alphabet[i] = (char) (letter + i);	//레터는 char로 선언/i는 정수 >A가 어떻게 숫자로 바뀌냐(위에확인)
		//type casting / char:explicit casting, letter:implicit casting
		//explicit casting > 코딩짠사람의 의도가 나타나는,, implicit casting 지양하래
		//letter에 괄호를 안하게 되면 타입미스매치 에러뜸>인티저를 캐릭터로 변환할수가 없대
		//(char)letter부터 먼저해>정수를 문자로 하려니까 에러가 난다(??)
		//레터+i에 괄호가 있으면 레터는 문자>정수로 받고 
		//+i>정수 > char>캐릭터로 explicit type casting(4바이트를 1바이트로 바꾸는거지 그건ok)
		//4바이트짜리를 1바이트짜리의 값으로 정보손실이 없게끔 캐릭터로 바꿈
		//데이터타입이 오류의 주범 중 하나
		
		
		}
		for(char c : alphabet) {
			System.out.println(c);
		}

	}

}
