package com.ruby.java.ch11;

public class Test01_4 {
	public static void main(String[] args) {
		test1();//test1호출
		System.out.println("Good");
	}

	private static void test1() {
		System.out.println("test1 start");
		test2();
		System.out.println("test1 end");
	}

	private static void test2() {
		System.out.println("test2 start");
		try {
			int temp = 10/0;//디버깅해보면 여기서 오류나는 순간 25번줄로 점프
			int arr[] = new int[3];
			arr[3] = 30; //new ArrayIndexOutOfBoundsException()
			System.out.println("OK");
		} catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		} catch (Exception e) {//모든 예외의 최상위 클래스 /할당할 수 없으면 이쪽으로 오게 됨
			//이 코드에서는 int temp = 10/0; 얼스메틱익셉션이라서 여기로 옴
			System.out.println("오류 발생 : " + e);
		}
		System.out.println("test2 end");
	}
}
