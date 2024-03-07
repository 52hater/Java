package DataStructure.Homeworks;

import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData>{//컴페레이터 컴페러블
	//인터페이스 컴퍼레이터 컴퍼러블 사용하는거//인터페이스니까 임플먼츠
	//2장, 3장에서 컴퍼레이터 컴퍼러블 복습
	//컴페어투 사용하는 것이 숙달되는게 이번 과제의 목표
	//구글링: comparator, comparable 차이가 무엇, 사용예는 무엇, 파악하고 내 상황에 맞게 적용하는것이 능력
	String name;
	int height;
	double vision;

	@Override
	public String toString() {

	}
	@Override
	public int compareTo(PhyscData p) {

	}
	public int equals(PhyscData p) {

	}
}
public class 실습2_14객체배열정렬 {
	static void swap(PhyscData[]arr, int ind1, int ind2) {
		
	}
	static void sortData(PhyscData []arr) {//위에 메소드 만든거 이용해서 정렬
		for(int i = 0;)
			for(int j = 0;)
				//if(arr[i] > arr[j])
				if (arr) [i].compareTo(arr[j]) > 0)
					swap(arr, i, j);//빨간줄 걸려 > 컴페어투()가 필요해
		
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
		showData(data);
		sortData(data);
		//Arrays.sort(null, null);//comparator가 필요하다 
		showData(data);
	}
	static void showData(PhyscData[]arr) {

	}

}
