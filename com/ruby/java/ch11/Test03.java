package com.ruby.java.ch11;

import java.io.FileInputStream;
import java.io.IOException;

public class Test03 {

	public static void main(String[] args) {

		try(
			FileInputStream fi = new FileInputStream("a.txt")) {//파일 이름바꿔서 실행해보고 오류확인
			int c = fi.read();//.reads > 한글자 읽어서 정수로 반환//이게 한번 읽은거라서 H출력이 안됨
			// = fi.read()를 빼고 int c; 선언만 하면 H출력
			while((c = fi.read()) != -1) {//아스키코드
				System.out.print(c);
				System.out.print(",");
				System.out.println((char) c);//캐릭터 타입캐스팅
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
//근데 형식상 뭐가 다른거지 > 그냥 finally 쓰고 fi.close 쓰는 걸 생략해도 되도록 만든 기능인건지?