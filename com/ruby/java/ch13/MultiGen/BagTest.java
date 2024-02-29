package com.ruby.java.ch13.MultiGen;

class Bag<T, V> {
	private T thing;
	private V name;

	public Bag(T thing, V name) {
		this.thing = thing;
		this.name = name;
	}

	public T getThing() {
		return thing;
	}

	public void setThing(T thing) {
		this.thing = thing;
	}
	
	public V getName() {
		return name;
	}
	
	public void setName(V name) {
		this.name = name;
	}

	void showType() {
		System.out.println("T의 타입은" + thing.getClass().getName());
		System.out.println("V의 타입은" + name.getClass().getName());
	}
}

class Book {
	public String toString() {
		return "책";
	}
}
class PencilCase{}
class Notebook{}

public class BagTest {

	public static void main(String[] args) {
		
//		Bag<Book, PencilCase> bag = new Bag<>(new Book(), new PencilCase);
		//이렇게도 된다는데
		Bag<Book, String> bag = new Bag<Book, String>(new Book(), "과학");
		
//		Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
//		Bag<Notebook> bag3 = new Bag<>(new Notebook());


		bag.showType();
//		bag2.showType();
//		bag3.showType();
		
		Book book = bag.getThing();
		String name = bag.getName();
		
		System.out.println("Thing is : " + book);
		System.out.println("name is : " + name);
//		Bag<Book> bag = new Bag<>(); //기본 생성자가 없어서
//		bag.setThing(new Book());
//		bag.showType();
//		
	}
}