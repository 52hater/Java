package com.ruby.java.ch09;

import java.util.Arrays;
//메인에서는 함수호출만하고 for문 돌리지마.
//메인은 테스트하는 용도, 변수선언만하고 
public class Test12 {
	static void showData(String[]arr) {
		System.out.println();
		for (String st: arr)
			System.out.print(st + " -> ");
	}
	static void sortData(String[]arr, int[]arrInt) {//int[]arrInt는 밑에서 변경되고 그담에 정렬도되고
		for (int i = 0; i< arr.length;i++)
		{
			arrInt[i] = Integer.parseInt(arr[i]);//parseInt : arrInt[i]의 문자열을 정수로 변경>메인에서도 변경이 됨
			//참조변수  arrInt[] 이것이 변경이 되면 메인에서도 변경된 값을 접근, 사용함
			//참조변수로 전달됐고 참조변수는 주소가 있어서 파스인트로 바꾸고 어레이로 정렬이 된 것이 변경이 됨
			//참조변수를 사용해서 함수에서 호출된 형태에서 변경을 했기때문에 정수가 출력이 되는 것
		}
		Arrays.sort(arrInt);//정렬해주고
		//참조변수  arrInt[] 이것이 변경이 되면 메인에서도 변경된 값을 접근, 사용함
	}
	static void showNumber(int[]arr) {
		System.out.println();
		for (int n: arr)
			System.out.print(n + " -> ");
	}
	public static void main(String[] args) {
		// string 정렬의 문제 
		String arr[] = {"12", "9", "22", "5"};
		showData(arr);//스트링으로 정렬 : 12 22 5 9 순으로 나옴
		//스트링으로 정렬>첫번째문자가지고 정렬(문자열로 정렬하니까)
		//만약에 12 291 135 25로 있다면
		//12 135 25 291 순으로 나옴
		//아래의 파스인티저가 문자열20을 정수20으로 바꿔줌
		Arrays.sort(arr);//정렬, 어래이 클래스를 이용해서 정렬
		showData(arr);//
		
		int n1 = 10;
		Integer obj1 = n1; // Integer.valueOf(n1)//정수변수 n1, 10;
		//obj1:참조변수 , 정수를 객체로 변경하기위해 '박싱'428p
		//Integer obj1 = Integer.valueof(n);//클래스.메소드(n);
		//정수변수n을 박싱하는 메소드 valueof
		//자바컴파일러가 자동으로 박싱해줌
		//Integer obj1 = n1;우리는 이렇게 썼지만 
		//자바에서 자동으로 Integer.valueOf(n1)이렇게 정수객체로 박싱해줌
		//벨류오브 메소드는 정수변수를 정수객체로 박싱(바꿔줘)
		//우리가 일일이 안해도 자바가 Integer.valueof(n);이거 불러서 자동으로 바꿔줌
		//Integer > Wrapper 클래스라고 부르자(Integer,Double등 대문자로 시작하는)
		//obj1.* - methods를 사용하기 위해
		
		Integer obj2 = Integer.parseInt("20");// "9", "12" 정렬시에는 12,9가 온다 이때 필요
		//파스인티저가 문자열20을 정수20으로 바꿔줌
		int n2 = obj2; // obj2.intValue()
		//obj2.hashCode();
		
		Integer obj3 = 30; // new Integer(30)

		int n3 = obj3 + 40;

		System.out.println("\n" + n1 + " : " + obj1);
		System.out.println(obj2 + " : " + n2);
		System.out.println(n3);
		//정수로 배열로 변환후 정렬 
		int []arrInt = new int[arr.length];
		sortData(arr, arrInt);
		showNumber(arrInt);
		//스트링의 데이타를 정수형데이터로 바꿔서 출력하라는 것
	}
}