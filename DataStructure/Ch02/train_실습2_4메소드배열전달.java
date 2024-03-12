package DataStructure.Ch02;

import java.util.Random;

//메소드에 배열 전달 실습부터
//실습 설명한다 
//매개변수로 배열 전달

public class train_실습2_4메소드배열전달 {

	public static void main(String[] args) {
		int []data = new int[10];
		//함수호출할떈 이름만쓰고
		inputData(data);
		showData(data);
		int max = findMax(data);
		System.out.println("\nmax = " + max);
		boolean existValue = findValue(data, 5);
		System.out.println("찾는 값 = " + 5 + ", 존재여부 = " + existValue);
	}
	static void showData(int[]data) {//받을떄는 데이터타입까지 하고//메소드에 배열을 전달하는거
		for (int num: data) {//확장형 for 문
			System.out.print(num+" ");
		}
	}
	public static void inputData(int []data) {//교재 63 - 난수의 생성해서 for 문 돌려서
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(10);
		}

	}
	static int findMax(int []items) {//최대값구해서 리턴 //여기서 static 뒤에 int 가 없어서 오류가 났음
		int max = items[0];
		for (int i = 0; i < items.length; i++) {
			if (items[i] > max) {
				max = items[i]; //처음에 좌변우변 위치가 바뀌어서 최대값을 못찾았음
				//max 값을 찾는거니까 for 문을 돌려서 찾은 item[]최댓값 i 값이 max 로 대입이 되어야 하는거지 
			}
		}
		return max; //for 문에서 빠져나오고 리턴값 보내야지

	}
	static boolean findValue(int []items, int value) {
		//items[]에 value 값이 있는지를 찾는 알고리즘 구현
		boolean existValue = false;
		for (int i = 0; i < items.length; i++) {
			if (items[i] == value) {
				return true;
			}
		}
		return false;
	}

}
