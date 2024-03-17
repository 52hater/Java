package DataStructure.Ch02.Homeworks;

import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData> {//컴페레이터 컴페러블
	//인터페이스 컴퍼레이터 컴퍼러블 사용하는거//인터페이스니까 임플먼츠
	//2장, 3장에서 컴퍼레이터 컴퍼러블 복습
	//컴페어투 사용하는 것이 숙달되는게 이번 과제의 목표
	//구글링: comparator, comparable 차이가 무엇, 사용예는 무엇, 파악하고 내 상황에 맞게 적용하는것이 능력
	//comparable, comparator >> 인터페이스
	//comparable>compartTo() / comparator>compare()
	//어느경우에 사용?
	//class A implements Comparable<A>
	String name;
	int height;
	double vision;

	public PhyscData (String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public String toString() {
		return "PhyscData [name=" + name + ", height=" + height + ", vision=" + vision + "]";
	}
	
	public int compareTo(PhyscData p) { //객체가 와야되는데 파라미터를 없애고 compare(int n) 이런식으로 하면
		//compareTo()를쓰는 이유는 통일된 인터페이스를 쓰기 위함
		//나 이외의 팀원들도 보기때문에 통일된 기준을 세워야함
		//자바에서 인터페이스 > 통일된 기준을 제시
		//여기서는 객체에 대한 비교를 하는 
		//data[0] 수신객체, compareTo() 메소드, 파라미터
		if (vision > p.vision)
			return 1;
		else if(vision < p.vision)
			return -1;
		else
			return 0;
		//현재 객체의 값이 매개변수의 객체보다 크면 1, 작으면 -1을 반환해서 comparTo 이용해서 오름차순으로 정렬
		//현재 객체와 매개변수의 객체 p 를 비교하는 것
	}
	
	//PhyscData 클래스가 Comparable<PhyscData> 인터페이스를 구현하도록 선언되어있어서
	//반드시 compareTo(PhyscData)를 구현을 해야되는데
	//compareToVison, compareToHeight, compareToName 이렇게 세개를 쓰면
	//compareTo의 구현이 없어서 오류가 남
	//compareTo를 하나만 구현해서 이름순/키순/시력순정렬 이 세가지를 하고싶은데
	//메소드를 또 따로 세개를 만드는 간결하지 못한 행동을 해야하는 것 같아서 포기
	
	public int compareToHeight(PhyscData p) {
		if (height > p.height)
			return 1;
		else if(height < p.height)
			return -1;
		else
			return 0;
	}
	
	public int compareToName(PhyscData p) {//컴페어투로 비교하니까 데이터타입 int
		if (name.compareTo(p.name) > 0)
			return 1;
		else if(name.compareTo(p.name) < 0)
			return -1;
		else
			return 0;
		
	}

	public boolean equals_boolean(PhyscData p) {
		return this.name == p.name && this.height == p.height && this.vision == p.vision;
	}
}

public class Test_실습2_14객체배열정렬 {
	static void swap(PhyscData[]data, int ind1, int ind2) {
		PhyscData swapData = data[ind1];
		data[ind1] = data[ind2];
		data[ind2] = swapData;

	}
	static void sortDataVision(PhyscData []data) {//위에 메소드 만든거 이용해서 정렬
		for(int i = 0; i < data.length; i++) {
			for(int j = i + 1; j < data.length; j++) { 
				if (data[i].compareTo(data[j]) > 0) {
					swap(data, i, j);
				}
			}
		}
	}
	
	static void sortDataHeight(PhyscData []data) {//위에 메소드 만든거 이용해서 정렬
		for(int i = 0; i < data.length; i++) {
			for(int j = i + 1; j < data.length; j++) { 
				if (data[i].compareToHeight(data[j]) > 0) {
					swap(data, i, j);
				}
			}
		}
	}
	
	static void sortDataName(PhyscData []data) {//위에 메소드 만든거 이용해서 정렬
		for(int i = 0; i < data.length; i++) {
			for(int j = i + 1; j < data.length; j++) { 
				if (data[i].compareToName(data[j]) > 0) {
					swap(data, i, j);
				}
			}
		}
	}


	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2),
				new PhyscData("최길동", 169, 0.5),
		};

		//data[0].(객체.)compareTo data[0] 이 객체는 클래스에 구현
		showData("unsorted data : " , data);
		System.out.println();
		
		sortDataVision(data);
		showData("sorted data(vision) : " , data);
		System.out.println();
		
		sortDataHeight(data);
		showData("sorted data(height) : " , data);
		System.out.println();
		
		sortDataName(data);
		showData("sorted data(Name) : " , data);
		System.out.println();
		
		
		System.out.println("data[0] == data[1]: " + data[0].equals_boolean(data[1]));
	    System.out.println("data[0] == data[2]: " + data[0].equals_boolean(data[2]));
	    System.out.println("data[1] == data[2]: " + data[1].equals_boolean(data[2]));
	    
	    //Arrays.sort(null, null);//comparator가 필요하다 
	}

	static void showData(String message, PhyscData[]data) {
			System.out.println(message);
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i].toString());
		}			
	}

}

