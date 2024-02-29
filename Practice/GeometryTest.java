package Practice;

import java.util.function.Function;

//최상위 추상클래스 지오메트리 생성 -> 추상 메서드로 면적구하는 메서드 선언
//자식 클래스들 생성 -> 원 직사각형 삼각형
//이런식으로 주석만 남겨두고 그걸토대로 코딩
//나중엔 저런식으로 주석을 달아놓고 큰그림을 그리고 그걸 토대로 코딩

//면적구하기

abstract class Geometry {
	abstract double getArea();

}

class Circle extends Geometry {

	int radius;

	Circle(int radius) {
		this.radius = radius;
	}

	double circleArea() {
		return radius * radius * Math.PI;

	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
}

class Rectangle extends Geometry {
	int width;
	int height;

	Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return (double)(width * height);
	}

}

class Triangle extends Geometry {
	int width;
	int height;

	Triangle(int width, int height) {
		this.width = width;
		this.height = height;

	}


	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return (double)(width * height * 0.5);
	}

}



public class GeometryTest {//퍼블릭클래스는 1개만
	public static void main(String[] args) {
		Function<Geometry, Double> func = (g) -> {
			return g.getArea();
		};
		System.out.println("원 면적 : " + func.apply(new Circle(5)));
		System.out.println("사각형 면적 : " + func.apply(new Rectangle(5, 10)));
		System.out.println("삼각형 면적 : " + func.apply(new Triangle(5, 10)));
	}
}
