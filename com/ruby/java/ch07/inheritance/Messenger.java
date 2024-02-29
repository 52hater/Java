package com.ruby.java.ch07.inheritance;

public interface Messenger {
	
	public static final int MIN_SIZE = 1;
	public static final int MAX_SIZE = 104857600;
	
	public abstract String getMessage();//구현을 해야되기때문에 오버라이드로 나옴
	
	public abstract void setMessage(String msg);//구현을 해야되기때문에 오버라이드로 나옴
	
	public default void setLogin(boolean login) {//디폴트로 모든클래스에서 쓸 수 있도록 하겠다는 것
		log();
		if(login) {
			System.out.println("로그인 처리합니다.");
		} else {
			System.out.println("로그아웃 처리합니다.");
		}
	}

	public static void getConnection() {
		System.out.println("network에 연결합니다.");
	}
	
	private void log() {
		System.out.println("start job!");
	}
}
