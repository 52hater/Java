package BackJoon;

import java.util.Scanner;

public class Arithmetic4_10869 {
	public static void main(String[] args) {

		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("숫자 입력 : ");

			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(a+b);
			System.out.println(a-b);
			System.out.println(a*b);
			if (b != 0) {
				System.out.println(a/b);
			} else {
				System.out.println("0으로 나눌 수 없음");
			}
		} catch (Exception e) {

		}

	}

}
