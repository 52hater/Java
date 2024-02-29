package com.ruby.java.ch11;

public class Test05_2 {//메인에서 트라이캐치로 싸게 바꾼 것

	int battery = 0;

	public void charge(int time) throws Exception {

		if(time < 0) {
			time = 0;
			
			throw new NagativeNumberException("마이너스는 안돼");//익셉션을 타고 메인으로
			//객체 생성해서 던져버렸음 > 익셉션을 타고	
			//NagativeNumberException.java에서 주석처리한거를
			///*"마이너스는 안돼"*/ 이렇게 해도 나오도록
			//NagativeNumberException();면 "음수는 허용하지 않습니다."로 나오고
			//NagativeNumberException("마이너스는 안돼"); 안에 내용물 적으면 내용물로 출력되고
		}
		battery += time;
		System.out.println("현재 배터리 : " + battery);

	}

	public static void main(String[] args) {
		
		Test05_2 test = new Test05_2();
		try {//안던지고 트라이캐치로 싸버리면
		test.charge(30);
		test.charge(20);
		test.charge(-10);//이 시점에서 예외발생
	} catch(Exception e) {//캐치를타고
		System.out.println(e.getMessage());//겟메시지
		}

	}
	
}
