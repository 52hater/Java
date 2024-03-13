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
//처음에 메소드들을 인터페이스 안에 넣어서 오류
//인터페이스 내부에 메소드가 없어야되지
//인터페이스 클래스의 메소드라서 오류가 나는건가? 그냥 인터페이스 내부에 메소드가 없어야해서 오류난것같음

class PhyscData2 implements Comparable<PhyscData2>{//인터페이스, 껍데기만 갖고있고, 구현해야지
	String name;
	int height;
	double vision;

	//생성자로 메인에 주어진 데이터로부터 객체를 생성하고 초기화
	public PhyscData2(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public String toString() {
		return "PhyscData2 [name=" + name + ", height=" + height + ", vision=" + vision + "]";
	}
	
//	@Override
//	public int compareTo(PhyscData2 p) {//컴페어투는 피직스데이타의 메소드/ 이 메소드는 뒤 클래스의 내부메소드
//		return this.name.compareTo(p.name);
//	}
	
	//위의 메소드는 Arrays.binarySearch에서 name 만 고려하기 때문에
	//완벽하게 동일한 객체인 지 판단할 수 없음
	//따라서 name 비교 >> height 비교 >> vision 비교의 프로세스를 거쳐야
	//확실한 객체비교를 할 수 있음
	
	@Override //이거는 챗봇이 짜준코드니까 다시 공부하면서 이해!
	public int compareTo(PhyscData2 p) {
	    if (this.name.equals(p.name)) {
	        if (this.height == p.height) {
	            return Double.compare(this.vision, p.vision);
	        } else {
	            return Integer.compare(this.height, p.height);
	        }
	    } else {
	        return this.name.compareTo(p.name);
	    }
	}
	
	//	public int equals(PhyscData2 p) {
	//		
	//	}

	public boolean equals_boolean(PhyscData2 p) {
		return this.name == p.name && this.height == p.height && this.vision == p.vision;
	}

	
}

public class train_실습3_6_1객체배열이진탐색 {
	static void swap(PhyscData2[]arr, int ind1, int ind2) {
		PhyscData2 swapArr = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = swapArr;
	}

	static void sortData(PhyscData2[] arr) {//여기서 확장형 for 문(for-each문)쓰면 인덱스가 없어서 swap 이 안됨 : 부적합
		//Arrays.binarySearch(null, null, null)
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					swap(arr, i, j);//작은 함수를 만들어서 그걸 이용
				}
			}

		}

	}

	static void reverse(PhyscData2[] arr) {//교재 67페이지 //치환문
		for (int i = 0; i < arr.length / 2; i++) {//i 참조변수, reverse_arr : 참조변수의 주소를 갖고있따
			PhyscData2 reverse_arr = arr[i];//변수선언,  i 의 주소를 가짐
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = reverse_arr;
		}

	}

	static int linearSearch(PhyscData2[] arr, PhyscData2 key) {
		for(int i = 0; i < arr.length; i++) {
			if (arr[i].equals(key))
				//equals 는 Object 클래스에 정의되어 있는 메소드이며,
				//String 클래스에서 이를 오버라이딩하여 사용한다.
				//매개변수로 전달된 문자열을 비교하며 boolean 값을 반환한다.
				
				//compareTo는 두 문자열이 단순히 같은지 아닌지를 알려줄 뿐만 아니라
				//어떤것이 사전적인 순서로 더 앞,뒤에 존재하는지를 알려준다.	
				
				return i;
		}
		return -1;
	}

	static int binarySearch(PhyscData2[] arr, PhyscData2 key) {
		int pl = 0;
		int pr = arr.length - 1; //0부터 시작하니까

		while (pl <= pr) {
			int pc = (pl + pr) / 2;
			int compare = arr[pc].compareTo(key);

			if (compare == 0) { //검색성공하면
				return pc;//중간인덱스 리턴
			} else if (compare < 0) {
				pl = pc + 1;//중간인덱스보다 크면 오른쪽부분 검색
			} else {
				pr = pc - 1;//중간인덱스보다 작으면 왼쪽부분 검색
			}
		}
		return -1;//없으면 -1 리턴
	}

	static void showData(String msg, PhyscData2[] data) {
		System.out.println(msg + " :: ");
		System.out.println();
		for (PhyscData2 elem : data) {
			System.out.println(elem + " ");
		}
		System.out.println();
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
		System.out.println();

		sortData(data);
		showData("정렬후", data);
		System.out.println();

		reverse(data);
		showData("역순 재배치후", data);
		System.out.println();

		Arrays.sort(data);//사용된다 그 이유는? //시력가지고 정렬>
		//data=배열, 정렬>>배열원소간의 비교 if data[i] > data[j]
		// >>> compareTo() > 피직스 데이타를 갖다쓴거?
		showData("Arrays.sort() 정렬후", data);
		System.out.println();

		System.out.println("data[0] == data[1]: " + data[0].equals_boolean(data[1]));
		System.out.println("data[0] == data[2]: " + data[0].equals_boolean(data[2]));
		System.out.println("data[1] == data[2]: " + data[1].equals_boolean(data[2]));

		PhyscData2 key = new PhyscData2("길동", 167, 0.2);
		int resultIndex = linearSearch(data, key);
		System.out.println("\nlinearSearch(<길동,167,0.2>): result = " + resultIndex);

		key = new PhyscData2("박동", 182, 0.6);
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);//comparable 을 사용//요거는 내가 구현하는거
		System.out.println("\nbinarySearch(<박동,182,0.6>): result = " + resultIndex);
		key = new PhyscData2("이동", 167, 0.6);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);//comparable 을 사용//요거는 자바에서 제공
		System.out.println("\nArrays.binarySearch(<이동,167,0.6>): result = " + resultIndex);
		//여기서 객체를 비교할거잖 >  키의 객체는 컴페러블을 갖다쓴다?
	}

}
