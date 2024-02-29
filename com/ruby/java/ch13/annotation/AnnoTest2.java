package com.ruby.java.ch13.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
//Import -> ctrl+shift+o

@Retention(RetentionPolicy.RUNTIME) //어노테이션 적용범위를 실행시에도 유지되게
//@Check 어노테이션 선언
@interface Mapping {
	String mode();
	int value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Comment {
	String msg();
}

@Mapping(mode = "class", value = 100)//어디붙어있는애인지를 보고 띄어쓰기
@Comment(msg = "Annotation2 클래스")
public class AnnoTest2 {

	@Mapping(mode = "Method", value = 200)//어디붙어있는애인지를 보고 띄어쓰기
	@Comment(msg = "test() 메서드")
	public static void test() {
		AnnoTest2 obj = new AnnoTest2();
		try {
			Class<?> c = obj.getClass();
			Annotation annoList[] = c.getAnnotations();
			System.out.println("클래스의 annotation 목록");
			for(Annotation item : annoList)
				System.out.println(item);


			Method m = c.getMethod("test");
			annoList = m.getAnnotations();
			System.out.println();
			System.out.println("test()메서드의 annotation 목록");
			for(Annotation item : annoList)
				System.out.println(item);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		test();//실행되는 시점에 테스트메소드 호출
	}

}
