package com.ruby.java.ch06;

class Count{
	public static int totalCount;
	int count;
}

public class CountTest {
	public static void main(String[] args) {
	Count c1 = new Count();
	Count c2 = new Count();
	Count c3 = new Count();
	
	c1.count++;
	Count.totalCount++;
	c2.count++;
	Count.totalCount++;
	c3.count++;//자기변수카운트값1증가
	Count.totalCount++;//스태틱; 클래스변수가 1증가
	
	System.out.println(Count.totalCount + " : " + c1.count);
	System.out.println(Count.totalCount + " : " + c2.count);
	System.out.println(Count.totalCount + " : " + c3.count);
	
	}
}
