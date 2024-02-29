
package com.ruby.java.ch09;
class MyObject {
	public MyObject() {}
	@Override // 코드 주석 달기 - 자바 컴파일러에게 알려주는거, 갈아엎을거다(재정의) 상속받은거 무시하고 갈아엎었따
	//오버라이드:재정의 오버로드:같은이름의메소드가 많은(함수명은 같은데 매개변수가 다른 것>다른함수취급, 함수의바디가 다르다)
	//함수를 보고 의미(시멘틱semantic)가 정수냐 실수냐 그런 의미를 실은(show(int n)/show(double d)와같이
	public String toString() {
		return "MyObject";
	}
}
public class Test01 {
	public static void main(String[] args) {
		Object obj1 = new Object();//new>>메모리공간할당, 주소를 반환해서 스택에 있는 변수 local변수 obj123
		Object obj2 = new Object();//얘네 셋이 구분하기 위해서 객체 식별자를 할당함(주민번호, 학번같은)
		Object obj3 = new Object();//객체식별자 : 유니크
		//obj1.hashCode()//해시코드는 정수로 만든다

		System.out.println("obj1.hashCode()=" + obj1.hashCode());//출력이 정수
		System.out.println(Integer.toHexString(obj1.hashCode()));
		//octa 8 hexa 16진법/인티저>클래스>인티저.투헥스 > 스태틱메소드
		
	//int n>n은 로컬변수 /Inteser in = n; 클래스인티저, 아이엔 변수, 인티저:자바라이브러리가 제공하는 클래스,,박싱<-
		//in은 객체, in.method사용가능/결론:정수도인티저객체로 만들어서 메소드 사용할 수 있다
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());

		Class c = obj1.getClass();//오브젝 오브젝1에 정의된
		System.out.println(c.getName());

		System.out.println(obj1);//함수호출, toString() 결과와 같은 이유는 자동적인 타입 캐스팅 때문임// > 정수를 hexa로 변경한 것
		System.out.println(obj1.toString());//매개변수 전달,399 페이지 하단의 클래스 이름이 string//객체식별자를 16진수로 바꿔서 보여주는 것
		//타입이 달라, javac가 String st = obj1.toString();
		//타입이 다르면, 스트링타입으로 바꾼다음에 반환하는데 변수의 클래스 오브젝트에 보니까 .을찍었을떄 보여주는것처럼 
		//투스트링이 있으니까 자동으로 호출
		System.out.println(obj2);//투스트링이 자동으로 여기도 달라붙어서 스트링으로 만듦, 투스트링은 오브젝트클래스의 투스트링
		System.out.println(obj3);//오브젝트투스트링함수는 클래스명에다가 @을 붙이고 식별자를 헥사코드로 해주는 것
		//오브젝트는 루트니까 그냥 찍으면 객체식별자가 나온다@~~~어쩌고로

		MyObject obj4 = new MyObject();
		System.out.println("MyObject출력 : " + obj4);
		MyObject obj5 = new MyObject();
		//obj4.equals(obj5) //MyObject의 equals()가 실행됨/.찍고 정의된 클래스를 봐, =오브젝트
		if (obj4.equals(obj5)) {//hashcode가 다르면 다른 객체로 본다 -기준은 hashcode를 갖고 판단한다
			System.out.println("동일 객체이다.");//MyObject 클래스에서 equals()를 재정의한 경우
		} else {
			System.out.println("다른 객체이다.");//Object의 equal() 사용시에는, 403페이지 내용 
		}
		System.out.println(obj4.hashCode() + ":" + obj5.hashCode());
		if (obj4 == obj5) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		System.out.println("obj4 = " + obj4);
		MyObject mo2 = new MyObject();//402페이지의 toString() 오버라이딩
		System.out.println(mo2);
	}
}