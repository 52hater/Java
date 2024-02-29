package com.ruby.java.ch13.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) //어노테이션 적용범위를 실행시에도 유지되게
//@Check 어노테이션 선언
@interface Check {
	String name();
	int val();
}

public class AnnoTest {
	@Check(name = "first", val = 123)
	public static void test() {
		AnnoTest obj = new AnnoTest();
		try {
			Class<?> c = obj.getClass();
			Method m = c.getMethod("test");
			
			Check check = m.getAnnotation(Check.class);
			System.out.println(check.name() + " : " + check.val());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		test();//실행되는 시점에 테스트메소드 호출
	}

}
