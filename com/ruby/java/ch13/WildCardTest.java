package com.ruby.java.ch13;

import java.util.Arrays;
import java.util.List;

public class WildCardTest {
	
	public static void main(String[] args) {
		Integer[] inum = { 1, 2, 3, 4, 5 };
		Double[] dnum = { 1.0, 2.0, 3.0, 4.0, 5.0 };
		String[] snum = { "1", "2", "3", "4", "5" };
		
		List<Integer> iList = Arrays.asList(inum);
		List<Double> dList = Arrays.asList(dnum);
		List<String> sList = Arrays.asList(snum);
		//인스턴스없이 메소드를 바로 호출할 수 있는 이유는 스태틱메소드이기때문
		
		double isum = sum(iList);
		double dsum = sum(dList);
		//sum(sList);//파라미터 파일이 넘버로부터 상속받은 클래스만 메소드실행가능
		//snum은 스트링으로부터 상속받은 클래스
		//억지로라도 실행을 하고싶으면?
		// extends Number를 지우고 (List<?> list)로
		
		System.out.println("inum의 합계 : " + isum);
		System.out.println("dnum의 합계 : " + dsum);
	}
	
	public static double sum(List<? extends Number> list) {
		double total = 0;
		for(Number v : list) {
			total += v.doubleValue();
		}
		return total;
	}

}
