package com.ruby.java.ch13.boundGen;

class Bag<T extends Solid> {
	private T thing;

	public Bag(T thing) {
		this.thing = thing;
	}

	public T getThing() {
		return thing;
	}

	public void setThing(T thing) {
		this.thing = thing;
	}

	void showType() {
		System.out.println("T의 타입은" + thing.getClass().getName());
	}
}

class Solid {}
class Liquid {}

class Book extends Solid {}
class PencilCase extends Solid {}
class Notebook extends Solid {}

class Water extends Liquid {}
class Coffee extends Liquid {}

public class BagTest {

	public static void main(String[] args) {
		Bag<Book> bag = new Bag<>(new Book());
		Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
		Bag<Notebook> bag3 = new Bag<>(new Notebook());
		
		Bag<Water> bag4 = new Bag<>(new Water());
		Bag<Coffee> bag5 = new Bag<>(new Coffee());
		//Liquid 클래스를 상속받아서 못들어가기 때문에 오류(타입 매개변수 제한)


		bag.showType();
		bag2.showType();
		bag3.showType();
		
//		Bag<Book> bag = new Bag<>(); //기본 생성자가 없어서
//		bag.setThing(new Book());
//		bag.showType();
//		
	}
}