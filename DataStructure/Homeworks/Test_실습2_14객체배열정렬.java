package DataStructure.Homeworks;

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
	String PhyscData[];

	@Override
	public String toString() {
		return name + height + vision;
	}
	@Override
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

	public int equals_int(PhyscData p) {//boolean 으로 하면 안되나
	}
	
	/*public boolean equals_boolean(PhyscData p) {
		if (vision == p.vision) {
			return true;
			if (height == p.height) {
				return true;
				if ()
			}
		}
	}*/
	
	public boolean equals_boolean(PhyscData p) {
		if (arr1.length != arr2.length) 
			return false;
		
		if (arr1 == null || arr2 == null) 
			return false;
		
		for (int i = 0; i < arr1.length; i++) {
			arr[i]
		}
	}

	public class Test_실습2_14객체배열정렬 {
		static void swap(PhyscData[]arr, int ind1, int ind2) {
			PhyscData swapArr = arr[ind1];
			arr[ind1] = arr[ind2];
			arr[ind2] = swapArr;

		}
		static void sortData(PhyscData []arr) {//위에 메소드 만든거 이용해서 정렬
			for(int i = 0; i < arr.length; i++) {
				for(int j = i + 1; j < arr.length; j++) { 
					if (arr[i].compareTo(arr[j]) > 0) {
						swap(arr, i, j);
					}
				}
			}
		}
		static void showData(PhyscData[]arr) {
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
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
		showData("unsorted data : " + data);
		sortData(data);
		//Arrays.sort(null, null);//comparator가 필요하다 
		showData("sorted data : " + data);
		equals_int();
		showData();
		equals_boolean();
		showData();
	}

