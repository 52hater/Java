package BillCount3;

import java.util.Scanner;

public class BillCount3 {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("금액 입력 : ");
			int price = sc.nextInt();
			int[] pmoneys = {50000, 10000, 5000, 1000};
			
			for(int numOfFif = 0; numOfFif <= price/50000; numOfFif++) {
				for(int numOfTen = 0; numOfTen <= price/10000; numOfTen++) {
					for(int numOfFiv = 0; numOfFiv <= price/5000; numOfFiv++) {
						for(int numOfOne = 0; numOfOne <= price/1000; numOfOne++) {
							if(numOfFif*50000 + numOfTen*10000 + numOfFiv*5000 + numOfOne*1000 == price) {
								System.out.println("5만원권 : " + numOfFif + "장 /" + " 1만원권 : " + numOfTen + "장 /" + " 5천원권 : " + numOfFiv + " 1천원권 : " + numOfOne + "장\n");
							}
						}
					}
				}
			}
			
//			int fifBill = price / 50000; //가격을 5만원으로 나눠
//			price %= 50000; //오만원권다쓰고 나머지 값 price
//			
//			int tenBill = price / 10000;
//			price %= 10000;
//			
//			int fivBill = price / 5000;
//			price %= 5000;
//			
//			int oneBill = price / 1000;
//			price %= 1000;
			
//			System.out.print("5만원권 " + fifBill + "장 /");
//			System.out.print("1만원권 " + tenBill + "장 /");
//			System.out.print("5천원권 " + fivBill + "장 /");
//			System.out.print("1천원권 " + oneBill + "장 \n");
//			System.out.println("잔액 : " + price);
		}

	}


}