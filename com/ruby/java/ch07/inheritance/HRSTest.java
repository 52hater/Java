package com.ruby.java.ch07.inheritance;//abstraction

abstract class Workers {
	String name;
	int salary;
	
	public abstract void calcSalary();
	public abstract void calcBonus();
}

class Salesman extends Workers {//구현을 했다 > 바디가 있다
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
	}
	
	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 4");
	}
}


class Consultant extends Workers {
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
	}
	
	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2");
	}
}

abstract class Manager extends Workers {
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}
}

class Director extends Manager {//여기는 바디가 없어 > 추상메서드?
	public void calcBonus() {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
	}
}


public class HRSTest {
	public static void calcTax(Employee e) {
		if (e instanceof Salesman)
			System.out.println("Salesman");
		else if (e instanceof Manager)
			System.out.println("Manager");
			}
	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Director d = new Director();
		Object s3 = new Salesman();
		Object arr[] = new Object[6];
		Manager m = new Manager();
		arr[0] = s;arr[1] = e;arr[2] = d;
		arr[3] = s3;arr[4] = s;
		//여기에 매니저 보너스 그거 만들 수 없어 > 추상클래스는 객체(인스턴스)를 만들 수 없음(308~309)
		
		HRSTest.calcTax(s);
		calcTax(e);
		calcTax(d);
		calcTax(m);
		s.calcSalary();
		c.calcSalary();
		d.calcSalary();
		s.equals(s);
		System.out.println(s.toString());
	}

}
