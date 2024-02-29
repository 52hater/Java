package Practice;

import java.util.Scanner;

public class PrimeNumber1 {
	
	static Boolean isPrimeNumber(int num) {
	
//		boolean result = false;
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {//sc.close();를 트라이위드리소스문으로
				System.out.print("num : ");
			
			int num = sc.nextInt();
			
			int s = (int)Math.pow(10.0, (double)(num-1));
			int e = (int)Math.pow(10.0, (double)(num))-1;
			
			for (int i = s; i <= e; i++) {
				if (isPrimeNumber(i) == true) {
					System.out.println(i);
				}
			}
			
		}
		System.out.println("done");
	}

}


/*int s = (int)Math.pow(10.0, (double)(num-1));
int e = (int)Math.pow(10.0, (double)(num))-1;

int s = (int)Math.pow(10.0, (double)(num-1));
이 라인은 범위의 시작 값을 계산합니다.
Math.pow(10.0, (double)(num-1))은 10을 num-1 승으로 계산합니다.
(int)는 결과를 정수 형식으로 캐스팅합니다.

int e = (int)Math.pow(10.0, (double)(num))-1;
이 라인은 범위의 끝 값을 계산합니다.
Math.pow(10.0, (double)(num))은 10을 num 승으로 계산합니다.
(int)는 결과를 정수 형식으로 캐스팅합니다.

-1은 결과에서 1을 뺍니다.
요약하면, 이 코드는 길이 num의 숫자 범위의 시작과 끝 값을 계산하는 데 사용됩니다.
예를 들어, num이 3이면, s는 100이 되고 e는 999가 되어 100부터 999까지의 범위를 나타냅니다.*/