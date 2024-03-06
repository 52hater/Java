package Chap2_기본자료구조;

public class Test_실습2_14스트링배열정렬 {
public class 실습2_14스트링배열정렬 {
	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", "melon", "oriental melon"};

		showData(data);
		sortData(data);
		showData(data);
	}
	static void showData(String[]arr) {
		for(String name : arr)
			System.out.println(name);//각원소 가져오는거지
	}
	}

	static void swap(String[]arr, int ind1, int ind2) {	
	}
	static void sortData(String []arr) {
		for (int i = 0;)
			for (int j = i+1;) {
				if (arr[i] > arr[j]) //스트링에 compareTo()메소드를 사용하는 것을 자가공부해서 해봐라 
					swap(arr, i, j); //정수일때 스왑을 불렀어 //여튼 스트링버전으로 해봐
			}
	}

}
