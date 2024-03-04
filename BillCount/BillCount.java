package BillCount;

import java.util.Scanner;

public class BillCount {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("금액 입력 : ");
			int price = sc.nextInt();

			int fifThouBill = 50000;
			int tenThouBill = 10000;
			int fivThouBill = 5000;
			int oneThouBill = 1000;

			int numOfFifThouBill = 0;
			int numOfTenThouBill = 0;
			int numOfFivThouBill = 0;
			int numOfOneThouBill = 0;
			
			//미션1. 모든 경우의 수 로직 추가해보면?
			//미션2. %연산자로 더 간단하게도 가능할 듯??
			//미션3. 성공하면 파이썬으로 옮겨보자

			while(price > 999) {
				if(price >= fifThouBill) {
					price -= fifThouBill;
					numOfFifThouBill++;
				} else if(price >= tenThouBill) {
					price -= tenThouBill;
					numOfTenThouBill++;
				} else if(price >= fivThouBill) {
					price -= fivThouBill;
					numOfFivThouBill++;
				} else if(price >= oneThouBill) {
					price -= oneThouBill;
					numOfOneThouBill++;
				} 
			}
			System.out.println("잔돈 : " + price);

			System.out.println("5만원권 " + numOfFifThouBill + "장");
			System.out.println("1만원권 " + numOfTenThouBill + "장");
			System.out.println("5천원권 " + numOfFivThouBill + "장");
			System.out.println("1천원권 " + numOfOneThouBill + "장");
		}

	}


}