package DataStructure.Training1;

import java.util.Arrays;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;
public class train_실습2_5정수배열정렬 {

	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData(data);

		sortData(data);//정렬프로그램을 직접코딩해봐
		showData(data);

		reverse(data);//역순으로 재배치 - 정렬 아님//역순으로 해봐 
		showData(data);
		
		reverseReverse(data);
		showData(data);

		reverseSort(data);//역순으로 재배치 - 정렬 아님 
		showData(data);

		Arrays.sort(data); //어레이클래스에 스태틱솔트 메소드가 정의되어있다//내가 코딩하지않고 자바라이브러리를 통한 정렬
	}
	static void showData(int[]data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");//이게 왜 안되지... 출력 연습/개념자체 이해
		}
		System.out.println();
	}
	static void inputData(int []data) {//난수 생성해서 데이터 입력
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(10);
		}
	}
	static void swap(int[]arr, int ind1, int ind2) {//교재 67페이지
		int t = arr[ind1]; arr[ind1] = arr[ind2]; arr[ind2] = t;
	}
	static void sortData(int []arr) {//배열을 정렬한걸 만드는 //오름차순 정렬
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++ ) {
				if(arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}
	static void reverse(int[] arr) {//교재 67페이지 책에 있는거 가져와서/단순히 reverse만 해주는 메소드네
		for (int i = 0; i < arr.length / 2; i++)
			//처음과 끝을 한 쌍으로 보고 서로 바꿔줌, 그래서 /2
			swap(arr, i, arr.length - i - 1);
	}
	
	static void reverseReverse(int[] arr) {//리버스를 리버스?
		for (int i = 0; i < arr.length / 2; i++)
			swap(arr, i, arr.length - i - 1);
	}
	
	static void reverseSort(int[] arr) { // 거꾸로 정렬//내림차순 정렬이지//Sort 를 리버스?
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

}
