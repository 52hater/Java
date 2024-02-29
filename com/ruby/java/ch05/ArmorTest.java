package com.ruby.java.ch05;

class Armor {

	private String name = "홍길동";
	public int height = 180;
	private int weight = 100;
	private String color = "Red";
	
	private void takeOff() {
		System.out.println("Take off");
	}
	private void land() {
		System.out.println("Land");
	}
	private void shootLaser() {
		System.out.println("Shoot Laser");
	}
}

public class ArmorTest {
	public static void main(String[] args) {
		Armor armor = new Armor();
		
	}
	
}