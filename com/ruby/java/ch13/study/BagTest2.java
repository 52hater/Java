package com.ruby.java.ch13.study;

class Bag {
	
	private Object thing;

	public Bag(Object thing) {
		this.thing = thing;
	}

	public Object getThing() {
		return thing;
	}

	public void setThing(Object thing) {
		this.thing = thing;
	}

	void showType() {
		System.out.println("Object의 타입은 " + thing.getClass().getName());
	}
}

class Book{}
class PencilCase{}
class NoteBook{}

public class BagTest2 {

	public static void main(String[] args) {
		Bag bag = new Bag(new Book());
		Bag bag2 = new Bag(new PencilCase());
		Bag bag3 = new Bag(new NoteBook());

		bag.showType();
		bag2.showType();
		bag3.showType();
		
		bag = bag2;//실제로 내용이 다르잖아 근데 타입이 오브젝트라서 오류가 안뜸
		//안정성이 떨어짐//제너릭으로

	}

}
