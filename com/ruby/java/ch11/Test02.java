package com.ruby.java.ch11;

public class Test02 {

	public static void main(String[] args) {
		try {
			String s = new String("java");
			int len = s.length();
			s = null;
			s.length();
			
			int arr[] = new int[3];
			arr[3] = 30;
			
			int temp = 10/0;
			
			System.out.println("1");
			System.out.println("2");
			System.out.println("3");
		} catch(Exception e) {
			System.out.println("오류 발생");
			return;//원래대로라면 OK도 찍히면 안되는데 finally 때문에 OK출력을 하고나서 끝
			//return;받고 어디로??//finally 때문에 OK출력 하고나서 리턴을 받는건 이해함
		} finally {
			System.out.println("OK");
		}
		System.out.println("4");
	}

}
