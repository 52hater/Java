package com.ruby.java.ch14;

interface Calculator {
	int func();
}

public class Test09 {
	
	static int num1 = 10;
	int num2 = 20;
	
	public static void main(String[] args) {
		Test09 test = new Test09();
		int num3 = 30;
		
		Calculator calc = () -> {
			int num4 = 40;
			Test09.num1++; //스태틱필드니까 쓸 수 있고
			test.num2++;//테스트도 값을 수정을 못하는데 테스트에 있는 필드는 수정이 가능
			//테스트09 객체를 만들어서 객체를 할당하려하면 할당을 못함
			//왜냐하면 테스트를 수정하려했기때문에
			//test = new Test09(); < 이렇게 하면 이것도 오류
			//또 다른값으로 할당하는건 안되는데 테스트안에있는 필드값을 변경하는건 가능
			//값을 변경할 수 없는데 변경해야하는경우에 이런걸 생각해야된대
			//람다식이 포함되어있는 블록에 있는 변수들은 참조하고 읽을수는 있는데 수정은 못함
			//>final 이 붙은것처럼 사용함
			num3++; //오류발생//변수에있는 값을 수정을 못해 이 안에서는
			num4++; //자기블럭에 있는 변수는 상관없지
			return num4;
		};
	}

}
