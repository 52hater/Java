package com.ruby.java.ch08.polymorphism;
/*
 * 인터페이스 다형성 실습 코드
 * 과제2:추상클래스상속 / 과제3:인터페이스구현상속
 */
interface Vehicle {//인터페이스로 만들어짐, 참조변수, 아직 어디를 가리킨 건 아님
	public abstract void showVehicle();//추상메소드만들고
}
class Truck implements Vehicle {//상속
	int weight;
	public Truck(int weight) {//생성자
		this.weight=weight;
	}
	public void showVehicle() {//추상메소드니까 구현, 웨이트 출력하는거
		System.out.println("Truck: weight="+weight);
	}
}
class Car implements Vehicle {
	int vehicleOccupants;
//	public Car(int vehicleOccupants) {
//		this.vehicleOccupants=vehicleOccupants;
//	}
//	public void showVehicle() {
//		System.out.println("Car: vehicleOccupants="+vehicleOccupants);	
//	} //숙제는 이걸 구현하란것
}
class Taxi extends Car {//택시는 카의 익스텐드
	int mileage;//필드만 주어진 상태가 문제초기상태
//	public Taxi(int vehicleOccupants, int mileage ) {
//		super(vehicleOccupants);//카의 생성자를//
//		this.mileage=mileage;//승차인원, 마일리지를 다
//	}
//	public void showVehicle() {
//		super.showVehicle();
//		System.out.println("Taxi: mileage="+mileage);
//	}
}
class MotorCycle implements Vehicle{
	int price;
//	public MotorCycle(int price) {
//		this.price=price;
//	}
//	public void showVehicle() {
//		System.out.println("MotorCycle: price="+price);
//	}
}
public class Test_cha08_인터페이스다형성실습 {
	public static void displayVehicles(Vehicle [] a) {//스태틱메소드
		for (Vehicle v : a) {
			v.showVehicle();
		}
	}
public static void main(String[] args) {
	Vehicle [] arr = new Vehicle[5];//배열을 만든 것(객체를 만든 게 아님)//추상이나 인터페이스에선 이게 가능하다는 것
	arr[0] = new Truck(33);//트럭객체만들고
	arr[1] = new Car(4);//카객체만들고
	arr[2] = new Taxi(2, 9000);//어쩌고저쩌고해서 객체들의 배열을 함수에(?) 전달
	arr[3] = new Truck(22);
	arr[4] = new MotorCycle(12000);

	displayVehicles(arr);
}
}
