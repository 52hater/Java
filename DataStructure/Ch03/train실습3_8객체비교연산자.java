package DataStructure.Ch03;

import java.util.Arrays;
import java.util.Comparator;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData3 {//우리가 만드는 클래스
	String name;
	int height;
	double vision;

	public PhyscData3(String name, int height, double vision) {
		// TODO Auto-generated constructor stub

		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	
	
	@Override
	public String toString() {
		return "PhyscData3 [name=" + name + ", height=" + height + ", vision=" + vision + "]";
	}



	class CompName implements Comparator<PhyscData3>{//인터페이스 컴퍼레이터, 피직스데이터3가//클래스명 Comp로
		//인터페이스를 구현한 클래스, 필드없음 단지 컴페어를 구현한 메소드만 있는 것(데이터는 안갖고있다)
		//인터페이스는 추상메소드만 있지, compare(Ta1, Ta2)추상메소드,,T는 PhyscData3
		//여기서 제네릭타입 T가 PhyscData3임
		//따라서 CompName 클래스는 PhyscData3 객체를 비교하는 Comparator 를 구현 한 클래스
		//제네릭 타입은 모든 데이터 타입을 포괄할 수 있는 것이 아님
		//제네릭 타입은 코드를 작성할 때 특정한 데이터 타입을 지정하지 않고
		//대신 나중에 그 코드를 사용할 때 데이터 타입을 지정할 수 있도록 하는 일종의 매개변수 역할
		//제네릭 타입을 정의할 때 보통 <T>와 같은 형태로 정의하며 T는 단순히 임의의 식별자
		//이후 코드에서 실제 사용될 데이터 타입으로 대체됨
		//124p 
		//implements > 상속이 아니라 구현
		public int compare(PhyscData3 p1, PhyscData3 p2) {
			if (p1.name.compareTo(p2.name) > 0) return 1;
			else if (p1.name.compareTo(p2.name) < 0) return -1;
			else {
				return 0;
			}
		}

		//	public class CompName implements Comparator<PhyscData3> {
		//	    @Override
		//	    public int compare(PhyscData3 p1, PhyscData3 p2) {
		//	        // 이름을 기준으로 비교
		//	        return p1.name.compareTo(p2.name);
		//	    }
		//	}


	}

	class CompHeight implements Comparator<PhyscData3>{//인터페이스 컴퍼레이터, 피직스데이터3가
		public int compare(PhyscData3 p1, PhyscData3 p2) {
			if (p1.height > p2.height) return 1;
			else if (p1.height < p2.height) return -1;
			else {
				return 0;
			}
		}

	}

	class CompVision implements Comparator<PhyscData3>{
		public int compare(PhyscData3 p1, PhyscData3 p2) {
			if (p1.vision > p2.vision) return 1;
			else if (p1.vision < p2.vision) return -1;
			else {
				return 0;
			}
		}
	}
}

public class train실습3_8객체비교연산자 {
	static final Comparator<PhyscData3> HEIGHT_ORDER = new CompHeight();

	static void showData(String msg, PhyscData3[]data) {
		System.out.println(msg + " :: ");
		System.out.println();
		for (PhyscData3 elem : data) {
			System.out.println(elem + " ");
		}

	}

	public static void main(String[] args) {
		PhyscData3[] data = {//data는 주소만 갖고있는 참조변수야 > . 찍어도 소용없어 > Arrays.binarySearch(컴퍼레이터)
				new PhyscData3("홍길동", 162, 0.3),
				new PhyscData3("홍동", 164, 1.3),
				new PhyscData3("홍길", 152, 0.7),
				new PhyscData3("김홍길동", 172, 0.3),
				new PhyscData3("길동", 182, 0.6),
				new PhyscData3("길동", 167, 0.2),
				new PhyscData3("길동", 167, 0.5),
		};//필요에 따라 이름가지고 찾고 키가지고 찾고 > 편리해(컴퍼레이터)
		//Arrays.binarySearch(data, key, new CompName);//. 찍을때 보면 제너릭으로 되어있음// new CompHeight()
		//T 클래스 physcData, 타입 변수 타입 변수 타입 c변수의타입: Comparator<w>/w는 컴퍼레이터에 들어가는 타입/w=<? super T> ?는 와일드카드
		//슈퍼 > 다된다
		//124 p 맨 위
		showData("정렬전 객체 배열", data);
		Arrays.sort(data, HEIGHT_ORDER);//하이트오더>CompName()을 구현한 객체

		showData("정렬후 객체 배열", data);
		PhyscData3 key = new PhyscData3("길동", 167, 0.2);
		Arrays.binarySearch(data, key, new CompHeight());

		int idx = Arrays.binarySearch(data, key, HEIGHT_ORDER);//파라미터 보면 전부 객체를 던져주는 형태
		System.out.println("\nArrays.binarySearch(): result = " + idx);
	}

}
