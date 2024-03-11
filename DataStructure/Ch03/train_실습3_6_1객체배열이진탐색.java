package DataStructure.Ch03;

/*
 * Comparable 구현
 */
/*
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2>{//인터페이스, 껍데기만 갖고있고, 구현해야지
	String name;
	int height;
	double vision;

	@Override
	public String toString() {
		
	}
	@Override
	public int compareTo(PhyscData2 p) {//컴페어투는 피직스데이타의 메소드/ 이 메소드는 뒤 클래스의 내부메소드
		
	}
	public int equals(PhyscData2 p) {
		
	}
}
public class train_실습3_6_1객체배열이진탐색 {
	static void sortData(PhyscData2[] arr) {//여기서 확장형 for 문(for-each문)쓰면 인덱스가 없어서 swap 이 안됨 : 부적합
		Arrays.binarySearch(null, null, null)
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					swap(arr, i, j);//작은 함수를 만들어서 그걸 이용
				}
			}
			
		}
	}


	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("나동", 164, 1.3),
				new PhyscData2("최길", 152, 0.7),
				new PhyscData2("김홍길동", 172, 0.3),
				new PhyscData2("박동", 182, 0.6),
				new PhyscData2("이동", 167, 0.2),
				new PhyscData2("길동", 167, 0.5),
		};
		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		reverse(data);
		showData("역순 재배치후", data);
		Arrays.sort(data);//사용된다 그 이유는? //시력가지고 정렬>
		//data=배열, 정렬>>배열원소간의 비교 if data[i] > data[j]
		// >>> compareTo() > 피직스 데이타를 갖다쓴거?
		showData("Arrays.sort() 정렬후", data);
		
		PhyscData2 key = new PhyscData2("길동", 167, 0.2);
		int resultIndex = linearSearch(data, key);
		System.out.println("\nlinearSearch(<길동,167,02>): result = " + resultIndex);
		
		key = new PhyscData2("박동", 182, 0.6);
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);//comparable를 사용//요거는 내가 구현하는거
		System.out.println("\nbinarySearch(<박동,182,0.6>): result = " + resultIndex);
		key = new PhyscData2("이동", 167, 0.6);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);//comparable를 사용//요거는 자바에서 제공
		System.out.println("\nArrays.binarySearch(<이동,167,0.6>): result = " + resultIndex);
		//여기서 객체를 비교할거잖 >  키의 객체는 컴페러블을 갖다쓴다?
	}
	
	

}
